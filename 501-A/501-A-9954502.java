import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int a = input.nextInt(), b = input.nextInt(), c = input.nextInt(), d = input.nextInt();
    a = Math.max(3*a/10, a - a/250 * c);
    b = Math.max(3*b/10, b - b/250 * d);
    if(a>b) System.out.println("Misha");
    else if(a<b) System.out.println("Vasya");
    else System.out.println("Tie");
}
}