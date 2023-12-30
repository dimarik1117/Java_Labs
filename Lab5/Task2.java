public class Task2 {
    public static boolean isPasswordValid(String password) {

        boolean regex = password.matches("(?=.*[A-Z])(?=.*\\d)[\\w]{8,16}");

        try {
            if (!regex) {
                throw new Exception("Password must be between 8 and 16 characters long, contain at least one uppercase letter, and at least one digit.");
            }
            return true;

        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        String password = "Newpassword1";

        if (isPasswordValid(password)) {
            System.out.println("Password is valid.");
        }
        else {
            System.out.println("Password is invalid.");
        }
    }
}