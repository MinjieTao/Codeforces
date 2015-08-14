import java.util.*;
import java.io.*;
public class d {
public static void main(String[] args) throws Exception
{
    JoltyScanner input = new JoltyScanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), m = input.nextInt();
    sets = new HashMap[m];
    HashSet<Integer>[] colors = new HashSet[n];
    ArrayList<Integer>[] colorList = new ArrayList[n];
    for(int i = 0; i<n; i++)
    {
        colors[i] = new HashSet<Integer>();
        colorList[i] = new ArrayList<Integer>();
    }
    for(int i = 0; i<m; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1, c = input.nextInt()-1;
        if(sets[c] == null) sets[c] = new HashMap<Integer, Integer>();
        union(c, a, b);
        if(!colors[a].contains(c)) colorList[a].add(c);
        if(!colors[b].contains(c)) colorList[b].add(c);
        colors[a].add(c);
        colors[b].add(c);
    }
    int[] deg = new int[n];
    for(int i = 0; i<n; i++) deg[i] = colors[i].size();
    int qs = input.nextInt();
    HashMap<Long, Integer> res = new HashMap<Long, Integer>();
    for(int q = 0; q<qs; q++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1;
        if(deg[a] > deg[b] || deg[a] == deg[b] && a > b)
        {
            int temp = a; a = b; b = temp;
        }
        long key = (long)n*a + b;
        if(res.containsKey(key))
        {
            out.println(res.get(key));
            continue;
        }
        int cur = 0;
        for(int x : colorList[a])
        {
            if(find(x, a) == find(x, b)) cur++;
        }
        res.put(key, cur);
        out.println(cur);
    }
    
    out.close();
}
    static HashMap<Integer, Integer>[] sets; //negative if root, more negative means bigger set; if nonnegative, then it indicates the parent 
//  public DisjointSet()
//  {
//      map = new HashMap<Integer, Integer>();
//  }
    static int find(int i, int x)
    {
        int cur = sets[i].containsKey(x) ? sets[i].get(x) : -1;
        if(cur < 0)
            return x;
        else
        {
            int next = find(i, cur);
            sets[i].put(x, next);
            return next;
        }
    }
    static void union(int i, int a, int b)
    {
        int roota = find(i, a), rootb = find(i, b);
        if(roota == rootb)
            return;
        int mra = sets[i].containsKey(roota) ? sets[i].get(roota) : -1;
        int mrb = sets[i].containsKey(rootb) ? sets[i].get(rootb) : -1;
        if(mra < mrb)
        {
            sets[i].put(roota, mra + mrb); //add the sizes
            sets[i].put(rootb, roota); //connect the smaller to the bigger
        }
        else
        {
            sets[i].put(rootb, mra + mrb); //add the sizes
            sets[i].put(roota, rootb); //connect the smaller to the bigger
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