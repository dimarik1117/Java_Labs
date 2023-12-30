import java.util.regex.*;
import java.util.regex.PatternSyntaxException;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "The price of the product is $-19.99";

        try {
            Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
            Matcher matcher = pattern.matcher(text);
            boolean found = false;

            while (matcher.find()) {
                System.out.println(matcher.group());
                found = true;
            }

            if (!found) {
                System.out.println("No numbers found in the text.");
            }
        }
        catch (PatternSyntaxException e) {
            System.err.println("Pattern syntax exception: " + e.getMessage());
        }
        catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}