import java.util.Arrays;

public class Program7 {
    
    public static void main(String[] args) {
        // Исходный массив не отсортирован (ноль в конце)
        double numbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        double number = 4;

        // 1. Линейный поиск (BruteForce) работает на ЛЮБОМ массиве
        int bruteForceIndex = BruteForce(numbers, number);
        System.out.println("--- Линейный поиск ---");
        if (bruteForceIndex == -1) {
            System.out.println("К сожалению число не найдено");
        } else {
            System.out.printf("Такое число есть! Находится под оригинальным индексом: %d\n\n", bruteForceIndex);
        }

        // 2. Для бинарного поиска ОБЯЗАТЕЛЬНО сначала сортируем массив
        double[] sorted = bubblesort(numbers);
        System.out.println("Отсортированный массив: " + Arrays.toString(sorted));

        int binaryIndex = BinarySearch(sorted, number);
        System.out.println("--- Бинарный поиск ---");
        if (binaryIndex == -1) {
            System.out.println("К сожалению число не найдено");
        } else {
            System.out.printf("Такое число есть! В отсортированном массиве оно под индексом: %d\n", binaryIndex);
        }
    }

    public static int BruteForce(double array[], double key){
        for (int i =  0; i < array.length; i++){
            if (array[i] == key){
                return i;
            }
        }
        return -1;

    }

    public static double[] bubblesort(double array[]){
        double temp;
        double sortedarray[] = Arrays.copyOf(array, array.length);
        for (int i = 0; i < array.length - 1; i++)
            for ( i = 0; i < array.length -1; i++ )
                if (sortedarray[i] > sortedarray[i+1]){
                    temp = sortedarray[i];
                    sortedarray[i] = sortedarray[i+1];
                    sortedarray[i+1] = temp;
                }
            return sortedarray;
        
        
    }


    public static int BinarySearch(double sortedarray[], double key){
        
        int low = 0;
        int high = sortedarray.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (sortedarray[mid] == key){
                return mid;
            }
            if (sortedarray[mid] < key) {
                low = mid + 1;  
            } else {
                high = mid - 1; 
            }
        }
        return -1;
        
        
    }

}
