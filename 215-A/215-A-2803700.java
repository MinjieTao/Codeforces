import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] data = new int[n];
        for(int i = 0; i<n; i++) data[i] = input.nextInt();
        int m = input.nextInt();
        int[] data2 = new int[m];
        for(int i = 0; i<m; i++) data2[i] = input.nextInt();
        int max = 0, count = 0;
        for(int i = 0; i<n; i++)
            for(int j = 0; j<m; j++)
            {
                if(data2[j]%data[i] != 0) continue;
                int ratio = data2[j]/data[i];
                if(ratio == max) count++;
                else if(ratio > max)
                {
                    max = ratio;
                    count = 1;
                }
            }
        System.out.println(count);
    }
}