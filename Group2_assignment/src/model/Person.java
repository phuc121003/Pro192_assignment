package model;

import java.time.LocalDate;

public class Person {
    private String id,name,phone;
    private LocalDate dateOfBirth;

    public Person(String id, String name, String phone, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.phone = phone;
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

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", phone=" + phone + ", dateOfBirth=" + dateOfBirth + '}';
    }
}
