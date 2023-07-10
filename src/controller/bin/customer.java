package controller.bin;



// public void orderUpdating(){
//         String[] mUpdate ={"Update name","Update phone","Update date of birth",
//                            "Update address","Update gender","Update email","Update Room"};
//         Menu m = new Menu("Order Updating System!!!",mUpdate) {
//                 @Override
//                 public void execute(String n){
//                     String id = Validation.getString("Enter customer id you want to update: ",Validation.REGEX_ID);
//                     Customer customer = orderManagement.searchCustomerId(id);
//                     if (customer!=null){
//                     switch(n){
//                         case "1":
//                             String name = Validation.getString("Enter name you want to update: ",Validation.REGEX_NAME);
//                             customer.setName(name);
//                             break;
//                         case "2":
//                             String phone = Validation.getString("Enter phone you want to update: ", Validation.REGEX_PHONE);
//                             customer.setPhone(phone);
//                             break;
//                         case "3":
//                             LocalDate dateOfBirth = Validation.getDate("Enter date of birth you want to update(yyyy-mm-dd): ");
//                             customer.setDateOfBirth(dateOfBirth);
//                             break;
//                         case "4":
//                             String address = Validation.getString("Enter address you want to update: ",Validation.REGEX_ADDRESS);
//                             customer.setAddress(address);
//                             break;
//                         case "5":
//                             String genderStr = Validation.getString("Enter gender you want to change((true = male;false = female)",Validation.REGEX_GENDER);
//                             boolean gender = Boolean.parseBoolean(genderStr);
//                             customer.setGender(gender);
//                             break;
//                         case "6":
//                             String email = Validation.getString("Enter email you want to update: ", Validation.REGEX_EMAIL);
//                             customer.setEmail(email);
//                             break;
//                         case "7":
//                             String roomID = Validation.getString("Enter room you want to change", Validation.REGEX_ROOM_ID);
//                             for (Room room : rooms)
//                             {}
//                         }       
//                     }
//                 }
//             };
//             m.run();
//         }



























// package controller;

// import View.Menu;
// import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Comparator;
// import java.util.List;
// import java.util.Scanner;
// import java.util.stream.Collectors;
// import model.Customer;

// public class CustomerManagement extends Menu<String>{
// static String[] menu = {"Add customer", "Display all customer", "Update
// customer", "Search customer", "Delete customer by ID", "Sort customer by Day
// Rent", "Exit."};
// static ArrayList<Customer> cus = new ArrayList<>();
// static Scanner sc = new Scanner(System.in);
// //Validation val = new Validation();
// public CustomerManagement(){
// super("Customer Management System!!!",menu);
// }
// //-------------------------------------------
// @Override
// public void execute(String n){
// switch (n) {
// case "1": addCus(); break;
// case "2": displayAllCus(); break;
// case "3": updateCus(); break;
// case "4": searchCus(); break;
// case "5": deleteCus(); break;
// case "6": sortCus(); break;
// case "7": close(); break;
// }
// }
// //--------------------------------------------
// public String getValue(String msg) {
// Scanner sc = new Scanner(System.in);
// System.out.print(msg);
// return sc.nextLine();
// }
// //---------------------------------------------
// public int check(String id){
// for (Customer customer : cus)
// if (customer.getId().equalsIgnoreCase(id))
// return cus.indexOf(customer);
// return -1;
// }
// //-----------------------------------------------
// public void addCus(){
// String id = getValue("Please enter your id");
// String name = getValue("Please enter your name");
// String phone = getValue("Please enter your phone number");
// String dateOfBirthStr = getValue("Please enter your date of birth");
// LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr,
// DateTimeFormatter.ofPattern("dd/MM/yyyy"));
// String billID = getValue("Please enter your bill ID");
// int dayRent = Integer.parseInt(getValue("Please enter number of days that you
// rent room"));
// }
// //----------------------------------------------
// public void displayAllCus(){
// if (cus.isEmpty()) {
// System.out.println("No customers found.");
// } else {
// System.out.println("Customers:");
// for (Customer customer : cus) {
// System.out.println(customer.toString());
// }
// }
// }
// //----------------------------------------------
// public void updateCus() {
// String[] mUpdate = {"Update name", "Update phone", "Update date of birth",
// "Update bill ID", "Update day rent"};
// Menu m = new Menu("Customer Updating System!!!", mUpdate){
// @Override
// public void execute(String n) {
// System.out.println("Enter customer ID: ");
// String id = sc.nextLine();
// if (check(id) != -1) {
// switch (n) {
// case "1":
// String name = getValue("Enter name you want to update: ");
// cus.get(check(id)).setName(name);
// break;
// case "2":
// String phone = getValue("Enter phone you want to update: ");
// cus.get(check(id)).setPhone(phone);
// break;
// case "4":
// String dateOfBirthStr = getValue("Enter date of birth you want to update
// (yyyy-mm-dd): ");
// LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr,
// DateTimeFormatter.ofPattern("dd/MM/yyyy"));
// cus.get(check(id)).setDateOfBirth(dateOfBirth);
// break;
// case "5":
// String billID = getValue("Enter bill ID you want to update: ");
// cus.get(check(id)).setBillID(billID);
// break;
// case "6":
// String dayRentStr = getValue("Enter day rent you want to update: ");
// int dayRent = Integer.parseInt(dayRentStr);
// cus.get(check(id)).setDayRent(dayRent);
// break;
// default:
// return;
// }
// }
// }
// };
// m.run();
// }
// //------------------------------------
// public void searchCus(){
// String[] mSearch ={"Search by id","Search by name"};
// Menu m = new Menu("Customer Searching System!!!",mSearch){
// @Override
// public void execute(String n) {
// List<Customer> result = new ArrayList<>();
// switch(n){
// case "1":
// String val = getValue("Enter CustomerID :");
// result = cus.stream()
// .filter(c -> c.getId().equals(val))
// .collect(Collectors.toList());
// break;
// case "2":
// val = getValue("Enter name: ");
// result = cus.stream()
// .filter(c -> c.getName().contains(val))
// .collect(Collectors.toList());
// break;
// default : return;
// }
// for (Customer customer : cus)
// customer.toString();
// }
// };
// m.run();
// }
// //---------------------------------------
// public void deleteCus(){
// String customerToDeleteStr = getValue("Enter your Customer ID you want to
// delete ");
// Customer customerToDelete = null;
// for (Customer customer : cus) {
// if (customer.getId().equalsIgnoreCase(customerToDeleteStr)) {
// customerToDelete = customer;
// break;
// }
// }

// if (customerToDelete == null) {
// System.out.println("Customer not found!");
// return;
// }

// String confirmation = getValue("Are you sure you want to delete the customer?
// (Yes/No): ");

// if (confirmation.equalsIgnoreCase("Yes")) {
// cus.remove(customerToDelete);
// System.out.println("Customer successfully deleted.");
// } else if (confirmation.equalsIgnoreCase("No")) {
// System.out.println("Customer not deleted.");
// } else {
// System.out.println("Invalid input. Customer not deleted.");
// }
// }
// //-------------------------------------------------
// public void sortCus(){
// Collections.sort(cus, Comparator.comparingInt(Customer::getDayRent));

// for (Customer customer : cus) {
// System.out.println(customer);
// }
// }
// //-------------------------------------------------
// private static void close() {
// System.out.println("Thank you for using our system. Bye bye!!!");
// System.exit(0);
// }
// }
