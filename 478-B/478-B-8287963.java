import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    long n = input.nextLong(), m = input.nextLong();
    long max = (n - m + 1) * (n - m) / 2;
    long big = n%m;
    long small = m - n%m;
    long min = small * (n/m) * (n/m - 1) / 2;
    min += big * (n/m) * (n/m + 1) / 2;
    System.out.println(min+" "+max);
}
}