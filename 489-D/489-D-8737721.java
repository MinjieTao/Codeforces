import java.util.*;
import java.io.*;
public class d {
public static void main(String[] args) throws Exception
{
    JoltyScanner input = new JoltyScanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    boolean[][] adj = new boolean[n][n];
    int[][] g = new int[n][n];
    int[] sizes = new int[n];
    for(int i = 0; i<m; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1;
        adj[a][b] = true;
        g[a][sizes[a]] = b;
        sizes[a]++;
    }
    long res = 0;
    for(int i = 0; i<n; i++)
        for(int j = 0; j<n; j++)
        {
            if(i == j) continue;
            int c = 0;
            for(int k = 0; k<sizes[i]; k++)
            {
                int e = g[i][k];
                if(adj[e][j]) c++;
            }
            res += c*(c-1)/2;
        }
    System.out.println(res);
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