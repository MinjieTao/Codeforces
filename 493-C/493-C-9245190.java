import java.util.*;
import java.io.*;
public class c {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int n = input.nextInt();
    TreeSet<Integer> nums = new TreeSet<Integer>();
    for(int i = 0; i<n; i++)
    {
        int v = input.nextInt();
        nums.add(v);
        if(!map.containsKey(v)) map.put(v, 1);
        else map.put(v, map.get(v)+1);
    }
    HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
    int m = input.nextInt();
    for(int i = 0; i<m; i++)
    {
        int v = input.nextInt();
        nums.add(v);
        if(!map2.containsKey(v)) map2.put(v, 1);
        else map2.put(v, map2.get(v)+1);
    }
    int bestA = n, bestB = m, curA = n, curB = m;
    for(int x : nums)
    {
        if(map.containsKey(x)) curA -= map.get(x);
        if(map2.containsKey(x)) curB -= map2.get(x);
        if(curA - curB > bestA - bestB)
        {
            bestA = curA;
            bestB = curB;
        }
    }
    System.out.println((2*n + bestA) + ":" + (2*m + bestB));
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