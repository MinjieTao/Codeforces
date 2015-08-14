import java.util.*;

public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int v = input.nextInt();
    int[] data = new int[9];
    for(int i = 0; i<9; i++) data[i] = input.nextInt();
    int min = 101000, maxi = -1;
    for(int i = 8; i>=0; i--)
    {
        if(data[i] < min)
        {
            min = data[i];
            maxi = i;
        }
    }
    int max = v/min;
    if(max == 0) System.out.println(-1);
    else
    {
        int[] res = new int[max];
        for(int i = 0; i<max; i++) res[i] = maxi+1;
        int left = v - max*data[maxi];
        //System.out.println(left);
        for(int i = 0; i<max; i++)
        {
            int cur = maxi;
            for(int j = maxi+1; j<9; j++)
            {
                if(data[j] - data[cur] <= left)
                {
                    left -= data[j]-data[cur];
                    res[i] = j+1;
                    cur = j;
                }
            }
        }
        for(int i = 0; i<max; i++) System.out.print(res[i]);
    }
}
}