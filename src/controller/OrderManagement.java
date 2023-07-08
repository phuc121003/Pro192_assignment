package controller;

import View.Validation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Predicate;

import model.Customer;
import model.Room.Room;

public class OrderManagement {
    public OrderManagement() {
        Scanner sc = new Scanner(System.in);
    }
    Validation val = new Validation();
    public static ArrayList<Customer> customerOrder = new ArrayList<>();
    // -----------------------------------------------------------
    public boolean OrderRoom() {
        String id = val.getString("Enter customer's id: ", "^KH\\d{4}+$");
        String name = val.getString("Enter customer's name: ", "[a-zA-Z ]+$");
        String phone = val.getString("Enter customer's phone:", "^0\\d{9}+$");
        String genderStr = val.getString("Enter customer's gender (true = male;false = female):", "true|false+$");
        boolean gender = Boolean.parseBoolean(genderStr);
        String dateOfBirthStr = val.getDate("Enter customer's date of birth: ");
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String email = val.getString("Enter customer's email: ", "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        Room room = new Room();
//        do {
//        String roomId = val.getString("Enter room id of customer: ", "[0-9]");
//        if (!room.isIsRented()) {
//            customer.setRoomId(roomId);
//            break;
//        } else {
//        System.out.println("This room has been rented.");
//        }
//}       while (room.isIsRented());
        return false;
    }

    // ----------------------------------------------------------
    public void displayAllOrder(ArrayList<Customer> customerOrder) {
        customerOrder.forEach(p -> System.out.println(p));
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
            confirmation = val.getString("Are you sure you want to delete the customer? (Yes/No): ");

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
