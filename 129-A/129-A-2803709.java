import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] data = new int[n];
        for(int i = 0; i<n; i++)
            data[i] = input.nextInt();
        int count0 = 0, count1 = 0;
        for(int i = 0; i<n; i++)
        {
            if(data[i]%2 == 0)
                count0++;
            else
                count1++;
        }
        System.out.println(count1%2 == 0 ? count0 : count1);
    }
}