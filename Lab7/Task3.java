import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Task3 {
    public static void main(String[] args) {
        List<Integer> products = new ArrayList<>();
        // Добавление на склад несколько товаров с весом
        for (int i = 1; i <= 100; i++) {
            products.add(i);
        }

        Warehouse sourceWarehouse = new Warehouse(products);
        Warehouse destinationWarehouse = new Warehouse(new ArrayList<>());

        int maxWeightPerLoader = 150;
        int numLoaders = 3;

        ExecutorService executor = Executors.newFixedThreadPool(numLoaders);
        CompletionService<Void> completionService = new ExecutorCompletionService<>(executor);

        for (int i = 1; i <= numLoaders; i++) {
            Callable<Void> loader = new Loader(i, sourceWarehouse, destinationWarehouse, maxWeightPerLoader);
            completionService.submit(loader);
        }

        try {
            for (int i = 0; i < numLoaders; i++) {
                Future<Void> result = completionService.take();
                result.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}

class Warehouse {
    private List<Integer> products;

    public Warehouse(List<Integer> products) {
        this.products = products;
    }

    public List<Integer> getProducts() {
        return products;
    }

    public void removeProducts(List<Integer> selectedProducts) {
        products.removeAll(selectedProducts);
    }
}

class Loader implements Callable<Void> {
    private final int id;
    private final Warehouse sourceWarehouse;
    private final Warehouse destinationWarehouse;
    private final int maxWeight;

    public Loader(int id, Warehouse sourceWarehouse, Warehouse destinationWarehouse, int maxWeight) {
        this.id = id;
        this.sourceWarehouse = sourceWarehouse;
        this.destinationWarehouse = destinationWarehouse;
        this.maxWeight = maxWeight;
    }

    @Override
    public Void call() {
        try {
            while (!sourceWarehouse.getProducts().isEmpty()) {
                List<Integer> selectedProducts = new ArrayList<>();
                int currentWeight = 0;

                for (Integer weight : sourceWarehouse.getProducts()) {
                    if (currentWeight + weight <= maxWeight) {
                        selectedProducts.add(weight);
                        currentWeight += weight;
                    } else {
                        break;
                    }
                }

                System.out.println("Loader " + id + " is carrying " + selectedProducts + " with total weight " + currentWeight);
                sourceWarehouse.removeProducts(selectedProducts);
                destinationWarehouse.getProducts().addAll(selectedProducts);

                // Моделирование времени, необходимого для транспортировки и выгрузки продуктов
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}