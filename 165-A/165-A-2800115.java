import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] xs = new int[n], ys = new int[n];
        for(int i = 0; i<n; i++)
        {
            xs[i] = input.nextInt();
            ys[i] = input.nextInt();
        }
        int count = 0;
        for(int i = 0; i<n; i++)
        {
            boolean[] around = new boolean[4];
            for(int j = 0; j<n; j++)
            {
                if(j == i)
                    continue;
                else if(xs[j] == xs[i] && ys[j] > ys[i])
                    around[0] = true;
                else if(xs[j] == xs[i] && ys[j] < ys[i])
                    around[1] = true;
                else if(xs[j] > xs[i] && ys[j] == ys[i])
                    around [2] = true;
                else if(xs[j] < xs[i] && ys[j] == ys[i])
                    around[3] = true;
            }
            if(around[0] && around[1] && around[2] && around[3])
                count++;
        }
        System.out.println(count);
            
    }
}