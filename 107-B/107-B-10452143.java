import java.util.*;
public class B83 {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt(), h = input.nextInt();
    int[] data = new int[m];
    int tot = 0;
    for(int i = 0; i<m; i++) tot += data[i] = input.nextInt();
    double prob = 1;
    if(tot < n) 
    {
        System.out.println(-1);
        return;
    }
    for(int i = 0; i<n-1; i++)
    {
        prob *= (tot - data[h-1]*1. - i) / (tot - 1 - i);
    }
    System.out.println(1 - prob);
}
}