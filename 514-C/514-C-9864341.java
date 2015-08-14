import java.util.*;
import java.io.*;
public class c {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    HashSet<Long> hashes = new HashSet<Long>();
    int n = input.nextInt(), m = input.nextInt();
    for(int i = 0; i<n; i++)
    {
        int[] nums = makeNums(input.next());
        PrefixHash ph = new PrefixHash(nums, 3);
        //System.out.println(Arrays.toString(nums));
        for(int j = 0; j<nums.length; j++)
        {
            //System.out.println(nums[j]);
            for(int k = 1; k<=2; k++)
            {
                //System.out.println(ph.hash(0, nums.length - 1));
                //System.out.println(Arrays.toString(ph.update(j, (nums[j] + k)%3)));
                long[] cur = ph.update(j, (nums[j] + k)%3);
                hashes.add(cur[0] * (long)2e9 + cur[1]);
            }
        }
    }
    for(int i = 0; i<m; i++)
    {
        int[] nums = makeNums(input.next());
        PrefixHash ph = new PrefixHash(nums, 3);
        //System.out.println("Search: " + Arrays.toString(ph.hash(0, nums.length - 1)));
        long[] cur = ph.hash(0, nums.length - 1);
        out.println(hashes.contains(cur[0] * (long)2e9 + cur[1]) ? "YES" : "NO");
    }
    out.close();
}
static int[] makeNums(String s)
{
    int n = s.length();
    int[] res = new int[n];
    for(int i = 0; i<n; i++) res[i] = s.charAt(i) - 'a';
    return res;
}
static long pow(long x, long p, long mod)
{
    if(p == 0) return 1;
    if(p%2 == 0)
    {
        long sqrt = pow(x, p/2, mod);
        return (sqrt * sqrt)%mod;
    }
    return (x * pow(x, p-1, mod))%mod;
}
static class PrefixHash
{
    static int modCount = 2;
    long[] mods = new long[]{982451653, 1000000007, 1000000009};
    long[][] hash;
    long[][] pows;
    long[][] invpows;
    int[] s;
    int n;
    public PrefixHash(int[] s, int alpha)
    {
        n = s.length;
        this.s = new int[n];
        for(int i = 0; i<n; i++) this.s[i] = s[i];
        alpha++;
        hash = new long[modCount][n];
        for(int i = 0; i<n; i++)
            for(int j = 0; j<modCount; j++)
                hash[j][i] = ((i == 0 ? 0 : hash[j][i-1]) * alpha + (s[i] + 1))%mods[j];
        pows = new long[modCount][n];
        invpows = new long[modCount][n];
        for(int j = 0; j<modCount; j++)
        {
            long inv = pow(alpha, mods[j] - 2, mods[j]);
            pows[j][0] = invpows[j][0] = 1;
            for(int i = 1; i<n; i++)
            {
                pows[j][i] = (pows[j][i-1] * alpha) % mods[j];
                invpows[j][i] = (pows[j][i-1] * inv)%mods[j];
            }
        }
    }
    /*
     * Returns the hash codes of the substring (from, to)
     */
    long[] hash(int from, int to)
    {
        long[] res = new long[modCount];
        for(int j = 0; j<modCount; j++)
        {
            res[j] = hash[j][to];
            if(from > 0) res[j] = ((res[j] - hash[j][from-1] * pows[j][to - from + 1])%mods[j] + mods[j])%mods[j];
        }
        return res;
    }
    /*
     * Returns a hash of the whole string with character i replaced with c
     */
    long[] update(int i, int c)
    {
        //System.out.println(i+" "+c+" "+s[i]);
        long[] res = new long[3];
        for(int j = 0; j<modCount; j++)
        {
            res[j] = ((hash[j][n-1] +  (c - s[i]) * pows[j][n - 1 - i])%mods[j] + mods[j])%mods[j];
        }
        return res;
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