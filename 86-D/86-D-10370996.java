import java.util.*;
import java.io.*;
public class Yandex2011_2D {
public static void main(String[] args) throws IOException
{
	input.init(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int n = input.nextInt(), m = input.nextInt();
	sqrt = (int)Math.sqrt(n);
	int[] data = new int[n];
	for(int i = 0; i<n; i++) data[i] = input.nextInt();
	Query[] qs = new Query[m];
	for(int i = 0; i<m; i++) qs[i] = new Query(input.nextInt()-1, input.nextInt()-1, i);
	long[] output = new long[m];
	Arrays.sort(qs);
	fs = new long[1000001];
	res = 0;
	int left = 0, right = -1;
	for(int i = 0; i<m; i++)
	{
		int a = qs[i].a, b = qs[i].b;
		while(left < a)
		{
			remove(data[left]);
			left++;
		}
		while(left > a)
		{
			left--;
			add(data[left]);
		}
		while(right < b)
		{
			right++;
			add(data[right]);
		}
		while(right > b)
		{
			remove(data[right]);
			right--;
		}
		output[qs[i].i] = res;
	}
	for(long x : output) out.println(x);
	out.close();
}
static long[] fs;
static long res;
static int sqrt;
static void remove(int x)
{
	res -= x * (fs[x] + fs[x] - 1);
	fs[x]--;
}
static void add(int x)
{
	res += x * (fs[x] + fs[x] + 1);
	fs[x]++;
}
static class Query implements Comparable<Query>
{
	int a, b, block, i;
	public Query(int aa, int bb, int ii)
	{
		a = aa; b = bb; block = a / sqrt; i = ii;
	}
	@Override
	public int compareTo(Query o) {
		// TODO Auto-generated method stub
		if(block != o.block) return block - o.block;
		return b - o.b;
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