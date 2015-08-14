import java.util.Scanner;


public class EpicGame {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int n = input.nextInt();
        int turn = 0;
        while(true)
        {
            if(turn%2==0)
            {
                n -= gcd(a, n);
                if(n<0)
                {
                    System.out.println("1");
                break;
                }
            }
            else
            {
                n -= gcd(b, n);
                if(n<0)
                {
                    System.out.println("0");
                break;
                }
            }
            turn++;
        }
    }
    public static int gcd(int a, int b)
    {
        if(b==0)
            return a;
        else
            return gcd(b, a%b);
    }

}