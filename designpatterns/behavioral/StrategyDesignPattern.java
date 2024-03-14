package designpatterns.behavioral;

public class StrategyDesignPattern {
    public static void main(String[] args) {
        SortingContext sortingContext = new SortingContext();

        // Bubble sort
        sortingContext.setStrategy(new BubbleSort());
        sortingContext.performSort(new int[]{3, 1, 5, 2, 4});

        // Merge sort
        sortingContext.setStrategy(new MergeSort());
        sortingContext.performSort(new int[]{3, 1, 5, 2, 4});

        // Quick sort
        sortingContext.setStrategy(new QuickSort());
        sortingContext.performSort(new int[]{3, 1, 5, 2, 4});
    }
}


// Strategy
interface SortingStrategy {
    void sort(int[] array);
}

// Concrete Strategies
class BubbleSort implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        // Bubble sort implementation
        System.out.println("Sorting using Bubble Sort");
    }
}

class MergeSort implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        // Merge sort implementation
        System.out.println("Sorting using Merge Sort");
    }
}

class QuickSort implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        // Quick sort implementation
        System.out.println("Sorting using Quick Sort");
    }
}

// Context
class SortingContext {
    private SortingStrategy strategy;

    void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    void performSort(int[] array) {
        strategy.sort(array);
    }
}