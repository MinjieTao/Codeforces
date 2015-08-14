import java.util.*;
import java.io.*;
public class d {
public static void main(String[] args) throws IOException
{
    InputReader input = new InputReader(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    int[] d = new int[n];
    int[] sum = new int[n];
    for(int i = 0; i<n; i++) sum[i] = d[i] = input.nextInt();
    for(int i= 1; i<n; i++) sum[i] += sum[i-1];
    Point[] data = new Point[n];
    for(int i = 0; i<n; i++) data[i] = new Point(i, sum[i]);
    long res = 2000000000;
    for(int i = 0; i<n; i++)
    {
        for(int j = i+1; j<n && j<i+1005; j++)
        {
            long dist = (data[i].dist(data[j]));
            if(dist < res) res = dist;
        }
    }
    //Arrays.sort(data);
//  int[] xByx = new int[n], yByx = new int[n], xByy = new int[n], yByy = new int[n];
//  for(int i = 0; i<n; i++)
//  {
//      int x = data[i].x, y = data[i].y;
//      xByx[i] = x;
//      yByx[i] = y;
//      xByy[i] = x;
//      yByy[i] = y;
//  }
//  long res = closest(xByx, yByx, xByy, yByy, new int[n], new int[n], 0, n-1);
    out.println(res);
    out.close();
}
static long closest(int[] xByx, int[] yByx, int[] xByy, int[] yByy, int[] xs, int[] ys, int lo, int hi) {
    if (hi <= lo) return Long.MAX_VALUE;

    int mid = lo + (hi - lo) / 2;
    int medianx = xByx[mid];
    // compute closest pair with both endpoints in left subarray or both in right subarray
    long delta1 = closest(xByx, yByx, xByy, yByy, xs, ys, lo, mid);
    long delta2 = closest(xByx, yByx, xByy, yByy, xs, ys, mid+1, hi);
    long delta = Math.min(delta1, delta2);

    // merge back so that pointsByY[lo..hi] are sorted by y-coordinate
    merge(xByy, yByy, xs, ys, lo, mid, hi);

    // aux[0..M-1] = sequence of points closer than delta, sorted by y-coordinate
    int M = 0;
    for (int i = lo; i <= hi; i++) {
        if ((xByy[i] - medianx)*(xByy[i] - medianx) < delta)
        {
            ys[M] = yByy[i];
            xs[M++] = xByy[i];
        }
    }

    // compare each point to its neighbors with y-coordinate closer than delta
    for (int i = 0; i < M; i++) {
        // a geometric packing argument shows that this loop iterates at most 7 times
        for (int j = i+1; (j < M) && (ys[j] - ys[i] < delta); j++) {
            long distance = ((long)xs[i]-xs[j])*(xs[i]-xs[j]) + ((long)ys[i]-ys[j])*(ys[i]-ys[j]);
            if (distance < delta) {
                delta = distance;
            }
        }
    }
    return delta;
}
private static void merge(int[] ax, int[] ay, int[] xs, int[] ys, int lo, int mid, int hi) {
    // copy to aux[]
    for (int k = lo; k <= hi; k++) {
        xs[k] = ax[k];
        ys[k] = ay[k];
    }
    // merge back to a[] 
    int i = lo, j = mid+1;
    for (int k = lo; k <= hi; k++) {
        if      (i > mid)
        {
            ax[k] = xs[j];
            ay[k] = ys[j];
            j++;
        }
        else if (j > hi)
        {
            ax[k] = xs[i];
            ay[k] = ys[i];
            i++;
        }
        else if (ys[j] < ys[i])
        {
            ax[k] = xs[j];
            ay[k] = ys[j];
            j++;
        }
        else
        {
            ax[k] = xs[i];
            ay[k] = ys[i];
            i++;
        }
    }
}
static long bestDistance;
static class Point implements Comparable<Point>
{
    int x, y;
    public Point(int xx, int yy)
    {
        x = xx; y = yy;
    }
    long dist(Point p)
    {
        return ((long)x - p.x)*(x - p.x)+ ((long)y-p.y)*(y - p.y); 
    }
    @Override
    public int compareTo(Point p) {
        // TODO Auto-generated method stub
        return x - p.x;
    }
}
static class InputReader {

    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int nextInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return isWhitespace(c);
    }

    public static boolean isWhitespace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}
//public static class input {
//    static BufferedReader reader;
//    static StringTokenizer tokenizer;
//
//    /** call this method to initialize reader for InputStream */
//    static void init(InputStream input) {
//        reader = new BufferedReader(
//                     new InputStreamReader(input) );
//        tokenizer = new StringTokenizer("");
//    }
//
//    /** get next word */
//    static String next() throws IOException {
//        while ( ! tokenizer.hasMoreTokens() ) {
//            //TODO add check for eof if necessary
//            tokenizer = new StringTokenizer(
//                   reader.readLine() );
//        }
//        return tokenizer.nextToken();
//    }
//
//    static int nextInt() throws IOException {
//        return Integer.parseInt( next() );
//    }
//  
//    static double nextDouble() throws IOException {
//        return Double.parseDouble( next() );
//    }
//    static long nextLong() throws IOException {
//        return Long.parseLong( next() );
//    }
//}
}