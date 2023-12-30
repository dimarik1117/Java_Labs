import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Task2 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int numThreads = 3; // количество потоков

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        int chunkSize = matrix.length / numThreads;

        // Создаем и запускаем задачи для каждой части матрицы
        for (int i = 0; i < numThreads; i++) {
            int startRow = i * chunkSize;
            int endRow = (i == numThreads - 1) ? matrix.length : (i + 1) * chunkSize;
            MaxElementTask task = new MaxElementTask(matrix, startRow, endRow);
            executor.execute(task);
        }

        // Ожидаем завершения всех задач
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Сравниваем результаты всех задач для нахождения наибольшего элемента
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < numThreads; i++) {
            maxElement = Math.max(maxElement, ((MaxElementTask) executor).getMaxElement());
        }

        System.out.println("Max Element: " + maxElement);
    }
}

class MaxElementTask implements Runnable {
    private final int[][] matrix;
    private final int startRow;
    private final int endRow;
    private int maxElement;

    public MaxElementTask(int[][] matrix, int startRow, int endRow) {
        this.matrix = matrix;
        this.startRow = startRow;
        this.endRow = endRow;
        this.maxElement = Integer.MIN_VALUE;
    }

    public int getMaxElement() {
        return maxElement;
    }

    @Override
    public void run() {
        for (int i = startRow; i < endRow; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > maxElement) {
                    maxElement = matrix[i][j];
                }
            }
        }
    }
}