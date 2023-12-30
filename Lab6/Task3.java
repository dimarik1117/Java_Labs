import java.util.concurrent.ConcurrentHashMap;
import java.util.Map.Entry;

public class Task3 {
    private ConcurrentHashMap<String, Integer> salesData;

    public Task3() {
        salesData = new ConcurrentHashMap<>();
    }

    public void recordSale(String product, int quantity) {
        salesData.put(product, salesData.getOrDefault(product, 0) + quantity);
    }

    public void printSalesReport() {
        System.out.println("Sales Report:");
        for (Entry<String, Integer> entry : salesData.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public int getTotalSales() {
        int totalSales = 0;
        for (Integer quantity : salesData.values()) {
            totalSales += quantity;
        }
        return totalSales;
    }

    public String getMostPopularProduct() {
        String mostPopularProduct = null;
        int maxQuantity = 0;
        for (Entry<String, Integer> entry : salesData.entrySet()) {
            int quantity = entry.getValue();
            if (quantity > maxQuantity) {
                mostPopularProduct = entry.getKey();
                maxQuantity = quantity;
            }
        }
        return mostPopularProduct;
    }

    public static void main(String[] args) {
        Task3 salesTracker = new Task3();

        salesTracker.recordSale("Cheese", 5);
        salesTracker.recordSale("Milk", 10);
        salesTracker.recordSale("Cheese", 3);

        salesTracker.printSalesReport();
        System.out.println("Total Sales: " + salesTracker.getTotalSales());
        System.out.println("Most Popular Product: " + salesTracker.getMostPopularProduct());
    }
}