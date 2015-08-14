import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int xa = input.nextInt(), ya = input.nextInt(), xb = input.nextInt(), yb = input.nextInt();
        int n = input.nextInt();
        int[] xs = new int[n], ys = new int[n], rs = new int[n];
        for(int i = 0; i<n; i++)
        {
            xs[i] = input.nextInt(); 
            ys[i] = input.nextInt(); 
            rs[i] = input.nextInt();
        }
        int res = 0;
        for(int x = Math.min(xa, xb); x<=Math.max(xa, xb); x++)
        {
            boolean warm1 = false, warm2 = false;
            for(int i = 0; i<n; i++)
            {
                if(dsq(x, ya, xs[i], ys[i]) <= rs[i]*rs[i])
                    warm1 = true;
                if(dsq(x, yb, xs[i], ys[i]) <= rs[i]*rs[i])
                    warm2 = true;
            }
            if(!warm1) res++;
            if(!warm2) res++;
        }
        for(int y = Math.min(ya, yb) + 1; y<Math.max(ya, yb); y++)
        {
            boolean warm1 = false, warm2 = false;
            for(int i = 0; i<n; i++)
            {
                if(dsq(xa, y, xs[i], ys[i]) <= rs[i]*rs[i])
                    warm1 = true;
                if(dsq(xb, y, xs[i], ys[i]) <= rs[i]*rs[i])
                    warm2 = true;
            }
            if(!warm1) res++;
            if(!warm2) res++;
        }
        System.out.println(res);
    }
    public static int dsq(int xa, int ya, int xb, int yb)
    {
        return (xb-xa)*(xb-xa) + (yb-ya)*(yb-ya);
    }
}