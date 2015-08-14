import java.util.*;
import java.io.*;
public class d2 {
	//Fast Scanner
	//throw IOException
	//Reader.init(System.in);
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
public static void main(String[] args) throws IOException
{
	Reader.init(System.in);
	//Scanner input = new Scanner(System.in);
	String s = Reader.next(), t = Reader.next();
	int at = t.length()-1;
	ArrayList<TreeSet<Integer>> ts = new ArrayList<TreeSet<Integer>>();
	for(int i = 0; i<26; i++)
		ts.add(new TreeSet<Integer>());
	for(int i = 0; i<t.length(); i++)
	{
		ts.get(t.charAt(i)-'a').add(i);
	}
	int[] data = new int[s.length()];
	for(int i = s.length()-1; i>=0; i--)
	{
		int init =(i == s.length()-1)? 0 : data[i+1];
		data[i] = init;
		if(i<s.length()-1&&s.charAt(i+1) == t.charAt(at))
		{
			if(at>0)
			{
			at--;
			data[i]++;
			}
			
		}
	}
	int[] data2 = new int[s.length()];
	at = 0;
	for(int i = 0; i<s.length(); i++)
	{
		int init =(i == 0)? 0 : data2[i-1];
		data2[i] = init;
		if(i>0&&s.charAt(i-1) == t.charAt(at))
		{
			if(at<t.length()-1)
			{
			at++;
			data2[i]++;
			}
		}
	}
//	for(int i= 0; i<data.length; i++)
//		System.out.println(data2[i] + " " + data[i]);

	boolean good = true;
	if(t.length()==1)
	{
		for(int i = 0; i<s.length(); i++)
			if(s.charAt(i) != t.charAt(0))
			{
				good = false;
				break;
			}
	}
	else
	for(int i = 0; i<s.length(); i++)
	{
		if(data[i] + data2[i]+1 < t.length())
		{
			good = false;
			break;
		}
		else
		{
			char c = s.charAt(i);
			//System.out.println(i + " "+c);
//			if(c == t.charAt(data2[i]-1) || c == t.charAt(t.length()-data[i]))
//				continue;
			int maxallowed = data2[i], minallowed = t.length()-data[i]-1;
			//System.out.println(minallowed+" "+maxallowed);
//			for(int j:ts.get(c-'a') )
//				System.out.println(j);
			if(ts.get(c-'a').floor(maxallowed)!=null&&ts.get(c-'a').floor(maxallowed)>=minallowed)
				continue;
			else
			{
				good = false;
				break;
			}
		}
		
	}
	System.out.println(good ? "Yes" : "No");
}
}