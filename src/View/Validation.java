package View;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validation {
    // --------------------------------------------------------------------
    public static final String REGEX_ID = "^KH\\d{4}+$";
    public static final String REGEX_NAME = "[a-zA-Z ]+$";
    public static final String REGEX_PHONE = "^0\\d{9}+$";
    public static final String REGEX_ADDRESS = "[A-Za-z0-9 ]+$";
    public static final String REGEX_GENDER = "true|false|TRUE|FALSE+$";
    public static final String REGEX_EMAIL = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    public static final String DATE_FORMAT= "dd/MM/yyyy";
    public static final String REGEX_ROOM_ID = "^\\d{3}$";
    private static final Scanner sc = new Scanner(System.in);
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);


    //-----------------------------------------------------------------------
    public static String getString(String pr, String pattern) {
        String str;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(pr);
            str = sc.nextLine();

            if (!str.matches(pattern)) {
                System.out.println("[ERROR] Invalid input! Please try again.");
            }
        } while (!str.matches(pattern));
        return str.toUpperCase();
    } // -------------------------------------------------------

    public static String getString(String pr) {
        String str;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(pr);
            str = sc.nextLine();
            if (str.trim().isEmpty()) {
                System.out.println("[ERROR] Can not empty! Please try again!");
            }
        } while (str.trim().isEmpty());
        return str.toUpperCase();
    }

    // -------------------------------------------------------
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
    
    // --------------------------------------------------------
    public static LocalDate getDate(String prompt) {
        String dateStr;

        do {
            System.out.print(prompt);
            dateStr = sc.nextLine();
            try {
                LocalDate date = LocalDate.parse(dateStr, dateFormatter);
                return date;
            } catch(DateTimeParseException e) {
                System.out.println("[ERROR] Invalid input! Please try again.");
            }
        } while (true);
    }
}

