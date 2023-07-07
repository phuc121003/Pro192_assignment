package model;

import java.time.LocalDate;

public class Person {
 
    private String id,name,phone,address,email;
    private boolean gender;
    private LocalDate dateOfBirth;
    
    public Person(){}
    
    public Person(String id, String name, String phone, String address, boolean gender,LocalDate dateOfBirth,String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGender() {
        return gender;
    }


    public void setGender(boolean gender) {
        this.gender = gender;
    }


    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }


    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
    String genderString = gender ? "male" : "female";
    return "|" + id + "\t" + name + "\t" + phone + "\t" + phone + "|" + address + "\t" + genderString + "\t" + dateOfBirth + "\t" + email + "|";
    }
}
