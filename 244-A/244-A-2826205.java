import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        int[] data = new int[n*k+1], data2 = new int[k];
        for(int i = 0; i<k; i++)
        {
            int x = input.nextInt();
            data[x] = i+1;
            data2[i] = x;
        }
        int at = 1;
        for(int i = 0; i<k; i++)
        {
            int count = 1;
            System.out.print(data2[i]);
            while(count < n)
            {
                if(data[at] == 0)
                {
                    System.out.print(" "+at);
                    count++;
                }
                at++;
            }
            System.out.println();
        }
    }
}