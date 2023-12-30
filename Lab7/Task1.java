import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Task1 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int numThreads = 4; // количество потоков

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        int chunkSize = array.length / numThreads;

        // Создаем и запускаем задачи для каждой части массива
        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i == numThreads - 1) ? array.length : (i + 1) * chunkSize;
            SumTask task = new SumTask(array, startIndex, endIndex);
            executor.execute(task);
        }

        // Ожидаем завершения всех задач
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Суммируем результаты всех задач
        long totalSum = 0;
        for (int i = 0; i < numThreads; i++) {
            totalSum += ((SumTask) executor).getPartialSum();
        }

        System.out.println("Total Sum: " + totalSum);
    }
}

class SumTask implements Runnable {
    private final int[] array;
    private final int startIndex;
    private final int endIndex;
    private long partialSum;

    public SumTask(int[] array, int startIndex, int endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public long getPartialSum() {
        return partialSum;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            partialSum += array[i];
        }
    }
}