import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] data = new int[n];
        for(int i = 0; i<n; i++)
            data[i] = input.nextInt()*60 + input.nextInt();
        Arrays.sort(data);
        int count = 1, max = 1;
        for(int i = 1; i<n; i++)
        {
            if(data[i] == data[i-1])
                count++;
            else
            {
                max = Math.max(max,  count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        System.out.println(max);
    }
}