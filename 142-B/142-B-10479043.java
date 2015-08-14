import java.util.*;
public class B102 {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    int res = Math.max((n+2)/3 * m, (m+2)/3 * n);
    if(m > 1) res = Math.max(res, ((n+3)/4 + (n+2)/4) * 2);
    if(n > 1) res = Math.max(res, ((m+3)/4 + (m+2)/4) * 2);
    res = Math.max(res, (n*m+1)/2);
    System.out.println(res);
}
}