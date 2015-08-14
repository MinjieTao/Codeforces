import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] pos = new int[11], neg = new int[11];
        int zs = 0;
        for(int i = 0; i<n; i++)
        {
            int k = input.nextInt();
            if(k == 0)
                zs++;
            else if(k<0)
                neg[-k]++;
            else
                pos[k]++;
        }
        long res = 0;
        for(int i = 0; i<11; i++)
            res += (long)pos[i]*neg[i];
        res += (long)zs*(zs-1)/2;
        System.out.println(res);
    }
}