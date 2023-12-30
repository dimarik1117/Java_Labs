import java.io.*;

public class FileCopy {
    public static void main(String[] args){
        int n;
        FileInputStream from = null;
        FileOutputStream to = null;
        try{
            File fromFile = new File("test.txt");
            //File fromFile = new File("test1.txt");
            File toFile = new File("myfile.txt");

            from = new FileInputStream(fromFile);
            to = new FileOutputStream(toFile);

            while ((n = from.read()) != -1)
                to.write(n);

            from.close();
            to.close();

            while ((n = from.read()) != -1)
                to.write(n);

            System.out.println("Готово");

        } catch (FileNotFoundException exception) {
            System.out.println("Файл не найден " + exception.getMessage());
        } catch (IOException exception){
            System.out.println("Сработало исключение IOException " + exception.getMessage());
        } catch (NullPointerException exception){
            System.out.println("Сработало исключение NullPointerException " + exception.getMessage());
        }
    }
}