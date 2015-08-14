import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt(), a = input.nextInt(), b = input.nextInt();
    int res = 0;
    if(b < a*m)
        while(n >= m)
        {
            res += b;
            n -= m;
        }
    if(b < a*n && m >= n) res += b;
    else res += a*n;
    System.out.println(res);
}
}