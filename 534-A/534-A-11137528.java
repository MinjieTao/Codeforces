import java.util.*;
public class a{
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    if(n < 3) System.out.println("1\n1");
    else if(n ==3) System.out.println("2\n1 3");
    else if (n == 4) System.out.println ("4\n2 4 1 3");
    else if (n == 5) System.out.println ("5\n2 4 1 3 5");
    else
    {
        System.out.println(n);
        if(n%2 == 1) System.out.print(n+" ");
        for(int i = 0; i < n/2; i++) System.out.print((i+1)+" "+(i+n/2+1)+" ");
        
    }
}
}