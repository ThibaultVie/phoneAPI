package fr.esgi.demo.service;

import com.google.common.collect.Lists;
import fr.esgi.demo.dto.PhoneDTO;
import fr.esgi.demo.model.Phone;
import fr.esgi.demo.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.google.common.collect.FluentIterable.from;

/**
 * Created by Thibault on 20/03/15.
 */
@Service
public class PhoneService {

    @Autowired PhoneRepository phoneRepository;
    private List<PhoneDTO> phones;

    public List<PhoneDTO> findAll() {
        this.phones = Lists.newArrayList();
        List<Phone> phones = from(phoneRepository.findAll()).toList();

        for (Phone phone : phones) {
            PhoneDTO phoneDTO = new PhoneDTO();
            phoneDTO.setId(phone.getId());
            phoneDTO.setSerialNumber(phone.getSerialNumber());
            phoneDTO.setFirstname(phone.getFirstname());
            phoneDTO.setLastname(phone.getLastname());
            phoneDTO.setStolen(phone.getStolen());
            this.phones.add(phoneDTO);
        }

        return this.phones;
    }

    public void setPhone(PhoneDTO phone) {
        Phone newPhone = new Phone();
        newPhone.setSerialNumber(phone.getSerialNumber());
        newPhone.setNumber(phone.getNumber());
        newPhone.setFirstname(phone.getFirstname());
        newPhone.setLastname(phone.getLastname());
        newPhone.setStolen(phone.getStolen());
        phoneRepository.save(newPhone);
    }
}
