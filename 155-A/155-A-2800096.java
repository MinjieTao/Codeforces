import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] data = new int[n];
        for(int i = 0; i<n; i++) data[i] = input.nextInt();
        int max = -1, min = 1000000, count = 0;
        for(int i = 0; i<n; i++)
        {
            if(i > 0 && (data[i] > max || data[i] < min))
                count++;
            min = Math.min(min, data[i]);
            max = Math.max(max, data[i]);
        }
        System.out.println(count);
            
    }
}