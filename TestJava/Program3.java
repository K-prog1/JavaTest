public class Program3 {
    public static void main(String[] args){

        int randomint = (int) (Math.random() * 101);
        int randlist[] = new int[5]; 
        int min = randlist[0];
        int max = randlist[0];
        
        for (int i = 0; i < 5;i++ ){
            randlist[i] = randomint;
            min = randlist[0];
            max = randlist[0];
            if (randlist[i] < min) min = randlist[i];
            if (randlist[i]> max) max = randlist[i];

        }
           System.out.print(randlist);
           System.out.print(min);
           System.out.print(max);
    }
}
