import java.util.Arrays;
import java.util.Comparator;

class Item {
    int weight;
    int value;

    // Constructor
    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class FractionalKnapsack {

    // Function to get the maximum value in the knapsack
    public static double getMaxValue(Item[] items, int capacity) {
        // Sort items by value-to-weight ratio in descending order
        Arrays.sort(items, new Comparator<Item>() {
            public int compare(Item o1, Item o2) {
                double r1 = (double)o1.value / o1.weight;
                double r2 = (double)o2.value / o2.weight;
                return Double.compare(r2, r1);
            }
        });

        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity - item.weight >= 0) {
                // If the item can be added completely
                capacity -= item.weight;
                totalValue += item.value;
            } else {
                // If only part of the item can be added
                double fraction = ((double) capacity / item.weight);
                totalValue += (item.value * fraction);
                capacity = 0;
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        // Define items with weight and value
        Item[] items = {
            new Item(10, 60),
            new Item(20, 100),
            new Item(30, 120)
        };
        int capacity = 50;

        double maxValue = getMaxValue(items, capacity);
        System.out.println("Maximum value we can obtain = " + maxValue);
    }
}
