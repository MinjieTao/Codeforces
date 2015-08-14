import java.util.*;
import java.io.*;
public class b2 {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++)
        data[i] = input.nextInt();
    TreeSet<Integer> nums = new TreeSet<Integer>();
    for(int d: data) nums.add(d);
    int[] compress = new int[1000001];
    int index = 0;
    for(int x: nums)
    {
        compress[x] = index++;
    }
    if((long)nums.size()*nums.size()*n <= 100000000)
    {
        ArrayList<Integer> nums2 = new ArrayList<Integer>();
        for(int d: nums) nums2.add(d);
        int max = 0;
        for(int i = 0;i<nums.size(); i++)
            for(int j = 0; j<nums.size(); j++)
            {
                int x = nums2.get(i), y = nums2.get(j);
                int count = 0;
                for(int k = 0; k<n; k++)
                {
                    if((count&1) == 1 && data[k] == y) count++;
                    else if((count&1) == 0 && data[k] == x) count++;
                }
                max = Math.max(max, count);
            }
        System.out.println(max);
    }
    else
    {
    TreeSet<Integer>[] indices = new TreeSet[nums.size()];
    for(int i = 0; i<nums.size(); i++)
        indices[i] = new TreeSet<Integer>();
    for(int i = 0; i<n; i++)
        indices[compress[data[i]]].add(i);
    int[][] dp = new int[n+1][n+1];
    dp[0][0] = 1;
    for(int i = 0; i<n; i++)
        for(int j = 0; j<i; j++)
        {
//          int lo = 0, hi = indices[data[i]].size();
//          while(hi>lo+1)
//          {
//              int mid = (hi+lo)/2;
//              if(indices[data[i]].get(mid) >= j) hi = mid;
//              else lo = mid;
//          }
            //System.out.println(i+" " +j);
            //for(int k: indices[data[i]]) System.out.println(k);
            int lo = -1;
            if(indices[compress[data[i]]].size() > 0)
            {
                if(indices[compress[data[i]]].lower(j) != null)
                lo = indices[compress[data[i]]].lower(j);
            }
            //System.out.println(i + " " + j + " " + lo);
            //System.out.println(i + " " + j + " " + lo);
            //if(indices[data[i]].get(lo) >= j) lo--;
            if(lo < 0) dp[i][j] = 2;
            else dp[i][j] = 1+dp[j][lo];
        }
    int max = 1;
    for(int i= 0; i<n; i++)
        for(int j = 0; j<i; j++)
        {

            max = Math.max(max, dp[i][j]);
        }
    System.out.println(max);
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
}
}