import java.io.FileWriter;
import java.io.IOException;

public class CustomFileNotFoundException extends Exception {
    public CustomFileNotFoundException() {
        super();
    }

    public CustomFileNotFoundException(String s) {
        super(s);
        try {
            FileWriter log = new FileWriter("Logs.txt", true);
            log.write(s + '\n');
            log.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}