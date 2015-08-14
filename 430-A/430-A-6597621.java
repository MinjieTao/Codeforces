import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    Point[] data = new Point[n];
    for(int i = 0; i<n; i++) data[i] = new Point(i, input.nextInt());
    Arrays.sort(data);
    for(int i = 0; i<m; i++)
    {
        input.nextInt();
        input.nextInt();
    }
    int[] out = new int[n];
    for(int i = 0; i<n; i++) out[data[i].i] = i%2;
    for(int i = 0; i<n; i++) System.out.print(out[i]+" ");
}
static class Point implements Comparable<Point>
{
    int i, x;
    public Point(int ii, int xx)
    {
        i = ii; x = xx;
    }
    @Override
    public int compareTo(Point o) {
        // TODO Auto-generated method stub
        return x - o.x;
    }
}
}