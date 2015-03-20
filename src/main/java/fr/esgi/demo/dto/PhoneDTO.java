package fr.esgi.demo.dto;

import fr.esgi.demo.model.Phone;
import fr.esgi.demo.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.google.common.collect.FluentIterable.from;

/**
 * Created by Thibault on 20/03/15.
 */
public class PhoneDTO {

    private Long id;

    private String serialNumber;

    private  String number;

    private  String firstname;

    private  String lastname;

    private  Boolean stolen;

    @Autowired PhoneRepository phoneRepository;


    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getSerialNumber() { return serialNumber; }

    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public String getNumber() { return number; }

    public void setNumber(String number) { this.number = number; }

    public String getFirstname() { return firstname; }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    public Boolean getStolen() { return stolen; }

    public void setStolen(Boolean stolen) { this.stolen = stolen; }

}
