import java.util.*;
import java.io.*;
public class C23 {
public static void main(String[] args) throws IOException
{
    Scanner input = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int T = input.nextInt();
    for(int t = 0; t<T; t++)
    {
    int n = input.nextInt() * 2 - 1;
    Pair[] data = new Pair[n];
    for(int i = 0; i<n; i++) data[i] = new Pair(input.nextInt(), input.nextInt(), i+1);
    Arrays.sort(data);
    long sb = 0;
    for(Pair p : data) sb += p.b;
    long s = 0;
    for(int i = 0; i<n; i+=2) s += data[i].b;
    out.println("YES");
    for(int i = 0; i<n; i++)
    {
        if(i == n-1 || (s * 2 >= sb ^ (i%2 == 1))) out.print(data[i].i+" ");
    }
    out.println();
    }
    out.close();
}
static class Pair implements Comparable<Pair>
{
    int a, b, i;
    public Pair(int aa, int bb, int ii)
    {
        a = aa; b = bb; i = ii;
    }
    @Override
    public int compareTo(Pair o) {
        // TODO Auto-generated method stub
        return a - o.a;
    }
}
}