package fr.esgi.demo.model;

import javax.persistence.*;


/**
 * Created by Thibault on 20/03/15.
 */
@Entity
@Table(name ="Phone")
public class Phone {
    @Id
    @GeneratedValue
    Long id;

    @Column
    private String serialNumber;

    @Column
    private  String number;

    @Column
    private  String firstname;

    @Column
    private  String lastname;

    @Column
    private  Boolean stolen;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Boolean getStolen() {
        return stolen;
    }

    public void setStolen(Boolean stolen) {
        this.stolen = stolen;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone)) return false;

        Phone phone = (Phone) o;

        if (!id.equals(phone.id)) return false;

        return true;
    }


}
