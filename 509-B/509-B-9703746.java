import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt();
    int[] as = new int[n];
    int[][] res = new int[n][];
    int min = 101;
    for(int i = 0; i<n; i++)
    {
        as[i] = input.nextInt();
        min = Math.min(as[i], min);
        res[i] = new int[as[i]];
    }
    int[] ptrs = new int[n];
    for(int i = 0; i<n; i++)
        for(int j = 0; j<min+1 && j < as[i]; j++)
        {
            res[i][ptrs[i]] = 1;
            ptrs[i]++;
        }
    for(int i = 2; i<=k; i++)
    {
        for(int j = 0; j<n; j++)
        {
            if(ptrs[j] < as[j])
            {
                res[j][ptrs[j]] = i;
                ptrs[j]++;
            }
        }
    }
    boolean good = true;
    for(int i = 0; i<n; i++) good &= ptrs[i] == as[i];
    if(!good) System.out.println("NO");
    else
    {
        System.out.println("YES");
        for(int i = 0; i<n; i++)
        {
            for(int x : res[i])
                System.out.print(x+" ");
                    System.out.println();
        }
    }
}
}