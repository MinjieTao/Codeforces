import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    Arrays.sort(data);
    if(data[0] <= k+1) System.out.println(data[0]);
    else
    {
        int[] csum = new int[1000002];
        for(int i =0; i<n; i++) csum[data[i]]++;
        for(int i = 1; i<1000002; i++) csum[i] += csum[i-1];
        int res = k+1;
        for(int i = k+2; i<=data[0]; i++)
        {
            int count = 0;
            for(int j = 0; j<=1000000; j+= i)
            {
                count += csum[Math.min(j+k, 1000001)];
                count -= (j == 0 ? 0 : csum[j-1]);
            }
            if(count == n) res = Math.max(res, i);
        }
        System.out.println(res);
    }
}
}