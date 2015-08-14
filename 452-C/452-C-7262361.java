import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    double res = 1./n + (n-1) * (m-1) * 1. / (n * (n*m-1));
    if(n == 1) res = 1;
    System.out.println(res);
}
}