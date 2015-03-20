package fr.esgi.demo.controller;

import com.google.common.collect.Lists;
import fr.esgi.demo.dto.PhoneDTO;
import fr.esgi.demo.model.Phone;
import fr.esgi.demo.repository.PhoneRepository;
import fr.esgi.demo.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.List;

import static com.google.common.collect.FluentIterable.from;

/**
 * Created by Thibault on 20/03/15.
 */
@RestController
@RequestMapping("/phone")
public class PhoneController {

    private List<PhoneDTO> phones = Lists.newArrayList();
    @Autowired PhoneRepository phoneRepository;
    @Autowired PhoneService phoneService;

    /**
     * GET
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<PhoneDTO> getPhones(){
        return this.phoneService.findAll();
    }

    /**
     * *
     * GET
     * @param phoneId
     * @return
     */

    @RequestMapping(value = "/{phoneId}", method = RequestMethod.GET)
    public PhoneDTO getPhoneById(@PathVariable final Long phoneId) {

        PhoneDTO findPhone = null;
        for (PhoneDTO phone : this.phoneService.findAll()){
            if(phone.getId() == phoneId) {
                findPhone = phone; break;
            }
        }

        return findPhone;
    }

    /**
     * DELETE
     * @param phoneId
     * @return
     */

    @RequestMapping(value = "/{phoneId}", method = RequestMethod.DELETE)
    public PhoneDTO deletePhoneById(@PathVariable final Long phoneId) {

        PhoneDTO findPhone = null;
        for (PhoneDTO phone : this.phoneService.findAll()){
            if(phone.getId() == phoneId) {
                findPhone = phone;
                this.phones.remove(findPhone);
                break;
            }
        }

        return findPhone;
    }

    /**
     * POST
     * @param phone
     * @return
     */

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody PhoneDTO createPhone(PhoneDTO phone) {
        this.phoneService.setPhone(phone);
        return phone;
    }

    /**
     * PUT
     * @param phone
     * @return
     */

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody Phone updatePhone(Phone phone) {

        Phone phoneFound = this.phoneRepository.findBySerialNumber(phone.getSerialNumber());
        phoneFound.setStolen(phone.getStolen());
        this.phoneRepository.save(phoneFound);
        return phone;

    }

}
