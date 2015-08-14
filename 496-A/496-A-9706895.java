import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    int min = 1001;
    for(int i = 0; i<n; i++)
    {
        if(i == 0 || i == n-1) continue;
        int max = 0;
        for(int j = 0; j<n-1; j++)
        {
            if(i == j) continue;
            if(j == i-1) max = Math.max(max, data[i+1] - data[i-1]);
            else max = Math.max(max, data[j+1] - data[j]);
        }
        min = Math.min(min,  max);
    }
    System.out.println(min);
}
}