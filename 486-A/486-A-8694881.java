import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    long n = input.nextLong();
    long res = (n/2);
    if(n%2 == 1) res -= n;
    System.out.println(res);
}
}