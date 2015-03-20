package fr.esgi.demo.repository;

import fr.esgi.demo.model.Phone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Jeremy on 18/03/15.
 */

@Repository
public interface PhoneRepository extends CrudRepository<Phone, Long> {

    Phone findBySerialNumber(String serialNumber);

    Phone findByNumber(String number);

}

