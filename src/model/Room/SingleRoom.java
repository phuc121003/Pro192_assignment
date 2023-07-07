/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Room;

import java.util.ArrayList;

public class SingleRoom extends Room {
    private static final String[] idRoom = { "101", "102", "103", "104", "105", "201", "202", "203", "204", "205" };
    private static int i = 0;

    public SingleRoom() {
        super(idRoom[i++], "Single Room", 300000, false);
    }
}
