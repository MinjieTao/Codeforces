import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    int max = 0;
    for(int i = 0; i<n; i++)
    {
        data[i] = input.nextInt();
        max = Math.max(max, data[i]);
    }
    System.out.println(max);
}
}