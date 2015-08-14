import java.util.*;
import java.io.*;
public class c {
    static int k;
    static ArrayList<Integer>[] div;
    static long[] counts;
    static long[] ties;
    static int[] log;
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = input.nextInt();
    long[] poss = new long[n+1];
    for(int i = 0; i<= n; i++)
    {
        poss[i] = (1l<<(n-i)) * (1l<<(i-1)) * (1l<<(i-1));
    }
    int[] a = new int[1<<n];
    for(int i = 0; i<a.length; i++) a[i] = input.nextInt();
    log = new int[(1<<n)+1];
    for(int i = 0; i<=n; i++) log[1<<i] = i;
    counts = new long[n+1];
    ties = new long[n+1];
    invCount(a);
    //System.out.println(Arrays.toString(a));
    //out.println(Arrays.toString(counts));
    //out.println(Arrays.toString(ties));
    //out.println(Arrays.toString(poss));
    int m = input.nextInt();
    for(int i = 0; i<=n; i++) poss[i] -= ties[i];
    for(int i = 0; i<m; i++)
    {
        int x = input.nextInt();
        for(int k = 0; k<=x; k++)
        {
            counts[k] = poss[k] - counts[k];
        }
        long res = 0;
        for(int k = 0; k<=n; k++) res += counts[k];
        out.println(res);
    }
    
    
    out.close();
}
static long[] merge(int[] arr, int[] left, int[] right) {
    int i = 0, j = 0;
    long count = 0;
    long ties = 0;
    while (i < left.length || j < right.length) {
        if (i == left.length) {
            arr[i+j] = right[j];
            j++;
        } else if (j == right.length) {
            arr[i+j] = left[i];
            i++;
        } 
        else if(left[i] == right[j])
        {
            long old1 = i, old2 = j;
            int cur = left[i];
            while(i < left.length && left[i] == cur)
            {
                arr[i+j] = left[i];
                i++;
            }
            while(j < right.length && right[j] == cur)
            {
                arr[i+j] = right[j];
                j++;
            }
            ties += (long)(i-old1) * (j-old2);
            j--;
        }
        else if (left[i] < right[j]) {
            arr[i+j] = left[i];
            i++;                
        } else {
            arr[i+j] = right[j];
            count += left.length-i;
            j++;
        }
    }
    //System.out.println(ties);
    return new long[]{count, ties};
}

static long invCount(int[] arr) {
    if (arr.length < 2)
        return 0;

    int m = (arr.length + 1) / 2;
    int left[] = Arrays.copyOfRange(arr, 0, m);
    int right[] = Arrays.copyOfRange(arr, m, arr.length);
    long res = invCount(left) + invCount(right);
    long[] merge = merge(arr, left, right);
    res += merge[0];
    counts[log[arr.length]] += merge[0];
    ties[log[arr.length]] += merge[1];
    return res;
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