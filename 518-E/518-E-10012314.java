import java.util.*;
import java.io.*;
public class e {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), k = input.nextInt();
    int[] data = new int[n];
    boolean[] qu = new boolean[n];
    for(int i = 0; i<n; i++)
    {
        String s = input.next();
        if(s.equals("?")) qu[i] = true;
        else data[i] = Integer.parseInt(s);
    }
    boolean valid = true;
    for(int i = 0; i<k; i++)
    {
        ArrayList<Integer> vals = new ArrayList<Integer>();
        int gap = 0;
        int j = 0;
        for(j = i; j<n; j+=k)
        {
            if(!qu[j])
            {
                vals.add(data[j]);
                if(!valid) break;
                if(vals.size() > 1)
                {
                    valid &= data[j] > vals.get(vals.size()-2) + gap;
                    TreeSet<Integer> set = minSum(vals.get(vals.size()-2), vals.get(vals.size()-1), gap);
                    if(set == null)
                    {
                        valid = false;
                        break;
                    }
                    int start = j - k * gap;
                    for(int x : set)
                    {
                        data[start] = x;
                        start += k;
                    }
                }
                else
                {
                    TreeSet<Integer> set = minSum(-2000000000, vals.get(vals.size()-1), gap);
                    if(set == null)
                    {
                        valid = false;
                        break;
                    }
                    int start = j - k * gap;
                    for(int x : set)
                    {
                        data[start] = x;
                        start += k;
                    }
                }
                gap = 0;
            }
            else gap++;
        }
        if(gap > 0)
        {
            //System.out.println(i+" "+j+" "+gap);
            int last = j - gap * k - k;
            TreeSet<Integer> set = minSum(last < 0 ? -2000000000 : data[last], 2000000000, gap);
            if(set == null)
            {
                valid = false;
                break;
            }
            for(int x :set)
            {
                last += k;
                data[last] = x;
            }
        }
    }
    if(valid)
    {
        for(int x : data) out.print(x+" ");
    }
    else
    {
        out.println("Incorrect sequence");
    }
    out.close();
}
static TreeSet<Integer> minSum(int a, int b, int gap)
{
    //System.out.println(a+" "+b);
    int left = a+1, right = b-1;
    if(left < 0 && right > 0)
    {
        left = 1;
        right = 0;
    }
    TreeSet<Integer> set = new TreeSet<Integer>();
    for(int i = 0; i<gap; i++)
    {
        if(Math.abs(left) < Math.abs(right) && left < b)
        {
            set.add(left);
            left++;
        }
        else if(right > a)
        {
            set.add(right);
            right--;
        }
        else if(left < b)
        {
            set.add(left);
            left++;
        }
        else return null;
    }
    if(set.size() < gap) return null;
    return set;
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