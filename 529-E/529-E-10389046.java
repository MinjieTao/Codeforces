import java.util.*;
public class e {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt();
    boolean[] have = new boolean[10000001];
    int[] vals = new int[n];
    for(int i = 0; i<n; i++) have[vals[i] = input.nextInt()] = true;
    int Q = input.nextInt();
    for(int q = 0; q<Q; q++)
    {
        int x = input.nextInt();
        int min = k+1;
        for(int i = 0; i<n; i++)
            for(int j = 0; j<k; j++)
            {
                int need = x - j * vals[i];
                if(need < 0) continue;
                for(int l = 1; l<=k - j; l++)
                {
                    if(need%l == 0 && need/l < have.length && have[need/l])
                        min = Math.min(min, j+l);
                }
            }
        System.out.println(min > k ? -1 : min);
    }
}
}