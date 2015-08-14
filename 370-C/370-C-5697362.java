import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    int[] count = new int[m];
    for(int i = 0; i<n; i++) count[input.nextInt()-1]++;
    Color[] data = new Color[m];
    for(int  i= 0; i<m; i++) data[i] = new Color(i+1, count[i]);
    Arrays.sort(data);
    int[][] res = new int[n][2];
    int at = 0;
    for(int i = 0; i<m; i++)
    {
        while(data[i].f > 0)
        {
            data[i].f--;
            if(res[at][0] == 0)
            {
                res[at][0] = data[i].c;
                at = (at+1)%n;
                res[at][1] = data[i].c;
                at = (at+1)%n;
            }
            else
            {
                res[at][1] = data[i].c;
                at = (at+1)%n;
                res[at][0] = data[i].c;
                at = (at+1)%n;
            }
        }
    }
    int c = 0;
    for(int i = 0; i<n; i++) if(res[i][0] != res[i][1]) c++;
    System.out.println(c);
    for(int i = 0;i<n; i++) System.out.println(res[i][0]+" "+res[i][1]);
}
static class Color implements Comparable<Color>
{
    int c, f;
    public Color(int cc, int ff)
    {
        c = cc; f = ff;
    }
    @Override
    public int compareTo(Color o) {
        // TODO Auto-generated method stub
        return o.f - f;
    }
}
}