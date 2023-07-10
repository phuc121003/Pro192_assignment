package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import model.Customer;
import model.Room.Room;

public class OrderManagement {
    private ArrayList<Customer> customerOrder = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private RoomManagement roomManagement = new RoomManagement();
    // -------------------------------------------------
    public OrderManagement() {
        
    }

// -----------------------------------------------------------
    public Customer OrderRoom() {
            String id = Validation.getString("Enter customer's id: ", Validation.REGEX_ID);
            String name = Validation.getString("Enter customer's name: ", Validation.REGEX_NAME);
            String phone = Validation.getString("Enter customer's phone:", Validation.REGEX_PHONE);
            String genderStr = Validation.getString("Enter customer's gender (true = male;false = female):", Validation.REGEX_GENDER);
            boolean gender = Boolean.parseBoolean(genderStr);
            String dateOfBirth = Validation.getDate("Enter customer's date of birth: ");
            String email = Validation.getString("Enter customer's email: ", Validation.REGEX_EMAIL);

            System.out.println("1. Single Room.");
            System.out.println("2. Couple Room.");
            System.out.println("Enter selection..");
            String choice = sc.nextLine();
            Room room = roomManagement.rentRoomByType(choice);

            int dayRent = Integer.parseInt(Validation.getString("Enter number of day rent: ", "^[0-9]+$"));
            Customer customer = new Customer(id, name, phone, genderStr, gender, dateOfBirth, email, room, dayRent);
            customerOrder.add(customer);
            return customer;

            // System.out.println("[ERROR], Try again please.");
            // TODO: handle exception
  
    }

// ----------------------------------------------------------
    public boolean displayAllOrder() {
        for(Customer customer : customerOrder) {
            if(customer.getRoom().isIsRented()) {
                System.out.println(getCustomerOrdered());
                return true;
            }
        }
        return false;
    }

    public List<Customer> getCustomerOrdered() {
        return customerOrder.stream()
                        .filter(p -> p.getRoom().isIsRented())
                        .collect(Collectors.toList());
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
    public boolean updateCustomer(Customer customer, String id, String name, String phone, String dateOfBirth, String address, String gender, String email, Room room) {
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

public boolean updateCustomer() {
    System.out.println("\t\tUPDATE ORDER'S CUSTOMER\t\t");
    System.out.println("Input information you want to update (Enter to pass): ");
    
    String id = Validation.getString("Input ID's customer: ", Validation.REGEX_ID);
    Customer customer = searchCustomerId(id);
    
    String name = Validation.getString("Input name's customer: ",Validation.REGEX_NAME);
    String phone = Validation.getString("Input phone's customer: ", Validation.REGEX_PHONE);
    String dateOfBirthStr = Validation.getDate("Input date of birth(dd/MM/yyyy): ");
    String address = Validation.getString("Input address: ",Validation.REGEX_ADDRESS);
    String genderStr = Validation.getString("Input gender((true = male;false = female)",Validation.REGEX_GENDER);
    String email = Validation.getString("Input email: ", Validation.REGEX_EMAIL);
    String roomID = Validation.getString("Input ID'S Room: ", Validation.REGEX_ROOM_ID);

    Room room = roomManagement.searchRoomById(roomID);
    
    if (updateCustomer(customer, roomID, name, phone, dateOfBirthStr, address, genderStr, email, room)) {
        System.out.println("Customer " + id + " has been rented successfully.");
        return true;
    }
    
    return false;
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
// ----------------------------------------------------------------
}
