import java.util.*;
import java.io.*;
public class aa {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = input.nextInt();
    Group[] data = new Group[n];
    for(int i = 0; i<n; i++) data[i] = new Group(i+1, input.nextInt(), input.nextInt());
    Arrays.sort(data);
    int m = input.nextInt();
    Table[] tables = new Table[m];
    for(int i = 0; i<m; i++) tables[i] = new Table(i+1, input.nextInt());
    Arrays.sort(tables);
    boolean[] used = new boolean[m];
    int res = 0;
    int count = 0;
    int[] map = new int[n+1];
    Arrays.fill(map, -1);
    for(int i = 0; i<n; i++)
    {
        for(int j = 0; j<m; j++)
        {
            if(used[j]) continue;
            if(tables[j].s >= data[i].size)
            {
                map[data[i].i] = tables[j].i;
                count++;
                res += data[i].money;
                used[j] = true;
                break;
            }
        }
    }
    out.println(count+" "+res);
    for(int i = 0; i<=n; i++)
        if(map[i] != -1)
            out.println(i+" "+map[i]);
    out.close();
}
static class Group implements Comparable<Group>
{
    int size, money, i;
    public Group(int ii, int ss, int mm)
    {
        i = ii;
        size = ss; money = mm;
    }
    @Override
    public int compareTo(Group o) {
        // TODO Auto-generated method stub
        return o.money - money;
    }
}
static class Table implements Comparable<Table>
{
    int i, s;
    public Table(int ii, int ss)
    {
        i = ii; s = ss;
    }
    @Override
    public int compareTo(Table o) {
        // TODO Auto-generated method stub
        return s - o.s;
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