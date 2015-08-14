import java.io.*;
import java.util.*;
public class b {
public static void main(String[] args) throws IOException
{
    Reader.init(System.in);
    int n = Reader.nextInt();
    int[] data = new int[n];
    for(int i =0; i<n; i++)
        data[i] = Reader.nextInt();
    TreeSet<Integer>[] factors = new TreeSet[n];
    for(int i = 0; i<n; i++)
        factors[i] = new TreeSet<Integer>();
    for(int i =0; i<n; i++)
    {
        int x = data[i];
        for(int j = 2; j<=Math.sqrt(x); j++)
        {
            while(x%j == 0)
            {
                factors[i].add(j);
                x/=j;
            }
        }
        if(x>1) factors[i].add(x);
    }
    int[] max = new int[100001];
    TreeSet<Integer>[] indices = new TreeSet[100001];
    for(int i =0 ; i<100001; i++)
        indices[i] = new TreeSet<Integer>();
    max[1] = 1;
    for(int i = 0; i<n; i++)
    {
        int best = 1;
        for(int f: factors[i])
        {
            //System.out.println(f + " " + max[f]);
            best = Math.max(best, max[f]+1);
        }
        //System.out.println(best);

        for(int f: factors[i])
        {
            //System.out.println("F: " + f);
            max[f] = best;
        }
//      if(best>0)
//      for(int index: indices[best-1])
//      {
//          if(gcd(data[index], data[i]) > 1)
//          {
//              indices[best].add(index);
//              for(int f: factors[index])
//                  max[f] = Math.min(max[f]+1, best);
//          }
//      }
//      for(int j = 0; j<=10; j++)
//          System.out.print(max[j]+" ");
//      System.out.println();
        indices[best].add(i);
    }
    //System.out.println(max[2]);
    int res = 0;
    for(int i = 0; i<=100000; i++)
        res = Math.max(res,  max[i]);
    System.out.println(res);
}
public static int gcd(int a, int b)
{
    if(b==0) return a;
    return gcd(b, a%b);
}
public static class Reader {
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
}
}