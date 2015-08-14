import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), swaps = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    int max = -1001;
    for(int i = 0; i<n; i++)
        for(int j = i; j<n; j++)
        {
            int sum = 0;
            for(int k = i; k<=j; k++) sum += data[k];
            ArrayList<Integer> nums = new ArrayList<Integer>(), other = new ArrayList<Integer>();
            for(int k = 0; k<n; k++)
            {
                if(k >= i && k <= j)
                {
                    nums.add(data[k]);
                }
                else other.add(data[k]);
            }
            Collections.sort(nums); Collections.sort(other);
            for(int k = 0; k<swaps; k++)
            {
                if(k < nums.size() && k < other.size())
                {
                    sum += Math.max(0, other.get(other.size()-k-1)-nums.get(k));
                }
            }
            max = Math.max(max, sum);
        }
    out.println(max);
    out.close();
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