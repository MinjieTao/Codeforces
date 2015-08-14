import java.io.PrintWriter;
import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    long a = input.nextInt(), b = input.nextInt();
    if(a == 0)
    {
        out.println(-b*b);
        for(int i = 0; i<b; i++) out.print('x');
        out.close();
        return;
    }
    if(b == 0)
    {
        out.println(a*a);
        for(int i = 0; i<a; i++) out.print('o');
        out.close();
        return;
    }
    int besti = -1, bestj = -1;
    long res = (long)-1e15;
    for(int i = 1; i<=a; i++)
    {
        long cur = (a - i + 1)*(a-i + 1) + (i-1);
        for(int j = i-1; j<= i+1; j++)
        {
            if(j <= 0 || j>b) continue;
            long per = b/j, extra = b%j;
            long y = extra * (per+1) * (per+1) + (j-extra)*per*per;
            long tot = (cur - y);
            if(tot > res)
            {
                res = tot;
                besti = i;
                bestj = j;
            }
        }
    }
    ArrayList<Long> group1 = new ArrayList<Long>(), group2 = new ArrayList<Long>();
    group1.add((a-besti+1));
    for(int i = 0; i<besti-1; i++) group1.add(1l);
    long avg = b/bestj, extra = b%bestj;
    for(int i = 0; i<extra; i++) group2.add(avg+1);
    while(group2.size() < b) group2.add(avg);
    out.println(res);
    if(besti >= bestj)
    {
        for(int i= 0; i<bestj; i++)
        {
            long xs = group1.get(i);
            for(int j= 0;j<xs; j++) out.print('o');
            long os = group2.get(i);
            for(int j= 0;j<os; j++) out.print('x');
        }
        if(besti > bestj)
        {
            long xs = group1.get(group1.size()-1);
            for(int j = 0; j<xs; j++) out.print('o');
        }
    }
    else
    {
        for(int i= 0; i<besti; i++)
        {
            long os = group2.get(i);
            for(int j= 0;j<os; j++) out.print('x');
            long xs = group1.get(i);
            for(int j= 0;j<xs; j++) out.print('o');
        }
        if(besti < bestj)
        {
            long os = group2.get(group2.size()-1);
            for(int j = 0; j<os; j++) out.print('x');
        }
    }
    out.close();
}
}