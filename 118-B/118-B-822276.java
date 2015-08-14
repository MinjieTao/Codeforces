import java.util.*;
public class PresentLena {

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 0; i<=n; i++)
        {
            for(int j = 0; j<2*(n-i); j++)
                System.out.print(" ");
            if(i!=0)
            {
            for(int j = 0; j<=i; j++)
                System.out.print(j + " ");
            for(int j = i-1; j>0; j--)
                System.out.print(j + " ");
                System.out.print(0);
            }
            else
                System.out.print(0);
            System.out.println();
        }
        for(int i = n-1; i>=0; i--)
        {
            for(int j = 0; j<2*(n-i); j++)
                System.out.print(" ");
            if(i!=0)
            {
            for(int j = 0; j<=i; j++)
                System.out.print(j + " ");
            for(int j = i-1; j>0; j--)
                System.out.print(j + " ");
            }
                System.out.print(0);
            System.out.println();
        }

    }

}