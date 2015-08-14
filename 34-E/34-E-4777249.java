import java.util.*;
public class d {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), t = input.nextInt();
    Ball[] data = new Ball[n];
    for(int i = 0; i<n; i++)
        data[i] = new Ball(input.nextInt(), input.nextInt(), input.nextInt());
    double curTime = 0;
    while(curTime < t)
    {
        PriorityQueue<Collision> pq = new PriorityQueue<Collision>();
        for(int i = 0; i<n; i++)
            for(int j = i+1; j<n; j++)
            {
                double collTime = collTime(data[i], data[j]);
                pq.add(new Collision(i, j, collTime));
            }
        boolean[] used = new boolean[n];
        while(!pq.isEmpty() && pq.peek().t < 1e-9) pq.poll();
        if(pq.isEmpty()) break;
        double deltaTime = pq.peek().t, nextTime = curTime + deltaTime;
        while(!pq.isEmpty() && pq.peek().t == deltaTime)
        {
            Collision next = pq.poll();
            if(nextTime > t) break;
            collide(data[next.i], data[next.j], deltaTime);
            used[next.i] = used[next.j] = true;
        }
        
        for(int i = 0; i<n; i++)
        {
            if(!used[i]) data[i].x += deltaTime*data[i].v;
        }
        curTime = nextTime;
    }
    double left = t - curTime;
    for(int i = 0; i<n; i++)
        System.out.println(data[i].x + left*data[i].v);
}
static void collide(Ball b1, Ball b2, double deltaTime)
{
    b1.x += b1.v*deltaTime;
    b2.x += b2.v*deltaTime;
    double newv1 = ((b1.m-b2.m)*b1.v + 2*b2.m*b2.v)/(b1.m+b2.m);
    double newv2 = ((b2.m-b1.m)*b2.v + 2*b1.m*b1.v)/(b1.m+b2.m);
    b1.v = newv1;
    b2.v = newv2;
}
static double collTime(Ball b1, Ball b2)
{
    if(Math.abs(b1.v - b2.v) < 1e-9) return 1e9;
    double res = (b2.x - b1.x)/(b1.v - b2.v);
    if(res<0) return 1e9;
    return res;
}
static class Collision implements Comparable<Collision>
{
    double t;
    int i, j;
    public Collision(int ii, int jj, double tt)
    {
        i = ii; j = jj; t = tt;
    }
    @Override
    public int compareTo(Collision that) {
        // TODO Auto-generated method stub
        return (int)Math.signum(this.t - that.t);
    }
}
static class Ball
{
    double x, v;
    int m;
    public Ball(int xx, int vv, int mm)
    {
        x = xx; v = vv; m = mm;
    }
}
}