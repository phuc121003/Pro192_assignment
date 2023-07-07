package controller;

import java.util.ArrayList;

import model.Bill;
import model.Customer;
import model.Room.Room;

public class BillManagement {
    ArrayList<Bill> bills=new ArrayList<>();
    int id=1;
    public void addBill(Customer customer,Room room){
        Bill bill=new Bill(id,customer, room);
        bills.add(bill);
        id++;
    }

    public ArrayList<Bill> getAllBills(){
        return bills;
    }

    public Bill getBillById(int id){
        for (Bill bill : bills) {
            if(bill.getId()==id) return bill;
        }
        return null;
    }

    public ArrayList<Bill> getBillByCustomerName(String name){
        ArrayList<Bill> result=new ArrayList<>();
        for (Bill bill : bills) {
            if(bill.getCustomer().getName().equalsIgnoreCase(name)) result.add(bill);
        }
        return result;
    }

    public void deleteBillById(int id){
        for (Bill bill : bills) {
            if(bill.getId()==id) bills.remove(bill);
        }
    }
}
