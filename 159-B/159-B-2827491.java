import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        int[] mcolor = new int[n], msize = new int[n];
        int[] mcolorcount = new int[1001], ccolorcount = new int[1001];
        int[] mcount = new int[2000001], ccount = new int[2000001];
        for(int i = 0; i<n; i++)
        {
            mcolor[i] = input.nextInt();
            msize[i] = input.nextInt();
            mcolorcount[msize[i]]++;
            mcount[mcolor[i] + 1000*msize[i]]++;
        }
        int[] ccolor = new int[m], csize = new int[m];
        for(int i = 0; i<m; i++)
        {
            ccolor[i] = input.nextInt();
            csize[i] = input.nextInt();
            ccolorcount[csize[i]]++;
            ccount[ccolor[i]+1000*csize[i]]++;
        }
        int res1 = 0, res2 = 0;
        for(int i = 1; i<=1000; i++)
            res1 += Math.min(mcolorcount[i], ccolorcount[i]);
        for(int i = 1; i<=2000000; i++)
            res2 += Math.min(mcount[i], ccount[i]);
        System.out.println(res1 + " " + res2);
    }
}