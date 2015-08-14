import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] as = new int[n];
    for(int i = 0;i<n; i++) as[i] = input.nextInt();
    int m = input.nextInt();
    int[] bs = new int[m];
    for(int i = 0; i<m; i++) bs[i] = input.nextInt();
    Arrays.sort(as);
    Arrays.sort(bs);
    int i = 0, j = 0;
    int res =0;
    while(i < n && j < m)
    {
        if(Math.abs(as[i] - bs[j]) <= 1)
        {
            res++; i++; j++;
        }
        else if(as[i] < bs[j]) i++;
        else j++;
    }
    System.out.println(res);
}
}