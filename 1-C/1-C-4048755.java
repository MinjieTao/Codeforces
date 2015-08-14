import java.util.*;
import java.io.*;
public class a {
    static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out  = new PrintWriter((System.out));
  Point[] data = new Point[3];
  for(int i = 0; i<3; i++) data[i] = new Point(input.nextDouble(), input.nextDouble());
  Circle c = threePoints(data[0], data[1], data[2]);
  //out.println(c.r);
  Point center = c.cen();
  double[] as = new double[3];
  for(int i = 0; i<3; i++) as[i] = Math.atan2(data[i].y-center.y, data[i].x - center.x);
  for(int i = 3; i<=100; i++)
  {
      boolean good = true;
      for(int j = 0; j<3; j++)
          for(int k = j+1; k<3; k++)
          {
              good &= Math.abs(Math.sin(i*(as[j]-as[k])/2)) <1e-5; 
          }
      if(good)
      {
          out.println(.5*i*c.r*c.r*Math.sin(2*Math.PI/i));
          break;
      }
  }
  out.close();
  
}
public static Circle threePoints(Point a, Point b, Point c)
{
    Segment ab = new Segment(a, b);
    Segment bc = new Segment(b, c);
    Point mid1 = new Point(.5*a.x + .5*b.x, .5*a.y + .5*b.y);
    double dx1 = a.y - b.y;
    double dy1 = b.x - a.x;
    Point other1 = new Point(mid1.x + dx1, mid1.y + dy1);
    Segment first = new Segment(mid1, other1);
    Point mid2 = new Point(.5*c.x + .5*b.x, .5*c.y + .5*b.y);
    double dx2 = c.y - b.y;
    double dy2 = b.x - c.x;
    Point other2 = new Point(mid2.x + dx2, mid2.y + dy2);
    Segment second = new Segment(mid2, other2);
    Point center = lineIntersection(first, second);
    if(center==null)
        return null;
    double rad = Math.sqrt(dsquared(center, a));
    return new Circle(center.x, center.y, rad);
}
//distance formula
public static double dsquared(Point a, Point b)
{
    return (a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y);
}
public static Point segmentIntersection(Segment s1, Segment s2)
{
    Point p = lineIntersection(s1, s2);
    if(p==null)
    {
        //segments are parallel
        return null;
    }
    if(!(p.x >= Math.min(s1.start.x,s1.end.x)-1E-9 && p.x <= Math.max(s1.end.x,s1.start.x)+1E-9))
        return null;
    if(!(p.x >= Math.min(s2.start.x,s2.end.x)-1E-9 && p.x <= Math.max(s2.end.x,s2.start.x)+1E-9))
        return null;
    if(!(p.y >= Math.min(s1.start.y,s1.end.y)-1E-9 && p.y <= Math.max(s1.end.y,s1.start.y)+1E-9))
        return null;
    if(!(p.y >= Math.min(s2.start.y,s2.end.y)-1E-9 && p.y <= Math.max(s2.end.y,s2.start.y)+1E-9))
        return null;
    return p;
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
}
public static Point lineIntersection(Segment s1, Segment s2)
{
    double a1 = s1.end.y - s1.start.y;
    double b1 = s1.start.x - s1.end.x;
    double c1 = a1*s1.start.x + b1*s1.start.y;
    double a2 = s2.end.y - s2.start.y;
    double b2 = s2.start.x - s2.end.x;
    double c2 = a2*s2.start.x + b2*s2.start.y;
    double det = a1*b2 - a2*b1;
    if(det == 0)
    {
        //lines are parallel
        return null;
    }
    double x = (b2*c1 - b1*c2)/det;
    double y = (a1*c2 - a2*c1)/det;
    if(x == -0) x=0;
    if(y == -0) y=0;
    return new Point(x, y);
}
public static class Point
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
}
public static class Circle
{
    double x, y, r;
    public Circle(double x, double y, double r)
    {
        this.x = x;
        this.y = y;
        this.r = r;
    }
    public Circle expand(double d)
    {
        return new Circle(x, y, r*d);
    }
    public Point[] intersect(Circle c)
    {
        Point diff = new Point(c.x-x, c.y-y);
        double dsq = diff.magSquared();
        double cos = (dsq+r*r-c.r*c.r)/(2*r*diff.mag());
        if(Math.abs(cos) > 1) return new Point[0];
        double theta = Math.acos(cos);
        if(Math.abs(theta) < 1e-9) return new Point[]{diff.normalize().mult(r).plus(new Point(x,y))};
        Point[] ret = new Point[2];
        ret[0] = diff.normalize().mult(r).rotate(theta).plus(new Point(x, y));
        ret[1] = diff.normalize().mult(r).rotate(-theta).plus(new Point(x, y));
        return ret;
    }
    public Point cen()
    {
        return new Point(x, y);
    }
    public boolean contains(Circle c)
    {
        Point p1 = new Point(x, y), p2 = new Point(c.x, c.y);
        double d = p2.minus(p1).mag()+c.r-1e-9;
        return r>d;
    }
}
static long pow(long base, long p)
{
    if(p==0) return 1;
    if((p&1) == 0)
    {
        long sqrt = pow(base, p/2);
        return (sqrt*sqrt)%mod;
    }
    return (base*pow(base, p-1))%mod;
}
static long modinv(long x)
{
    return pow(x, mod-2);
}
/*
Sum Interval Tree - uses O(n) space
Updates and queries over a range of values in log(n) time
*/
static class IT
{
    int[] left,right, a, b;
    long[] val;
    IT(int n)
    {
        left = new int[4*n];
        right = new int[4*n];
        val = new long[4*n];
        a = new int[4*n];
        b = new int[4*n];
        init(0,0, n);
    }
    int init(int at, int l, int r)
    {
        a[at] = l;
        b[at] = r;
        if(l==r)
            left[at] = right [at] = -1;
        else 
        {
            int mid = (l+r)/2;
            left[at] = init(2*at+1,l,mid);
            right[at] = init(2*at+2,mid+1,r);
        }
        return at++;
    }
    //return the sum over [x,y]
    long get(int x, int y)
    {
        return go(x,y, 0);
    }
    long go(int x,int y, int at)
    {
        if(at==-1) return 0;
        if(x <= a[at] && y>= b[at]) return val[at];
        if(y<a[at] || x>b[at]) return 0;
        return go(x, y, left[at]) + go(x, y, right[at]);
    }
    //add v to elements x through y
    void add(int x, int y, long v)
    {
        go3(x, y, v, 0);
    }
    void go3(int x, int y, long v, int at)
    {
        if(at==-1) return;
        if(y < a[at] || x > b[at]) return;
        val[at] = (val[at] + (Math.min(b[at], y) - Math.max(a[at], x) + 1)*v)%mod;
        go3(x, y, v, left[at]);
        go3(x, y, v, right[at]);
    }
}
static ArrayList<Integer>[] g;
static boolean[] marked;
static int[] id, low, stk;
static int pre, count;
static void scc()
{
    id = new int[g.length]; low = new int[g.length]; stk = new int[g.length+1];
    pre = count = 0;
    marked = new boolean[g.length];
    for(int i =0; i<g.length; i++)
        if(!marked[i]) dfs(i);
}
static void dfs(int i)
{
    marked[stk[++stk[0]]=i] = true;
    int min = low[i] = pre++;
    for(int j: g[i])
    {
        if(!marked[j]) dfs(j);
        if(low[j] < min) min = low[j];
    }
    if(min < low[i]) low[i] = min;
    else
    {
        while(stk[stk[0]] != i)
        {
            int j =stk[stk[0]--];
            id[j] = count;
            low[j] = g.length;
        }
        id[stk[stk[0]--]] = count++;
        low[i] = g.length;
    }
}
static class input {
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
  static String nextLine() throws IOException {
    return reader.readLine();
  }
}
}