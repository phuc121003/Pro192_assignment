package View;

import controller.OrderManagement;
import static controller.OrderManagement.customerOrder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import model.Customer;

public class MenuOrder extends Menu<String>{
    static String[] menu = {"Add room order","Display all room order","Update room order",
                            "Search room order by id,name,type of room","Delete room order by id",
                            "Sort room order by day rented","Exit."};
    static Scanner sc = new Scanner(System.in);
    private OrderManagement ord = new OrderManagement();
    public MenuOrder(){
        super("Hotel Room Order System!!!",menu);
    }
    @Override 
    public void execute(String n ){
        switch(n){
            case "1":addOrder(); break;
            case "2":ord.displayAllOrder(customerOrder);break;
            case "3":orderUpdating();break;
            case "4":orderSearching();break;
        }
    }
    //--------------------------------------------------------------------------
    public int checkUpdate(String id){
        for (Customer customer : customerOrder)
        if (customer.getId().equalsIgnoreCase(id))
        return customerOrder.indexOf(customer);
        return -1;
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
                    String id = OrderManagement.getString("Enter customer id you want to update: ","^KH\\d{4}+$");
                    if (checkUpdate(id) != -1){
                    switch(n){
                        case "1":
                            String name = OrderManagement.getString("Enter name you want to update: ","[a-zA-Z ]+$");
                            customerOrder.get(checkUpdate(id)).setName(name);
                        case "2":
                            String phone = OrderManagement.getString("Enter phone you want to update: ", "^0\\d{9}+$");
                            customerOrder.get(checkUpdate(id)).setPhone(phone);
                        case "3":
                            String dateOfBirthStr = OrderManagement.getString("Enter date of birth you want to update(yyyy-mm-dd): ","dd/MM/yyyy");
                            LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr,
                            DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                            customerOrder.get(checkUpdate(id)).setDateOfBirth(dateOfBirth);
                        case "4":
                            
                    }
                    }
                }
            };
            m.run();
        }
    //--------------------------------------------------------------------------
    public void orderSearching(){
        String[] mSearch ={"By id","By name","Type of room"};
        Menu m = new Menu("Order Searching System!!!",mSearch){
            @Override
            public void execute(String n){
                ArrayList<Customer> rs = null;
                switch(n){
                    case "1":
                        String val = OrderManagement.getString("Enter id you want to search","^KH\\d{4}+$");
                        rs = ord.search(p->p.getId().equalsIgnoreCase(val));
                        break;
                    case "2":
                        val = OrderManagement.getString("Enter name you want to search", "[a-zA-Z ]+$");
                        rs = ord.search(p->p.getName().equalsIgnoreCase(val));
                        break;
                    case "3":
                        val = OrderManagement.getString("Enter type of room you want to search","Single Room|Couple Room");
                        rs = ord.search(p->p.getRoom().getRoomType().equalsIgnoreCase(val));
                        break;
                    default: return;
                }
                    ord.displayAllOrder(rs);
            }
            };
                    m.run();
        }
    //--------------------------------------------------------------------------
  }
 

