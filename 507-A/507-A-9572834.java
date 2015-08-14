import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt();
    boolean[] use = new boolean[n];
    int[] data = new int[n];
    for(int i = 0; i<n; i++)
    {
        data[i] = input.nextInt();
    }
    int res = 0;
    while(true)
    {
        int min = -1;
        for(int i = 0; i<n; i++) if(!use[i] && (min == -1 || data[i] < data[min])) min = i;
        if(min == -1 || data[min] > k) break;
        res++;
        k -= data[min];
        use[min] = true;
    }
    System.out.println(res);
    for(int i = 0; i<n; i++) if(use[i]) System.out.print((i+1)+" ");
}
}