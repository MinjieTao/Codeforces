import java.util.*;
public class a{
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    char[] a = input.next().toCharArray(), b = input.next().toCharArray();
    int res = 0;
    for(int i = 0; i < n; i++)
    {
    int cur = Math.abs(a[i] - b[i]);
    if(cur > 5) cur = 10 - cur;
    res += cur;
    }
    System.out.println(res);
}
}