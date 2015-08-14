import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int k = input.nextInt(), d = input.nextInt();
    if(d == 0) System.out.println(k==1 ? "0" : "No solution");
    else if(k==1) System.out.println(d);
    else
    {
        System.out.print(1);
        for(int i = 0; i<k-2; i++) System.out.print(0);
        System.out.println(d-1);
    }
}
}