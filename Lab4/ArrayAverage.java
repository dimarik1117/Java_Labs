public class ArrayAverage {
    public static void arrayAverage(Object[] arr) {
        int sum = 0;
        int i = 0;
        try {
            while (true) {
                sum += (int) arr[i];
                i += 1;
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за границы массива. Среднее арифметическое: " + sum / i);
        }
        catch (ClassCastException e) {
            System.out.println("Вбиты неверные данные: " + e.getMessage());
        }
    }
}