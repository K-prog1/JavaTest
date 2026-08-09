import java.util.Arrays;

public class Program3 {
    public static void main(String[] args){
       
        int randlist[] = new int[5]; 
        int temp;


        for (int i = 0; i < 5; i++){
            randlist[i] = (int) (Math.random() * 101);
        }
        
        int sortedlist[] = Arrays.copyOf(randlist, randlist.length);
        int min = randlist[0];
        int max = randlist[0];

        
        for (int i = 0; i < 5;i++ ){
            if (randlist[i] < min) min = randlist[i];
            if (randlist[i]> max) max = randlist[i];

        }
        for (int j = 0; j < sortedlist.length; j++){
            for (int i = 0; i < sortedlist.length - j - 1; i++){
                if (sortedlist[i] > sortedlist[i+1]){
                    temp = sortedlist[i];
                    sortedlist[i] = sortedlist[i + 1];
                    sortedlist[i+1] = temp;

            }
        }

        }
        
           System.out.println("Сортированный Массив:" + Arrays.toString(sortedlist));
           System.out.println("Массив: " + Arrays.toString(randlist));
           System.out.println("Минимум: " + min);
           System.out.println("Максимум: " + max);
    }
}
