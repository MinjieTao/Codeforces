import java.util.*;
import java.io.*;
public class a {
    static long res = 0;
    static int besti = 0, bestj = 0;
public static void main(String[] args) throws IOException
{
    long start = System.currentTimeMillis();
    JoltyScanner input = new JoltyScanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), m = input.nextInt();
    //int n = 200000, m = 200000;
    //Random r = new Random();
    int[] ls = new int[n], rs = new int[n];
    for(int i = 0; i<n; i++)
    {
        ls[i] = input.nextInt();
        //ls[i] = r.nextInt(500000000);
        //rs[i] = 500000000 + r.nextInt(500000000);
        rs[i] = input.nextInt();
    }
    int[] as = new int[m], bs = new int[m], cs = new int[m];
    for(int i = 0; i<m; i++)
    {
        as[i] = input.nextInt();
        bs[i] = input.nextInt();
        cs[i] = input.nextInt();
        //as[i] = r.nextInt(500000000);
        //bs[i] = 500000000 + r.nextInt(500000000);
        //cs[i] = 1000000000;
    }
    go(n, m, ls, rs, as, bs, cs, true);
    int oo = 1000000000;
    for(int i = 0; i<n; i++)
    {
        int temp = oo - ls[i];
        ls[i] = oo - rs[i];
        rs[i] = temp;
    }
    for(int i = 0; i<m; i++)
    {
        int temp = oo - as[i];
        as[i] = oo - bs[i];
        bs[i] = temp;
    }
    go(n, m, ls, rs, as, bs, cs, false);
    out.println(res);
    long overlap = res / cs[bestj];
    for(int i = 0; i<n; i++)
    {
        long a = as[bestj], b = bs[bestj];
        a = Math.max(a, ls[i]);
        b = Math.min(b, rs[i]);
        if(b - a == overlap)
        {
            besti = i;
            break;
        }
    }
    if(res > 0)
    {
        out.println((besti+1)+" "+(bestj+1));
    }
    long end = System.currentTimeMillis();
    //out.println(end - start);
    out.close();
}
static void go(int n, int m, int[] ls, int[] rs, int[] as, int[] bs, int[] cs, boolean flag)
{
    //System.out.println(Arrays.toString(ls)+" "+Arrays.toString(rs));
    //System.out.println(Arrays.toString(as)+" "+Arrays.toString(bs));
    TreeMap<Integer, Integer> starts = new TreeMap<Integer, Integer>();
    TreeMap<Integer, Integer> complete = new TreeMap<Integer, Integer>();
    Event[] pq = new Event[2*n+m];
    for(int i = 0; i<n; i++)
    {
        pq[2*i] = (new Event(ls[i], 1, ls[i], i));
        pq[2*i+1] = (new Event(rs[i], -1, ls[i], i));
    }
    for(int i = 0; i<m; i++) pq[2*n+i] = (new Event(bs[i], 0, as[i], i));
    Arrays.sort(pq);
    int ptr = 0;
    while(ptr < pq.length)
    {
        Event e = pq[ptr++];
        if(e.type == 1)
        {
            inc(starts, e.start);
        }
        else if(e.type == -1)
        {
            dec(starts, e.start);
            if(flag)
            {
                complete.put( e.start, e.time - e.start);
                while(complete.lowerKey( e.start) != null && complete.get(complete.lowerKey(e.start)) <= e.time - e.start)
                {
                    complete.remove(complete.lowerKey(e.start));
                }
            }
        }
        else
        {
            Integer key = null;
            if(flag && !complete.isEmpty())
            {
                key = complete.ceilingKey(e.start);
                //System.out.println(key);
                if(key != null)
                {
                    if((long)cs[e.index] * complete.get(key) > res)
                    {
                        res = (long) cs[e.index] * complete.get(key);
                        bestj = e.index;
                    }
                }
            }
            if(starts.isEmpty()) continue;
            key = starts.firstKey();
            if(key == null) continue;
            if(key < e.start) key = e.start; 
            if((long)cs[e.index] * (e.time - key) > res)
            {
                res = (long)cs[e.index] * (e.time - key);
                bestj = e.index;
            }
        }
    }
}
static void inc(TreeMap<Integer, Integer> map, int x)
{
    map.put(x, map.containsKey(x) ? map.get(x)+1 : 1);
}
static void dec(TreeMap<Integer, Integer> map, int x)
{
    if(map.get(x) == 1) map.remove(x);
    else map.put(x, map.get(x) - 1);
}
static class Event implements Comparable<Event>
{
    int time, type, start;
    int index;
    Event(int tt, int ty, int ss, int ii)
    {
        time = tt; type = ty; start = ss; index = ii;
    }
    @Override
    public int compareTo(Event o) {
        // TODO Auto-generated method stub
        return (time - o.time);
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
public static class JoltyScanner {
    // LOOK AT THAT SPEED. THAT SPEED.
    public static final int BASE_SPEED = 130;
    public static final int BUFFER_SIZE = 1 << 16;
    public static final char NULL_CHAR = (char) -1;

    BufferedInputStream in;
    StringBuilder str = new StringBuilder();
    byte[] buffer = new byte[BUFFER_SIZE];
    boolean EOF_FLAG = false;

    char c = NULL_CHAR;
    int bufferIdx = 0;
    int size = 0;

    public JoltyScanner(InputStream in) {
        this.in = new BufferedInputStream(in, BUFFER_SIZE);
    }

    public int nextInt() {
        long x = nextLong();
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
            throw new ArithmeticException("Scanned value overflows integer");
        }
        return (int) x;
    }

    public long nextLong() {
        boolean negative = false;
        if (c == NULL_CHAR) {
            c = nextChar();
        }
        for (; !EOF_FLAG && (c < '0' || c > '9'); c = nextChar()) {
            if (c == '-') {
                negative = true;
            }               
        }
        checkEOF();
        long res = 0;
        for (; c >= '0' && c <= '9'; c = nextChar()) {
            res = (res << 3) + (res << 1) + c - '0';
        }
        return negative ? -res : res;
    }

    public String nextLine() {
        checkEOF();
        str.setLength(0);
        for (c = c == NULL_CHAR ? nextChar() : c; !EOF_FLAG && c != '\n'; c = nextChar()) {
            str.append(c);
        }
        c = NULL_CHAR;
        return str.toString();
    }

    public String next() {
        checkEOF();
        for (c = c == NULL_CHAR ? nextChar() : c; Character.isWhitespace(c); checkEOF()) {
            c = nextChar();
        }
        str.setLength(0);
        for (; !EOF_FLAG && !Character.isWhitespace(c); c = nextChar()) {
            str.append(c);
        }
        return str.toString();
    }

    public String nextOrNull() {
        try {
            return next();
        } catch (EndOfFileException e) {
            return null;
        }
    }

    public char peekChar() {
        if (c == NULL_CHAR) {
            c = nextChar();
        }
        return c;
    }

    public char nextChar() {
        if (EOF_FLAG) {
            return NULL_CHAR;
        }
        while (bufferIdx == size) {
            try {
                size = in.read(buffer);
                if (size == -1) {
                    throw new Exception();
                }
            } catch (Exception e) {
                EOF_FLAG = true;
                return NULL_CHAR;
            }
            if (size == -1) {
                size = BUFFER_SIZE;
            }
            bufferIdx = 0;
        }
        return (char) buffer[bufferIdx++];
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }
    
    public void checkEOF() {
        if (EOF_FLAG) {
            throw new EndOfFileException();
        }
    }

    @SuppressWarnings("serial")
    public class EndOfFileException extends RuntimeException {
    }
}
}