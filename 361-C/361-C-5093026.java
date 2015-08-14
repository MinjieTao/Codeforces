import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    int[] data = new int[n];
    int[] upper = new int[n];
    int[] ts = new int[m], ls = new int[m], rs = new int[m], ds = new int[m];
    Arrays.fill(upper, 1000000000);
    for(int i = 0; i<m; i++)
    {
        int type = input.nextInt();
        ts[i] = type;
        if(type == 1)
        {
            ls[i] = input.nextInt()-1; rs[i] = input.nextInt()-1; ds[i] = input.nextInt();
            for(int j = ls[i]; j<=rs[i]; j++) data[j] += ds[i];
        }
        else
        {
            ls[i] = input.nextInt()-1; rs[i] = input.nextInt()-1; ds[i] = input.nextInt();
            for(int j = ls[i]; j<=rs[i]; j++) upper[j] = Math.min(upper[j], ds[i] - data[j]);
        }
    }
    int[] copy = new int[n];
    for(int i =0; i<n; i++) copy[i] = upper[i];
    boolean good = true;
    for(int i = 0; i<m; i++)
    {
        int type = ts[i], l = ls[i], r = rs[i], d = ds[i];
        if(type == 1)
        {
            for(int j = l; j<=r; j++) copy[j] += d;
        }
        else
        {
            int max = d;
            int mm = -2000000000;
            for(int j = l; j<=r; j++) mm = Math.max(mm,copy[j]);
            //System.out.println(mm);
            good &= mm == max;
        }
    }
    if(good)
    {
        System.out.println("YES");
        for(int i= 0; i<n; i++) System.out.print(upper[i]+" ");
    }
    else System.out.println("NO");
}
}