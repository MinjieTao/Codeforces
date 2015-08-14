import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] sizes = new int[n];
    for(int i = 0; i<n;i++) sizes[i] = input.nextInt();
    int[][] data = new int[n][sizes[0]];
    ArrayList<Swap> out = new ArrayList<Swap>();
    for(int i =0; i<n; i++)
        for(int j = 0; j<sizes[i]; j++)
            data[i][j] = input.nextInt();
    for(int i = 0; i<n; i++)
        for(int j = 0; j<sizes[i]; j++)
        {
            if(data[i][j] == 0)
                continue;
            //find min
            int min = data[i][j], mincol = j, minrow = i;
            for(int k = j+1; k<sizes[i]; k++)
                if(data[i][k] < min && data[i][k] != 0)
                {
                    minrow = i; mincol = k; min = data[i][k];
                }
            for(int s = i+1; s<n; s++)
            {
                for(int t = 0; t<sizes[i]; t++)
                {
                    if(data[s][t] != 0 && data[s][t] < min)
                    {
                        minrow = s; mincol = t;
                        min = data[s][t];
                    }
                }
            }
            if(minrow == i && mincol == j)
                continue;
            int temp = data[i][j];
            out.add(new Swap(i+1, j+1, minrow+1, mincol+1));
            data[i][j] = min;
            data[minrow][mincol] = temp;
        }
    System.out.println(out.size());
    for(Swap sw: out)
        System.out.println(sw.a + " " + sw.b + " " + sw.c + " " + sw.d);
}
public static class Swap
{
    int a, b, c, d;
    public Swap(int a, int b, int c, int d)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
}
}