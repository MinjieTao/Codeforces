import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt();
    if(n == k) System.out.println(-1);
    else
    {
        int[] data = new int[n];
        for(int i = 0; i<k; i++)
            data[i+1] = i+2;
        if(k+1 < n) data[k+1] = 1;
        data[0] = k==n-1 ? 1 : n;
        for(int i = k+2; i<n; i++)
            data[i] = i;
        for(int i = 0; i<n; i++) System.out.print(data[i]+" ");
    }
}
}