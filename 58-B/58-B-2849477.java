import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.print(n);
        for(int i = 2; i<=Math.sqrt(n); i++)
        {
            if(n%i==0)
            {
                n/=i;
                i--;
                System.out.print(" "+n);
            }
        }
        if(n > 1) System.out.print(" 1");
        
    }
}