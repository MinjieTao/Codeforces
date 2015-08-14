import java.util.*;
import java.io.*;
public class E5 {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    //while(true)
    {
        //Random r = new Random();
    int n = input.nextInt();
        //int n = 100;
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    //for(int i = 0; i<n; i++) data[i] = r.nextInt(100)+1;
    int max = 0, maxi = 0;
    for(int i = 0; i<n; i++)
    {
        int x = data[i];
        if(x > max)
        {
            max = x;
            maxi = i;
        }
    }
    int[] rot = new int[n+1];
    for(int i = 0; i<n; i++) rot[i] = data[(i+maxi)%n];
    rot[n] = rot[0];
    long res = go(rot);
    //System.out.println(Arrays.toString(mark));
//  int m = 0;
//  for(int i = 1; i <n; i++)
//  {
//      //System.out.println(i+" "+rot[i]+" "+m+" "+mark[i]);
//      if(rot[i] >= m && !mark[i]) mark[i] = true;
//      m = Math.max(m, rot[i]);
//  }
//  
//  m = 0;
//  for(int i = n - 1; i >0; i--)
//  {
//      //System.out.println(i+" "+rot[i]+" "+m+" "+mark[i]);
//      if(rot[i] >= m && !mark[i]) res++;
//      m = Math.max(m, rot[i]);
//  }
    max = 0;
    int maxc = 0;
    for(int i = 1; i<n; i++)
    {
        if(rot[i] > max)
        {
            max = rot[i];
            maxc = 1;
        }
        else if(rot[i] == max) maxc++;
    }
    System.out.println(res - maxc - 1);
//  if(res - maxc - 1 != bf(data))
//  {
//      System.out.println(res);
//  System.out.println(Arrays.toString(data)+" "+(res - maxc - 1)+" "+bf(data));
//  //break;
//  }
//  else System.out.println("GOOD");
    }
}
static long bf(int[] data)
{
    int n = data.length;
    long res = 0;
    for(int i = 0; i<n; i++)
    {
        for(int j = i+1; j<n; j++)
        {
            boolean good1 = true, good2 = true;
            for(int k = 0; k<n; k++)
            {
                if(k > i && k < j && data[k] > Math.min(data[i], data[j])) good1 = false;
                else if((k < i || k > j) && data[k] > Math.min(data[i], data[j])) good2 = false;
            }
            if(good1 || good2) res++;
        }
    }
    return res;
}
static boolean[] mark;
static long go(int[] data)
{
    //System.out.println(Arrays.toString(data));
    int n = data.length;
    mark = new boolean[n];
    int[] stk = new int[2*n];
    long res = 0;
    for(int i = 0; i<n; i++)
    {
        int x = data[i];
        int y = firstGreater(stk, x);
        if(y == 0) y++;
        //if(y < 2) mark[i] = true;
        res += stk[0] - y + 1;
        //System.out.println(i+" "+(stk[0] - y +1));
        //System.out.println(x+":");
        //for(int j = y; j<=stk[0]; j++) System.out.println(stk[j]);
        while(stk[0] > 0 && stk[stk[0]] < x) stk[0]--;
        stk[++stk[0]] = x;
    }
    return res;
}
static int firstGreater(int[] a, int x)
{
    int n = a[0]+1;
    int lo = 0;
    int hi = n;
    while(hi > lo + 1)
    {
        int mid = (lo+hi)>>1;
        if(a[mid] <= x) hi = mid;
        else lo = mid;
    }
    return lo;
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