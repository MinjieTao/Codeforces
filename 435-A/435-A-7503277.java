import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    int res = 0, cur = 0;
    while(cur < n)
    {
        int left = m;
        while(left > 0)
        {
            if(cur == n || data[cur] > left) break;
            left -= data[cur];
            cur++;
        }
        res++;
    }
    System.out.println(res);
}
}