package fr.esgi.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Jeremy on 16/03/15.
 */

@RunWith(MockitoJUnitRunner.class)

public class BankingServiceTest {


    private BankService bankService = new BankService();
    //private Account account = new Account();

    @Spy
    private Account account;

    @Mock
    private IAuthorizationService authorizationService;

    @Captor
    private ArgumentCaptor<Integer> amountCaptor;

    @Before
    public void setUp() {

        /*                      Déjà présent dans @Captor
            ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
         */

        account.setBlocked(false);

        when(authorizationService.isAuthorized(any(Account.class))).thenReturn(true);

        bankService.setAuthorizationService(authorizationService);

    }

    @Test
    public void should_AddMoneyToAccount() {

        //Given
        account.setMoney(0);

        //When
        account = bankService.pushMoney(account, 1000);


        //Then
       assertThat(account.getMoney(), is(1000));
    }

    @Test
    public void should_RemoveMoneyToAccount() {

        when(account.getMoney()).thenReturn(1000);

        account = bankService.pushMoney(account, -1000);

        verify(account).setMoney(amountCaptor.capture());

        assertThat(account.getMoney(), is(1000));

    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldNot_AddMoney_WhenAccountIsNull() {

        Account account = null;

        bankService.pushMoney(account, 1000);

    }

    @Test (expected = CreditNotAuthorizedException.class)
    public void shouldNot_RemoveMoney_WhenAccountUnderZero() {

        account.setMoney(0);

        bankService.pushMoney(account, -1000);

    }

    @Test (expected = NotAuthorizedException.class)
    public void shouldNot_AddMoney_WhenAccountIsBlocked() {

        account.setBlocked(true);

        //doReturn(false).when(authorizationService.isAuthorized(account));
        when(authorizationService.isAuthorized(account)).thenReturn(false);

        bankService.pushMoney(account, 1000);
    }

}
