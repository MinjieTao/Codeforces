import java.util.*;
    import java.io.*;
     import java.math.*;
    public class square
    {
    public static void main(String[] args)
    {
    Scanner input = new Scanner(System.in);
    int m = input.nextInt();
    int n = input.nextInt();
    int a = input.nextInt();
    int x = m/a;
    if(m%a!=0)
    x++;
    int y = n/a;
    if(n%a!=0)
    y++;
     BigInteger b = new BigInteger(x + "");
     BigInteger c = new BigInteger(y + "");

    System.out.println(b.multiply(c));
    }
    }