import java.util.*;
public class e {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt(), k = input.nextInt();
    int[] data = new int[k];
    boolean[] marked = new boolean[n];
    for(int i = 0; i<k; i++) marked[(data[i] = input.nextInt())-1] = true;
    ArrayList<Integer> bads = new ArrayList<Integer>();
    for(int i = 0; i<n; i++) if(!marked[i]) bads.add(i+1);
    if(k==n || n==2) System.out.println(-1);
    else
    {
        int maxPart1 = 1, maxPossible = 0;
        int left = n-bads.size();
        for(int i = 1; i<left; i++)
        {
            int part1 = i, part2 = left-part1;
            int c = bads.size(), a = part1, b = part2;
            int possible = a*(a-1)/2 + b*(b-1)/2 + (c-1)*(c-2)/2 + c - 1 + a*c + b*c;
            if(possible > maxPossible)
            {
                maxPart1 =i;
                maxPossible = possible;
            }
        }
        int part1 = maxPart1;
        if(maxPossible < m) System.out.println(-1);
        else
        {
            int[] part = new int[n];
            int count = 0;
            for(int i = 0; i<n && count < part1; i++)
            {
                if(marked[i])
                {
                    part[i] = 1;
                    count++;
                }
            }
            for(int i = 0; i<n; i++)
                if(part[i] == 0 && marked[i]) part[i] = 2;
            ArrayList<Integer> as = new ArrayList<Integer>();
            ArrayList<Integer> bs = new ArrayList<Integer>();
            for(int i = 0; i<n; i++)
                if(part[i] == 1) as.add(i+1);
                else if(part[i] == 2) bs.add(i+1);
            
            int es = 0;
            int x = bads.get(0);
            for(int i = 1; i<=n; i++)
            {
                if(i != x)
                {
                    System.out.println(x+" "+i);
                    es++;
                }
            }
            bads.remove(0);
            for(int i = 0; i<as.size() && es<m; i++)
            {
                for(int j = 0; j<bads.size() && es<m; j++)
                {
                    es++;
                    System.out.println(bads.get(j)+" "+as.get(i));
                }
            }
            for(int i = 0; i<bs.size() && es < m; i++)
            {
                for(int j = 0; j<bads.size() && es<m; j++)
                {
                    es++;
                    System.out.println(bads.get(j)+" "+bs.get(i));
                }
            }
            for(int i = 0; i<as.size() && es<m; i++)
            {
                for(int j= i+1; j<as.size() && es<m; j++)
                {
                    System.out.println(as.get(i)+" "+as.get(j));
                    es++;
                }
            }
            for(int i = 0; i<bs.size() && es<m; i++)
            {
                for(int j= i+1; j<bs.size() && es<m; j++)
                {
                    System.out.println(bs.get(i)+" "+bs.get(j));
                    es++;
                }
            }
            for(int i =0; i<bads.size() && es<m; i++)
            {
                for(int j = i+1; j<bads.size() && es<m; j++)
                {
                    System.out.println(bads.get(i)+" "+bads.get(j));
                    es++;
                }
            }
                
        }
    }
}
}