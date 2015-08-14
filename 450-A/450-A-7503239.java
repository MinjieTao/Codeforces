import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    int max = -1, maxdex = -1;
    for(int i = 0; i<n; i++)
    {
        if((data[i]+m-1)/m >= max)
        {
            max = (data[i]+m-1)/m;
            maxdex = i+1;
        }
    }
    System.out.println(maxdex);
}
}