import java.util.*;
public class C2 {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    cs = new Point[3];
    rs = new double[3];
    for(int i = 0; i<3; i++)
    {
        cs[i] = new Point(input.nextInt(), input.nextInt());
        rs[i] = input.nextInt();
    }
    Point start = new Point((cs[0].x + cs[1].x + cs[2].x)/3, (cs[0].y + cs[1].y + cs[2].y)/3);
    double change = 10;
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};
    while(change > 1e-9)
    {
        boolean good = false;
        for(int k = 0; k<4; k++)
        {
            double nx = start.x + dx[k] * change;
            double ny = start.y + dy[k] * change;
            Point next = new Point(nx, ny);
            if(fitness(next) < fitness(start))
            {
                start = next;
                good = true;
                break;
            }
        }
        if(!good) change /= 2;
    }
    if(fitness(start) < 1e-6)
        System.out.println(start.x+" "+start.y);
}
static Point[] cs;
static double[] rs;
static double fitness(Point p)
{
    double[] as = new double[3];
    for(int i = 0; i<3; i++) as[i] = ang(p, cs[i], rs[i]);
    return (as[0] - as[1]) * (as[0] - as[1]) + (as[0] - as[2]) * (as[0] - as[2]) + (as[1] - as[2]) * (as[1] - as[2]);
}
static double ang(Point p, Point c, double r)
{
    return p.dist(c) / r;
}
static class Point
{
    double x, y;
    public Point(double xx, double yy)
    {
        x = xx; y = yy;
    }
    double dist(Point p)
    {
        return Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
    }
}
}