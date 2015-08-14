import java.util.*;
public class d {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++)
        data[i] = input.nextInt();
    int max = -123456789;
    for(int i = 1; i<= Math.sqrt(n); i++)
    {
        if(n%i != 0)
            continue;
        max = Math.max(max,  go(i, data));
        max = Math.max(max,  go(n/i, data));
    }
    System.out.println(max);
}
public static int go(int vertices, int[] data)
{
    if(vertices < 3)
        return -123456789;
    int[] memo = new int[data.length/vertices];
    for(int i = 0; i<data.length; i++)
        memo[i%(data.length/vertices)] += data[i];
    int max = -123456789;
    for(int m: memo)
        max = Math.max(max,  m);
    return max;
}
}