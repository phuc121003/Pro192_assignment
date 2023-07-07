package model.Room;

public class SingleRoom extends Room {
    private final static String[] idRoom = { "101", "102", "103", "104", "105", "201", "202", "203", "204", "205" };
    private static int i = 0;

    public SingleRoom() {
        super(idRoom[i++], "Single Room", 300000, false);
    }
}
