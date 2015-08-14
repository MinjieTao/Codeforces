import java.io.*;
import java.util.*;
public class A138 {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    String s = input.next();
    int n = s.length();
    int[] pair = new int[n];
    Arrays.fill(pair, -1);
    int[] csum = new int[n+1];
    for(int i = 0; i<n; i++)
    {
        char c = s.charAt(i);
        csum[i+1] = csum[i];
        if(c == '[') csum[i+1]++;
    }
    Stack<Integer> stk = new Stack<Integer>();
    for(int i = 0; i<n; i++)
    {
        char c = s.charAt(i);
        if(c == '[' || c == '(') stk.add(i);
        else
        {
            if(stk.isEmpty()) continue;
            char last = s.charAt(stk.peek());
            if(c == ']')
            {
                if(last == '[')
                {
                    int prev = stk.pop();
                    pair[i] = prev;
                    pair[prev] = i;
                }
                else stk.clear();
            }
            else
            {
                if(last == '(')
                {
                    int prev = stk.pop();
                    pair[i] = prev;
                    pair[prev] = i;
                }
                else stk.clear();
            }
        }
    }
    RMQ rmq = new RMQ(pair);
    int max = 0;
    int maxLeft = -1, maxRight = -1;
    for(int start = 0; start < n; start++)
    {
        int lo = start, hi = n;
        while(lo < hi - 1)
        {
            int mid = (lo+hi)/2;
            if(rmq.query(start, mid) < 0) hi = mid;
            else lo = mid;
        }
        int cur = csum[lo] - csum[start];
//      /System.out.println(cur+" "+cands.get(start)+" "+cands.get(lo));
        if(cur > max)
        {
            max = cur;
            maxLeft = start;
            maxRight = lo;
        }
    }
    PrintWriter out = new PrintWriter(System.out);
    out.println(max);
    for(int i = maxLeft; i<= maxRight && max > 0; i++)
    {
        out.print(s.charAt(i));
    }
    out.close();
}
static class RMQ
{
    /*
     * RMQ - range minimum query
     * O(nlogn) preprocessing, O(1) query
     * Store the array in a, then call preprocess().
     * Then, query(i, j) will return minimum between indices i and j (i<=j).
     */
    public RMQ(int[] aa)
    {
        a = aa;
        preprocess();
    }
    int[][] rmq;
    int[] a;
    int[] memo;
    int log(int x)
    {
        if(memo[x] != -1) return memo[x];
        return memo[x] = Integer.numberOfTrailingZeros(Integer.highestOneBit(x));
    }
    void preprocess()
    {
        int n = a.length;
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        rmq = new int[n][log(n)+1];
        for(int i = 0; i<n; i++) rmq[i][0] = i;
        for(int j = 1; (1<<j) <= n; j++)
            for(int i = 0; i + (1<<j) <= n; i++)
                if(a[rmq[i][j-1]] < a[rmq[i+(1<<(j-1))][j-1]])
                    rmq[i][j] = rmq[i][j-1];
                else rmq[i][j] = rmq[i+(1<<(j-1))][j-1];
    }
    int query(int i, int j)
    {
        int k = log(j - i + 1);
        return Math.min(a[rmq[i][k]], a[rmq[j-(1<<k)+1][k]]);
    }
}
public static class input {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}
}