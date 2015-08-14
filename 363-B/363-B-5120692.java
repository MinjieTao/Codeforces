import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    int[] sums = new int[n];
    sums[0] = data[0];
    for(int i = 1; i<n; i++) sums[i] = sums[i-1] + data[i];
    int min = 2000000000;
    int mindex = -1;
    for(int i = 0; i<n; i++)
    {
        if(i+k-1 >= n) break;
        int sum = sums[i+k-1];
        int minus = i == 0 ? 0 : sums[i-1];
        sum -= minus;
        if(sum<min)
        {
            min = sum;
            mindex = i;
        }
    }
    System.out.println(mindex+1);
}
}