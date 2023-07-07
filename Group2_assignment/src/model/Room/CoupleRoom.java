/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Room;

/**
 *
 * @author PC
 */
public class CoupleRoom extends Room{
    private static String[] idRoom = {"301", "302", "303", "304", "305", "401", "402" ,"403", "404", "405"};
    private static int i = 0;
    public CoupleRoom() {
        super(idRoom[i++], "Couple Room", 500000, true);
    }
}
