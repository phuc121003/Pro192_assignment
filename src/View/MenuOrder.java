package View;

import controller.OrderManagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import model.Customer;
import model.Room.Room;

import static controller.RoomManagement.rooms;

public class MenuOrder extends Menu<String>{
    static String[] menu = {"Add Room Order","Display All Room Order","Update Order's Customer.",
                            "Search Room Order","Release Room",
                            "Sort room order by day rented","Exit."};
    static Scanner sc = new Scanner(System.in);
    private OrderManagement ord = new OrderManagement();

    public MenuOrder(){
        super("Hotel Room Order System!!!",menu);
    }
    @Override 
    public void execute(String n ){
        switch(n){
            case "1": addOrder(); break;
            case "2": ord.displayAllOrder(); break;
            case "3": orderUpdating(); break;
            case "4": orderSearching(); break;
            case "5":
                String id = Validation.getString("Enter customer's id to delete order:", Validation.REGEX_ID);
                deleteOrder(id); break;
            case "6":ord.sortOrder(); break;
            case "7": 
                System.out.println("Back to main menu.");
                break;
            default: 
                System.out.println("[ERROR] Invalid input! Please try again.");
        }
    }
    //--------------------------------------------------------------------------
    public void addOrder(){
        if (ord.OrderRoom()) System.out.println("Customer rent room successfully!!");
        else System.out.println("Failed in renting room!!");
    }
    //--------------------------------------------------------------------------
    public void orderUpdating(){
        String[] mUpdate ={"Update name","Update phone","Update date of birth",
                           "Update address","Update gender","Update email","Update Room"};
        Menu m = new Menu("Order Updating System!!!",mUpdate) {
                @Override
                public void execute(String n){
                    String id = Validation.getString("Enter customer id you want to update: ",Validation.REGEX_ID);
                    Customer customer = ord.searchCustomerId(id);
                    if (customer!=null){
                    switch(n){
                        case "1":
                            String name = Validation.getString("Enter name you want to update: ",Validation.REGEX_NAME);
                            customer.setName(name);
                            break;
                        case "2":
                            String phone = Validation.getString("Enter phone you want to update: ", Validation.REGEX_PHONE);
                            customer.setPhone(phone);
                            break;
                        case "3":
                            LocalDate dateOfBirth = Validation.getDate("Enter date of birth you want to update(yyyy-mm-dd): ");
                            customer.setDateOfBirth(dateOfBirth);
                            break;
                        case "4":
                            String address = Validation.getString("Enter address you want to update: ",Validation.REGEX_ADDRESS);
                            customer.setAddress(address);
                            break;
                        case "5":
                            String genderStr = Validation.getString("Enter gender you want to change((true = male;false = female)",Validation.REGEX_GENDER);
                            boolean gender = Boolean.parseBoolean(genderStr);
                            customer.setGender(gender);
                            break;
                        case "6":
                            String email = Validation.getString("Enter email you want to update: ", Validation.REGEX_EMAIL);
                            customer.setEmail(email);
                            break;
                        case "7":
                            String roomID = Validation.getString("Enter room you want to change", Validation.REGEX_ROOM_ID);
                            for (Room room : rooms)
                            {}
                        }       
                    }
                }
            };
            m.run();
        }
    //--------------------------------------------------------------------------
    public void orderUpdatingAll() {
        System.out.println("\t\tUPDATE ORDER'S CUSTOMER\t\t");
        System.out.println("Input information you want to update (Enter to pass): ");
        String id = Validation.getString("Input ID's customer: ", Validation.REGEX_ID);
        String name = Validation.getString("Input name's customer: ",Validation.REGEX_NAME);
        String phone = Validation.getString("Input phone's customer: ", Validation.REGEX_PHONE);
        LocalDate dateOfBirthStr = Validation.getDate("Input date of birth(dd/MM/yyyy): ");
        String address = Validation.getString("Input address: ",Validation.REGEX_ADDRESS);
        String genderStr = Validation.getString("Input gender((true = male;false = female)",Validation.REGEX_GENDER);
        String email = Validation.getString("Input email: ", Validation.REGEX_EMAIL);
        String roomID = Validation.getString("Input ID'S Room: ", Validation.REGEX_ROOM_ID);
        if(ord.updateCustomer(ord.searchCustomerId(id), roomID, name, phone, dateOfBirthStr, address, genderStr, email, null)) {
            System.out.println("Update successfull.");
        } else {
            System.err.println("Update failed.");
        }
    }
    //--------------------------------------------------------------------------
    public void orderSearching(){
        String[] mSearch ={"By ID","By Name","Type Of Room", "Exit."};
        Menu m = new Menu("Order Searching System!!!",mSearch){
            @Override
            public void execute(String n){
                ArrayList<Customer> rs = null;
                switch(n){
                    case "1":
                        String val = Validation.getString("Enter id you want to search",Validation.REGEX_ID);
                        rs = ord.search(p->p.getId().equalsIgnoreCase(val));
                        break;
                    case "2":
                        val = Validation.getString("Enter name you want to search", Validation.REGEX_NAME);
                        rs = ord.search(p->p.getName().equalsIgnoreCase(val));
                        break;
                    case "3":
                        val = Validation.getString("Enter type of room you want to search","Single Room|Couple Room");
                        rs = ord.search(p->p.getRoom().getRoomType().equalsIgnoreCase(val));
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
    public void deleteOrder(String id){
        if (ord.deleteOrder(id)) System.out.println("Order delected successfully!!");
        else System.out.println("Failed in deleting order!!!");
    }
    //--------------------------------------------------------------------------
    private static void close() {
        System.out.println("Thank you for using our system. Bye bye!!!");
        System.exit(0);
    }
  }
 

