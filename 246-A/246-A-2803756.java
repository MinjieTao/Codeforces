import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if(n<=2)
            System.out.println(-1);
        else
        {
            System.out.print("2 3 1");
            for(int i = 0; i<n-3; i++)
                System.out.print(" 5");
        }
    }
}