import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int k = input.nextInt();
        int[] data = new int[12];
        for(int i = 0; i<12; i++)
        {
            data[i] = input.nextInt();
        }
        Arrays.sort(data);
        int x = 11, count = 0;
        if(k==0)
            x++;
        else
        for(; x>=0; x--)
        {
            count += data[x];
            if(count >= k)
                break;
        }
        System.out.println(x == -1 ? x : 12-x);
    }
}