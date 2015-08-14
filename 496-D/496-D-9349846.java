import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    TreeSet<Pair> res = new TreeSet<Pair>();
    precomp(data);
    for(int i = 1; i<=n; i++)
    {
        int s = getS(i, data);
        if(s == -1) continue;
        res.add(new Pair(s, i));
    }
    System.out.println(res.size());
    for(Pair p: res) System.out.println(p.s+" "+p.t);
}
static class Pair implements Comparable<Pair>
{
    int s, t;
    public Pair(int ss, int tt)
    {
        s = ss; t = tt;
    }
    @Override
    public int compareTo(Pair o) {
        // TODO Auto-generated method stub
        if(s != o.s) return s - o.s;
        return t - o.t;
    }
}
static int n;
static int[] getA, getB, scoreA, scoreB;
static void precomp(int[] data)
{
    scoreA = new int[n];
    scoreB = new int[n];
    for(int i = 0; i<n; i++)
    {
        int lastA = (i == 0 ? 0 : scoreA[i-1]);
        int lastB = (i == 0 ? 0 : scoreB[i-1]);
        scoreA[i] = data[i] == 1 ? lastA + 1 : lastA;
        scoreB[i] = data[i] == 2 ? lastB + 1 : lastB;
    }
    getA = new int[n];
    getB = new int[n];
    int atA = 0, atB = 0;
    Arrays.fill(getA, n);
    Arrays.fill(getB, n);
    for(int i = 0; i<n; i++)
    {
        if(data[i] == 1) getA[atA++] = i;
        else getB[atB++] = i;
    }
}
static int getS(int t, int[] data)
{
    int sa = 0, sb = 0;
    boolean end = false;
    int usedA = -1, usedB = -1;
    //int at = 0;
    while(true)
    {
        int nextA = usedA + t >= n ? n : getA[usedA + t];
        int nextB = usedB + t >= n ? n : getB[usedB + t];
        int nextPos = Math.min(nextA, nextB);
        if(nextPos >= n) break;
        if(data[nextPos] == 1)
        {
            sa++;
        }
        else sb++;
        usedA = scoreA[nextPos]-1;
        usedB = scoreB[nextPos]-1;
        if(nextPos == n-1) end = true;
        //System.out.println(nextPos);
        //at = nextPos;
    }
    //System.out.println(t+" "+sa+" "+sb+" "+end);
    if(!end) return -1;
    if(data[n-1] == 1 && sa > sb) return sa;
    if(data[n-1] == 2 && sb> sa) return sb;
    return -1;
}
}