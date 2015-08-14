import java.util.*;
public class PetyaCountryside {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] h = new int[n];
    for(int i = 0; i<n; i++)
        h[i] = input.nextInt();
    int max = 0;
    for(int i = 0; i<n; i++)
    {
        int j, k;
        for(j = i+1; j<n; j++)
        {
            if(h[j] > h[j-1])
                break;
        }
        for(k = i-1; k>=0; k--)
        {
            if(h[k] > h[k+1])
                break;
        }
        if(j-k-1 > max)
            max = j-k-1;
    }
    System.out.println(max);
}
}