package View;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Validation {
    //--------------------------------------------------------------
    public static boolean isValidName(String name) {
        name = name.trim();
        return !name.isEmpty() && name.matches("[A-Z][a-zA-Z ]*");
    }
    //--------------------------------------------------------------
    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("09\\d{8}");
    }
    //--------------------------------------------------------------
    public static boolean isValidPositiveInt(int number) {
    return number >= 0 && String.valueOf(number).matches("\\d+");
    }
    //--------------------------------------------------------------
    public static boolean isValidDateOfBirth(String dateOfBirthStr) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr, formatter);

            int year = dateOfBirth.getYear();
            int month = dateOfBirth.getMonthValue();
            int day = dateOfBirth.getDayOfMonth();

            boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            int maxDaysInFebruary;
            if (isLeapYear) maxDaysInFebruary = 29;
            else maxDaysInFebruary = 28;

            if (month < 1 || month > 12) {
                System.out.println("Invalid month. Please enter a valid date of birth.");
                return false;
            }

            switch (month) {
                case 2: // Tháng 2
                    if (day < 1 || day > maxDaysInFebruary) {
                        System.out.println("Invalid day. Please enter a valid date of birth.");
                        return false;
                    }
                    break;
                case 4: // Tháng 4
                case 6: // Tháng 6
                case 9: // Tháng 9
                case 11: // Tháng 11
                    if (day < 1 || day > 30) {
                        System.out.println("Invalid day. Please enter a valid date of birth.");
                        return false;
                    }
                    break;
                default: // Các tháng còn lại
                    if (day < 1 || day > 31) {
                        System.out.println("Invalid day. Please enter a valid date of birth.");
                        return false;
                    }
                    break;
            }

            return true;
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter a valid date of birth (dd/MM/yyyy).");
            return false;
        }
    }
    //-----------------------------------------------------------------------

}
