import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
        int n = input.nextInt();
    int[] data = new int[n];
    int[] count = new int[3];
    boolean good = true;
    for(int i = 0; i<n; i++)
    {
        int x = input.nextInt();
        if(x==25) count[0]++;
        else if(x==50)
        {
            count[0]--;
            count[1]++;
        }
        else
        {
            count[0]--;
            if(count[1] > 0)
            {
                count[1]--;
            }
            else count[0]-=2;
        }
        if(count[0]<0 || count[1]<0) good = false;
    }
    System.out.println(good ? "YES" : "NO");
}
}