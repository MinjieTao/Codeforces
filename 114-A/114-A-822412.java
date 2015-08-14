import java.util.*;
public class Cifera {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        long a = input.nextLong();
        long b = input.nextLong();
        boolean done = false;
        long c = a;
        for(int i = 1; c<b; i++)
        {
            //System.out.println(a);
            c = c*a;
            if(c==b)
            {
                System.out.println("YES");
                System.out.println(i);
                done = true;
                break;
            }
        }
        if(!done)
        {
            if(a==b)
            {
                System.out.println("YES");
                System.out.println(0);
            }
            else
            System.out.println("NO");
        }
    }

}