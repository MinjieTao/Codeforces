import java.util.*;
import java.io.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    ArrayList<Integer> zs = new ArrayList<Integer>();
    for(int i = 0; i<n; i++) if(data[i] == 0) zs.add(i);
    int at = 0;
    for(int i =0; i<zs.size(); i++)
    {
        int aat = at;
        PriorityQueue<myNum> pq = new PriorityQueue<myNum>();
        while(aat<zs.get(i))
        {
            pq.add(new myNum(data[aat], aat));
            //out.println(data[aat]+" "+aat);
            aat++;
        }
        int x = Math.min(pq.size(), 3);
        if(x>0)
        {
            int[] goods = new int[x];
            for(int j = 0; j<x; j++) goods[j] = pq.poll().i;
            Arrays.sort(goods);
            int p = 0;
            for(int j = at; j<aat; j++)
            {
                if(p<x && j == goods[p])
                {
                    if(p==0) out.println("pushQueue");
                    else if(p==1) out.println("pushStack");
                    else out.println("pushFront");
                    p++;
                }
                else
                {
                    if(p==0) out.println("pushStack");
                    else out.println("pushQueue");
                }
            }
        }
        out.print(x);
        for(int j =0; j<x; j++)
        {
            if(j==0) out.print(" popQueue");
            else if(j==1) out.print(" popStack");
            else out.print(" popFront");
        }
        out.println();
        at = aat+1;
    }
    for(int i = zs.size() > 0 ? zs.get(zs.size()-1)+1 : 0; i<n; i++) out.println("pushStack");
    out.close();
}
static class myNum implements Comparable<myNum>
{
    int n, i;
    public myNum(int nn, int ii)
    {
        n = nn; i = ii;
    }
    @Override
    public int compareTo(myNum p) {
        // TODO Auto-generated method stub
        if(p.n == n) return i - p.i;
        return p.n - n;
    }
}
}