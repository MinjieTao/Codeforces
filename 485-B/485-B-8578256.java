import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    long miny = (long)1e9;
    long minx = (long)1e9;
    long maxx = (long)-1e9;
    long maxy = (long)-1e9;
    for(int i = 0; i<n; i++)
    {
        long x = input.nextInt(), y = input.nextInt();
        maxx = Math.max(maxx, x);
        maxy = Math.max(maxy, y);
        minx = Math.min(minx, x);
        miny = Math.min(miny, y);
    }
    long res = Math.max((maxy - miny), (maxx - minx));
    System.out.println(res * res);
}
}