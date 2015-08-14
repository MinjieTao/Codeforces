import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    boolean[] good = new boolean[n];
    int count = 0;
    int max = 0;
    for(int i = 0; i<n; i++)
    {
        data[i] = input.nextInt();
        if(i>=2 && data[i] == data[i-1] + data[i-2]) good[i] = true;
        if(good[i])
        {
            count++;
        }
        else count = 0;
        max = Math.max(max, count);
    }
    System.out.println(n==1 ? 1 : max+2);
}
}