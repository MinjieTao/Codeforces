import java.util.*;
public class B265 {
    static int[][] data;
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    data = new int[8][3];
    for(int i = 0; i<8; i++)
    {
        for(int j = 0; j<3; j++)
            data[i][j] = input.nextInt();
    }
    poss = false;
    go(0, 0, new boolean[3], new int[8][3]);
    if(!poss) System.out.println("NO");
}
static long d2(int[] a, int[] b)
{
    long dx = a[0]-b[0], dy = a[1]-b[1], dz = a[2]-b[2];
    return dx*dx+dy*dy+dz*dz;
}
static boolean poss;
static void go(int row, int col, boolean[] used, int[][] points)
{
    if(poss) return;
    if(row == 8)
    {
        if(good(points))
        {
            System.out.println("YES");
            for(int i = 0; i<8; i++) System.out.println(points[i][0]+" "+points[i][1]+" "+points[i][2]);
            poss = true;
        }
        
        return;
    }
    if(col == 3)
    {
        go(row+1, 0, new boolean[3], points);
        return;
    }
    for(int i = 0; i<3; i++)
    {
        if(row == 0 && i != col) continue;
        if(used[i]) continue;
        used[i] = true;
        points[row][col] = data[row][i];
        go(row,col+1, used, points);
        used[i] = false;
    }
}
static boolean good(int[][] points)
{
    long min = (long)1e18;
    ArrayList<Long> list = new ArrayList<Long>();
    for(int i = 0; i<8; i++)
        for(int j = i+1; j<8; j++)
        {
            long cur = d2(points[i], points[j]);
            list.add(cur);
            if(cur < min) min = cur;
        }
    if(min == 0) return false;
    int[] cs = new int[4];
    for(int i = 0; i<list.size(); i++)
    {
        for(int j = 1; j<=3; j++)
            if(min * j == list.get(i))
                cs[j]++;
    }
    return cs[1] == 12 & cs[2] == 12 && cs[3] == 4;
}
}