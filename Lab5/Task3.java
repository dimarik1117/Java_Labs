import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        try {
            String inputText = "First example link: https://www.example.com and second example link: http://google.com.";

            String regex = "(https?|ftp|file)://[\\w-+&@#/%?=~|!:,.;]*[\\w-+&@#/%=~|]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(inputText);

            List<String> validUrls = new ArrayList<>();
            while (matcher.find()) {
                validUrls.add(matcher.group());
            }

            String resultText = inputText;
            for (String url : validUrls) {
                resultText = resultText.replace(url, "<a href=\"" + url + "\">Link</a>");
            }

            System.out.println(resultText);
        }
        catch (PatternSyntaxException e) {
            System.err.println("Pattern syntax exception: " + e.getMessage());
        }
        catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}