import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    Point a = new Point(input.nextInt(), input.nextInt()), b = new Point(input.nextInt(), input.nextInt());
    int n = input.nextInt(), res = 0;
    Line[] data = new Line[n];
    for(int i = 0; i<n; i++) data[i] = new Line(input.nextInt(), input.nextInt(), input.nextInt());
    Segment s = new Segment(a,b);
    for(int i = 0; i<n; i++) if(lineIntersection(s, data[i]) != null) res++;
    System.out.println(res);
}
static class Line
{
    long a, b, c;
    public Line(long aa, long bb, long cc)
    {
        a = aa; b = bb; c = cc;
    }
}
public static Point lineIntersection(Segment s1, Line s2)
{
    long a1 = s1.end.y - s1.start.y;
    long b1 = s1.start.x - s1.end.x;
    long c1 = a1*s1.start.x + b1*s1.start.y;
    long a2 = s2.a;
    long b2 = s2.b;
    long c2 = -s2.c;
    long det = a1*b2 - a2*b1;
    if(det == 0)
    {
        //lines are parallel
        return null;
    }
    long xdet = (b2*c1 - b1*c2);
    long ydet = (a1*c2 - a2*c1);
    //System.out.println(xdet+" "+ydet+" "+det);
    if(!(xdet >= Math.min(s1.start.x*det,s1.end.x*det) && xdet <= Math.max(s1.end.x*det,s1.start.x*det)))
        return null;
    if(!(ydet >= Math.min(s1.start.y*det,s1.end.y*det) && ydet <= Math.max(s1.end.y*det,s1.start.y*det)))
        return null;
    return new Point(0, 0);
}
public static class Segment
{
    Point start, end;
    public Segment(Point a, Point b)
    {
        start = a; end = b;
    }
}
public static class Point
{
    long x, y; //x and y represent the coordinates of a point or the components of a vector
    public Point(long myx, long myy)
    {
        x = myx; y = myy;
    }
}
}