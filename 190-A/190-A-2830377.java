import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int a = input.nextInt(),b = input.nextInt();
    if(a==0)
        System.out.println(b > 0 ? "Impossible" : "0 0");
    else
    {
        int max = a+b-Math.min(b,1), min = a+b-Math.min(a, b);
        System.out.println(min + " " + max);
    }
}
}