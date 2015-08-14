import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    double[] thetas = new double[n];
    for(int i = 0; i<n; i++)
    {
        int x = input.nextInt(), y = input.nextInt();
        thetas[i] = Math.atan2(y, x);
    }
    Arrays.sort(thetas);
    double max = 0;
    for(int i = 0; i<n; i++)
    {
        double angle = (Math.abs(thetas[i]-thetas[(i+1)%n]));
        if(i == n-1)
            angle = 2*Math.PI-angle;
        max = Math.max(max, angle);
    }
    System.out.println(360-max*360/(2*Math.PI));
}
}