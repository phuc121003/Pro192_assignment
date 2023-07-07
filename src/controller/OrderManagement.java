package controller;

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
    public OrderManagement(){
        Scanner sc = new Scanner(System.in);
    }
    static private ArrayList<Customer> customerOrder = new ArrayList<>();
//-----------------------------------------------------------
    public static String getString(String pr, String pattern) {
    String str;
    Scanner sc = new Scanner(System.in);
    do {
        System.out.print(pr);
        str = sc.nextLine();
        if(str.trim().isEmpty()) {
            System.out.println("Can not empty, please re-enter!");
        }else if(!str.matches(pattern)) {
            System.out.println("Invalid, please re-enter!");
        }
    } while(str.trim().isEmpty() || !str.matches(pattern));
    return str.toUpperCase();
}  //-------------------------------------------------------
    public static String getString(String pr) {
    String str;
    Scanner sc = new Scanner(System.in);
    do {
        System.out.print(pr);
        str = sc.nextLine();
        if(str.trim().isEmpty()) {
            System.out.println("Can not empty, please re-enter!");
        }
    } while(str.trim().isEmpty());
    return str.toUpperCase();
    }
    //-------------------------------------------------------
    public static boolean validDay(String str) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(str);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    //--------------------------------------------------------
    public static String getDate(String pr) {
    String str;
    Scanner sc = new Scanner(System.in);
    do {
        System.out.print(pr);
        str = sc.nextLine();
        if(str.trim().isEmpty()) {
            System.out.println("Can not empty, please re-enter!");
        }else if(!validDay(str)) {
            System.out.println("Invalid, please re-enter!");
        }
    } while(str.trim().isEmpty() || !validDay(str));
    return str;
    }
//-----------------------------------------------------------
    public boolean OrderRoom(){
        String id = getString("Enter customer's id: ","^KH\\d{4}+$");
        String name = getString("Enter customer's name: ","[a-zA-Z ]+$");
        String phone = getString("Enter customer's phone:","^0\\d{9}+$");
        String genderStr = getString("Enter customer's gender (true = male;false = female):","true|false+$");
        boolean gender = Boolean.parseBoolean(genderStr);
        String dateOfBirthStr = getDate("Enter customer's date of birth: ");
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String email = getString("Enter customer's email: ","^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        Room room = new Room();
        do{
            String roomId = getString("Enter room id of customer: ", "[0-9]");
            if (room.isIsRented()) System.out.println("This room have been rented");
        }
        while (room.isIsRented());
    }
//----------------------------------------------------------
    public void displayAllOrder(){
        customerOrder.forEach(p -> System.out.println(p));
    }
 //---------------------------------------------------------
    
   public static ArrayList<Customer> search(Predicate<Customer> p) {
        ArrayList<Customer> rs = new ArrayList<>();
        for (Customer s : customerOrder) {
            if (p.test(s)) {
                rs.add(s);
            }
        }
        return rs;
   }
   
  //--------------------------------------------------------
    public boolean deleteOrder(String id){
        Customer customerToDelete = new Customer();
        for (Customer customer : customerOrder){
            if (customer.getId().equalsIgnoreCase(id))
            {
                customerToDelete = customer;
                break;
            }
        }
        if (customerToDelete == null) return false;
        String confirmation="";
        do {
        confirmation = getString("Are you sure you want to delete the customer? (Yes/No): ");

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
        }
        while(!confirmation.equalsIgnoreCase("Yes")&&!confirmation.equalsIgnoreCase("No"));
    }
    //-----------------------------------------------------------
    public void sortOrder(){
        Collections.sort(customerOrder, Comparator.comparingInt(Customer::getDayRent));
    }
}
