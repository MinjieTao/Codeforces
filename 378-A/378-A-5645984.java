import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int x = input.nextInt(), y = input.nextInt();
    int a = 0, b = 0, c = 0;
    for(int i = 1; i<=6; i++)
    {
        int d1 = Math.abs(i-x), d2 = Math.abs(i-y);
        if(d1<d2) a++;
        else if(d1==d2) b++;
        else c++;
    }
    System.out.println(a+" "+b+" "+c);
}
}