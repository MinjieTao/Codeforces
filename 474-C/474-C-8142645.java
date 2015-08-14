import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    for(int t = 0; t<T; t++)
    {
        int[] xs = new int[4], ys = new int[4], as = new int[4], bs = new int[4];
        for(int i = 0; i<4; i++)
        {
            xs[i] = input.nextInt();
            ys[i] = input.nextInt();
            as[i] = input.nextInt();
            bs[i] = input.nextInt();
        }
        int min = 1000000;
        for(int r1 = 0; r1<4; r1++)
            for(int r2 = 0; r2<4; r2++)
                for(int r3 = 0; r3<4; r3++)
                    for(int r4 = 0; r4<4; r4++)
                    {
                        int tot = r1+r2+r3+r4;
                        int[] nx = new int[4];
                        int[] ny = new int[4];
                        int[] rs = new int[]{r1, r2, r3, r4};
                        for(int i = 0; i<4; i++)
                        {
                            int[] rotated = rotate(xs[i] - as[i], ys[i] - bs[i], rs[i]);
                            nx[i] = rotated[0] + as[i];
                            ny[i] = rotated[1] + bs[i];
                        }
                        if(makeSquare(nx, ny))
                        {
                            min = Math.min(min, tot);
                        }
                    }
        System.out.println(min == 1000000 ? -1 : min);
    }
}
static int[] rotate(int x, int y, int k)
{
    if(k == 0) return new int[]{x, y};
    if(k == 1) return new int[]{-y, x};
    if(k == 2) return new int[]{-x, -y};
    return new int[]{y, -x};
}
static boolean makeSquare(int[] xs, int[] ys)
{
    long[] ds = new long[6];
    int at = 0;
    for(int i = 0; i<4; i++)
        for(int j = i+1; j<4; j++)
        {
            ds[at] = ((long)xs[i] - xs[j]) * (xs[i] - xs[j]) + ((long)ys[i] - ys[j]) * (ys[i] - ys[j]);
            at++;
        }
    Arrays.sort(ds);
    int[] fs = new int[4];
    for(int i = 0; i<4; i++)
        for(int j = i+1; j<4; j++)
        {
            long d = ((long)xs[i] - xs[j]) * (xs[i] - xs[j]) + ((long)ys[i] - ys[j]) * (ys[i] - ys[j]);
            if(d == ds[4])
            {
                fs[i]++;
                fs[j]++;
            }
        }
    for(int i = 0; i<4; i++) if(fs[i] != 1) return false;
    if(ds[0] == 0) return false;
    return ds[3] == ds[0] && ds[4] == ds[5] && ds[4] == 2 * ds[3];
}
}