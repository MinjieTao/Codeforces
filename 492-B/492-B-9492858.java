import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), d = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    Arrays.sort(data);
    double res = Math.max(data[0], d - data[n-1]);
    for(int i = 0; i<n-1; i++)
    {
        //System.out.println(data[i+1]+" "+data[i]);
        res = Math.max(res, (data[i+1] - data[i])/2.);
    }
    System.out.println(res);
}
}