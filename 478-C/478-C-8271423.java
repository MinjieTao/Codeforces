import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    long a = input.nextInt(), b = input.nextInt(), c = input.nextInt();
    long min = Math.min(a, Math.min(b,c));
    long max = Math.max(a, Math.max(b, c));
    long other = a+b+c-min-max;
    long res = a+b+c;
    if(max > 2*(other + min)) res -= (max - 2*(other + min));
    System.out.println(res/3);
}
}