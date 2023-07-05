package model;

import java.time.LocalDate;

public class Person {
    private String id,name,phone,address;
    private boolean gender;
    private LocalDate dateOfBirth;

    public Person(String id, String name, String phone, String address, boolean gender, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public Person() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public boolean isGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + '}';
    }
}
