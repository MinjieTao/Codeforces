import java.util.*;
import java.io.*;
public class b {
    static long mod = 1000000009;
    public static void main(String[] args) throws IOException {
        // Scanner input = new Scanner(new File("input.txt"));
        // PrintWriter out = new PrintWriter(new File("output.txt"));
        input.init(System.in);
        PrintWriter out = new PrintWriter((System.out));
        
        int n = input.nextInt();
        Point[] data = new Point[n];
        for(int i = 0; i<n; i++) data[i] = new Point(input.nextInt(), input.nextInt());
        Point[] hull = findHull(data);
        if(hull.length == 3)
        {
            double res = 0;
            for(int i = 0; i<n; i++)
                for(int j = i+1; j<n; j++)
                {
                    Segment seg = new Segment(data[i], data[j]);
                    Point p = seg.diff();
                    double baseh = seg.diff().mag()/2;
                    double max1 = 0, max2 = 0;
                    for(int k = 0; k<n; k++)
                    {
                        if(k==i || k == j) continue;
                        if(p.cross(data[k].minus(data[i])) < 0) max1 = Math.max(max1, seg.dist(data[k]));
                        else max2 = Math.max(max2, seg.dist(data[k]));
                    }
                    //System.out.println(i+" "+j+" "+baseh+" "+max1+" "+max2);
                    if(max1 != 0 && max2!=0)
                    res = Math.max(baseh*max1 + baseh*max2, res);
                }
            out.println(res);
        }
        else
        {
            n = hull.length;
            double res = 0;
            for(int i = 0; i<n; i++)
                for(int j = i+1; j<n; j++)
                {
                    Segment seg = new Segment(hull[i], hull[j]);
                    double baseh = seg.diff().mag()/2;
                    double max1 = 0, max2 = 0;
                    for(int k = (i+1); k<j; k++)
                    {
                        max1 = Math.max(max1, seg.dist(hull[k]));
                    }
                    for(int k = (j+1); k<n; k++)
                    {
                        //if(i==0 && j == 2) out.println(hull[k].x+" "+data[k].y);
                        max2 = Math.max(max2, seg.dist(hull[k]));
                    }
                    for(int k = 0; k<i; k++)
                    {
                        max2 = Math.max(max2, seg.dist(hull[k]));
                    }
                    //if(i==0 && j == 2) out.println(baseh+" "+max1+" "+max2);
                    res = Math.max(baseh*max1 + baseh*max2, res);
                }
            out.println(res);
        }
        
        out.close();
    }
    static long pow(long x, long p) {
        if (p == 0)
            return 1;
        if ((p & 1) > 0) {
            return (x * pow(x, p - 1)) % mod;
        }
        long sqrt = pow(x, p / 2);
        return (sqrt * sqrt) % mod;
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static class input {
        static BufferedReader reader;
        static StringTokenizer tokenizer;

        /** call this method to initialize reader for InputStream */
        static void init(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        /** get next word */
        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                // TODO add check for eof if necessary
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        static long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        static String nextLine() throws IOException {
            return reader.readLine();
        }
    }
    public static Point[] findHull( Point[] points)
    {
        int n = points.length;
        Arrays.sort( points); //sort by y increasing, then x increasing
        Point[] ans = new Point[2 * n];             // In between we may have a 2n points
        int k = 0, start = 0;                   // start is the first insertion point 
        for(int i = 0; i < n; i ++)                     // Finding lower layer of hull
        {
            Point p = points[i];
            while( k - start >= 2 && p.minus( ans[k-1] ).cross(p.minus( ans[k-2] ) ) >= 0 )
                k--;
            ans[k++] = p; 
        }                       // drop off last point from lower layer
        start = --k ;                       
        for(int i = n-1 ; i >= 0 ; i --)                // Finding top layer from hull
        {
            Point p = points[i];
            while( k - start >= 2 && p.minus( ans[k-1] ).cross(p.minus( ans[k-2] ) ) >= 0 )
                k--;
            ans[k++] = p; 
        }
        --k;
        Point[] res = new Point[k];
        for(int i = 0; i<k; i++)
        res[i] = ans[i];
        return res;                  // convex hull is of size k
    }
    //points in p must be sorted in clockwise or counterclockwise order
    public static double area(Point[] p)
    {
        double res = 0;
        int n = p.length;
        for(int i = 0; i<n; i++)
        {
            res+= p[i].cross(p[(i+1)%n]);
        }
        return Math.abs(res/2);
    }
    public static class Segment
    {
        Point start, end;
        public Segment(Point a, Point b)
        {
            start = a; end = b;
        }
        //returns vector representation
        public Point diff()
        {
            return end.minus(start);
        }
        public boolean isFlat()
        {
            return start.y == end.y;
        }
        //shifts by dy in the direction perpendicular to the segment
        public Segment raise(double dy)
        {
            Point delta = diff().normal().mult(dy);
            return new Segment(start.plus(delta), end.plus(delta));
        }
        //returns endpoint when the segment is projected over vector from start and p
        public Point proj(Point p)
        {
            Point at = diff();
            double k = at.dot(p.minus(start))/at.magSquared();
            return at.mult(k).plus(start);
        }
        //returns shortest distance from line to p
        public double dist(Point p)
        {
            Point at = diff();
            double t = at.dot(p.minus(start))/at.magSquared();
            return p.dist(at.mult(t).plus(start));
        }
        public double eval(double x)
        {
            double slope = (end.y-start.y)/(end.x-start.x);
            return start.y + (x - start.x)*slope;
        }
    }
    public static class Point implements Comparable<Point>
    {
        double x, y; //x and y represent the coordinates of a point or the components of a vector
        public Point(double myx, double myy)
        {
            x = myx; y = myy;
        }
        //returns this + that
        public Point plus(Point p)
        {
            return new Point(this.x+p.x, this.y+p.y);
        }
        //returns this - that
        public Point minus(Point p)
        {
            return new Point(this.x-p.x,this.y-p.y);
        }
        //scales vector by multiple of d
        public Point mult(double d)
        {
            return new Point(this.x*d, this.y*d);
        }
        //returns this (dot) that
        public double dot(Point p)
        {
            return this.x*p.x + this.y*p.y;
        }
        //returns this x that
        public double cross(Point p)
        {
            return this.x*p.y - this.y*p.x;
        }
        //returns magnitude squared of vector
        public double magSquared()
        {
            return this.x*this.x + this.y*this.y;
        }
        //returns magnitude of vector
        public double mag()
        {
            return Math.sqrt(magSquared());
        }
        //returns a vector normal to this one
        public Point normal()
        {
            return new Point(this.y/mag(), -1*this.x/mag());
        }
        //rotates vector clockwise by angle theta
        public Point rotate(double theta)
        {
            double nx = x*Math.cos(theta) - y*Math.sin(theta);
            double ny = x*Math.sin(theta) + y*Math.cos(theta);
            return new Point(nx, ny);
        }
        //returns unit vector
        public Point normalize()
        {
            double d = mag();
            return new Point(x/d, y/d);
        }
        public double dist(Point p)
        {
            return this.minus(p).mag();
        }
        @Override
        public int compareTo(Point o) {
            // TODO Auto-generated method stub
            if(this.y == o.y)
                return (int)Math.signum(this.x - o.x);
            return (int)Math.signum(this.y - o.y);
        }
    }
}