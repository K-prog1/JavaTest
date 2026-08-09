import java.util.Scanner;

class Program {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int num1 = in.nextInt();

        System.out.print("Введите второе число:  ");
        int num2 = in.nextInt();

        in.close();

        int nod = CalculateNod(num1, num2);
        int nok = CalculateNOK(num1, num2);
        System.out.printf("Nod: %d \nNok: %d", nod, nok);

    }

    public static int CalculateNod(int a, int b)
    {
        while (b != 0) {

            int temp = a%b;
            a = b;
            b = temp;
        }
        return Math.abs(a); 

    }

    public static int CalculateNOK(int a, int b)
    {
        if (a==0 || b==0)
            return 0;
        
        return (Math.abs(a*b)/CalculateNod(a, b));

      
    }
}   
