import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Program5 {
    
}

class RandomFromArray{
    private int[] values;
    private int[] weights;
    private int[] ranges;
    private int sum;

    public RandomFromArray(int[] values, int[] weights){
        this.values = values;
        this. weights = weights;
        ranges = new int[values.length];

        sum = 0;
        for (int weight:weights) {
            sum += weight;
        }
        int lastSum = 0;
        for (int i = 0; i < ranges.length; i++){
            ranges[i] = lastSum;
            lastSum += weights[i];
        }
    }

    public int getRandom() {
        int random = (int) (Math.random() * (sum));
        int index = Arrays.binarySearch(ranges, random);
        return values[index >= 0 ? index : -index -2];
        }
     
    }

}