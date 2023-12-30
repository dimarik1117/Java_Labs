import java.util.regex.*;

public class Task5 {
    public static void main(String[] args) {
        try {
            String sentence = "there was a young Fisher who fished for a fish in a fissure.";

            sentence = sentence.toLowerCase();

            String searchLetter = "f+";



            String regex = "\\b" + searchLetter + "\\w*";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(sentence);

            System.out.println("Words starting with the letter '" + searchLetter + "':");

            while (matcher.find()) {
                System.out.println(matcher.group());
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