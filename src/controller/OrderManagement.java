package controller;

import View.MenuRoom;
import View.Validation;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Predicate;

import model.Customer;
import model.Room.Room;

public class OrderManagement {
    private ArrayList<Customer> customerOrder = new ArrayList<>();
    private MenuRoom menuRoom = new MenuRoom();

    public OrderManagement() {
        Scanner sc = new Scanner(System.in);
    }


    // -----------------------------------------------------------
    public boolean OrderRoom() {
        String id = Validation.getString("Enter customer's id: ", Validation.REGEX_ID);
        String name = Validation.getString("Enter customer's name: ", Validation.REGEX_NAME);
        String phone = Validation.getString("Enter customer's phone:", Validation.REGEX_PHONE);
        String genderStr = Validation.getString("Enter customer's gender (true = male;false = female):", Validation.REGEX_GENDER);
        boolean gender = Boolean.parseBoolean(genderStr);
        // LocalDate dateOfBirth = Validation.getDate("Enter customer's date of birth: ");
        String email = Validation.getString("Enter customer's email: ", Validation.REGEX_EMAIL);
        menuRoom.rentRoom();
        return false;
    }

    // ----------------------------------------------------------
    public void displayAllOrder() {
        for(Customer customer : customerOrder) {
            if(customer.getRoom().isIsRented()) {
                System.out.println(customer);
            }
        }
    }
    // ---------------------------------------------------------

    public ArrayList<Customer> search(Predicate<Customer> p) {
        ArrayList<Customer> rs = new ArrayList<>();
        for (Customer s : customerOrder) {
            if (p.test(s)) {
                rs.add(s);
            }
        }
        return rs;
    }
    // -------------------------------------------------------
    public boolean updateCustomer(Customer customer, String id, String name, String phone, LocalDate dateOfBirth, String address, String gender, String email, Room room) {
        boolean updated = false;
    
        if (id != null) {
            customer.setId(id);
            updated = true;
        }
        if (name != null) {
            customer.setName(name);
            updated = true;
        }
        if (phone != null) {
            customer.setPhone(phone);
            updated = true;
        }
        if (dateOfBirth != null) {
            customer.setDateOfBirth(dateOfBirth);
            updated = true;
        }
        if (address != null) {
            customer.setAddress(address);
            updated = true;
        }
        if (gender != null) {
            boolean parsedGender = Boolean.parseBoolean(gender);
            customer.setGender(parsedGender);
            updated = true;
        }
        if (email != null) {
            customer.setEmail(email);
            updated = true;
        }
        if (room != null) {
            customer.setRoom(room);
            updated = true;
        }
        
        return updated;
    }
    // --------------------------------------------------------
    public Customer searchCustomerId(String id) {
        return customerOrder.stream()
                            .filter(p -> p.getId().equalsIgnoreCase(id))
                            .findFirst().orElse(null);
    }

    // --------------------------------------------------------

    public boolean deleteOrder(String id) {
        Customer customerToDelete = new Customer();
        for (Customer customer : customerOrder) {
            if (customer.getId().equalsIgnoreCase(id)) {
                customerToDelete = customer;
                break;
            }
        }
        if (customerToDelete == null)
            return false;
        String confirmation = "";
        do {
            confirmation = Validation.getString("Are you sure you want to delete the customer? (Yes/No): ");

            if (confirmation.equalsIgnoreCase("Yes")) {
                customerOrder.remove(customerToDelete);
                return true;
            } else if (confirmation.equalsIgnoreCase("No")) {
                System.out.println("Customer not deleted.");
                return false;
            } else {
                System.out.println("Invalid input. Customer not deleted.");
                return false;
            }
        } while (!confirmation.equalsIgnoreCase("Yes") && !confirmation.equalsIgnoreCase("No"));
    }

    // -----------------------------------------------------------
    public void sortOrder() {
        Collections.sort(customerOrder, Comparator.comparingInt(Customer::getDayRent));
    }
}
