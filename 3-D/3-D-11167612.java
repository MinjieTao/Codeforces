import java.util.*;
public class D3 {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String s = input.next();
    long sum = 0;
    int n = s.length();
    char[] res = s.toCharArray();
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
    boolean good = true;
    for(int i = 0; i<n; i++)
    {
        if(res[i] == '(')
        {
            pq.add(new Pair(-987654321, i));
        }
        else if(res[i] == '?')
        {
            int a = input.nextInt(), b = input.nextInt();
            sum += b;
            pq.add(new Pair(a-b, i));
        }
        if(i%2 == 0)
        {
            if(pq.isEmpty())
            {
                good = false;
                break;
            }
            Pair p = pq.poll();
            if(p.v != -987654321) sum += p.v;
            res[p.i] = '(';
        }
    }
    for(int i = 0; i<n; i++)
    {
        if(res[i] != '(') res[i] = ')';
    }
    if(n%2 != 0) good = false;
    if(!pq.isEmpty() && pq.poll().v == -987654321) good = false;
    if(good)
    {
        System.out.println(sum);
        System.out.println(new String(res));
    }
    else
    {
        System.out.println(-1);
    }
}
static class Pair implements Comparable<Pair>
{
    int v, i;
    public Pair(int vv, int ii)
    {
        v = vv; i = ii;
    }
    @Override
    public int compareTo(Pair o) {
        // TODO Auto-generated method stub
        return v - o.v;
    }
}
}