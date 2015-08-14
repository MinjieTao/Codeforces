import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] data = new int[n];
        for(int i = 0; i<n; i++) data[i] = input.nextInt();
        boolean good = true;
        int min = 1000000007;
        int mindex = -1;
        for(int i = 0; i<n; i++)
        {
            if(data[i] == min)
                good = false;
            else if(data[i] < min)
                
            {
                min = data[i];
                good = true;
                mindex = i;
            }
        }
        System.out.println(good ? mindex+1 : "Still Rozdil");
    }
}