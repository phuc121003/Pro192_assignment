package View;

import controller.OrderManagement;
import controller.Validation;

import java.util.ArrayList;
import java.util.Scanner;

import model.Customer;

public class MenuOrder extends Menu<String>{
    static String[] menu = {"Add Room Order","Display All Room Order","Update Order's Customer.",
                            "Search Room Order","Release Room",
                            "Sort room order by day rented","Exit."};
    private Scanner sc = new Scanner(System.in);
    private OrderManagement orderManagement = new OrderManagement();
    public MenuOrder(){
        super("Hotel Room Order System!!!",menu);
    }
    @Override 
    public void execute(String n ){
        switch(n){
            case "1":
                addOrder(); 
                break;
            case "2": 
                displayAllOrder(); 
                break;
            case "3": 
                orderUpdatingAll(); 
                break;
            case "4": 
                orderSearching(); 
                break;
            case "5":
                deleteOrder(); 
                break;
            case "6":
                sortOrderByDayRent();
                break;
            case "7": 
                System.out.println("Back to main menu.");
                break;
            default: 
                System.out.println("[ERROR] Invalid input! Please try again.");
        }
    }
    //--------------------------------------------------------------------------
    public void addOrder(){
        if (orderManagement.OrderRoom()!=null) 
            System.out.println("Customer rent room successfully!!");
        else 
            System.out.println("Failed in renting room!!");
    }

    public void displayAllOrder() {
        if(!orderManagement.getCustomerOrdered().isEmpty()) {
                System.out.println("----------------------------------------------------------------------------------------------");
                System.out.println("|ID \t Name \t\t Phone \t\t Gender \t Day of Birth \t Email \t Room ID \t Room Type \t Room Price|");
                orderManagement.displayAllOrder();
                System.out.println("----------------------------------------------------------------------------------------------");
        } else {
            System.out.println("Empty list, Try again please.");
        }
    }
    //--------------------------------------------------------------------------
    public void orderUpdatingAll() {
        if(orderManagement.updateCustomer()) {
            System.out.println("Update successfull.");
        } else {
            System.err.println("Update failed.");
        }
    }
    //--------------------------------------------------------------------------
    public void orderSearching(){
        String[] mSearch ={"By ID","By Name","Type Of Room", "Exit."};
        Menu m = new Menu("Order Searching System!!!",mSearch) {
            @Override
            public void execute(final String n){
                ArrayList<Customer> rs = null;
                switch(n){
                    case "1":
                        String val = Validation.getString("Enter id you want to search", Validation.REGEX_ID);
                        rs = orderManagement.search(p->p.getId().equalsIgnoreCase(val));
                        break;
                    case "2":
                        val = Validation.getString("Enter name you want to search", Validation.REGEX_NAME);
                        rs = orderManagement.search(p->p.getName().equalsIgnoreCase(val));
                        break;
                    case "3":
                        val = Validation.getString("Enter type of room you want to search","Single Room|Couple Room");
                        rs = orderManagement.search(p->p.getRoom().getRoomType().equalsIgnoreCase(val));
                        break;
                    default: 
                        System.out.println("[ERROR] Invalid input! Please try again.");
                        break;
                }
                    System.out.println(rs);
            }
            };
                    m.run();
        }
    //--------------------------------------------------------------------------
    public void deleteOrder(){
        String id = Validation.getString("Enter customer's id to delete order:", Validation.REGEX_ID);
        if (orderManagement.deleteOrder(id)) 
            System.out.println("Order delected successfully!!");
        else 
            System.out.println("Failed in deleting order!!!");
    }
    //--------------------------------------------------------------------------
    public void sortOrderByDayRent() {
        System.out.println("List customer after sort: ");
        orderManagement.sortOrder();
        displayAllOrder();
    } 
  }
 

