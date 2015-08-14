import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int k = input.nextInt();
    int[] x = new int[n];
    int[] y = new int[n];
    double distance = 0;
    for(int i = 0; i<n; i++)
    {
        x[i] = input.nextInt();
        y[i] = input.nextInt();
        if(i>0)
            distance += dist(x[i-1], y[i-1], x[i], y[i]);
    }
    distance *= k;
    System.out.println(distance/50);
}

private static double dist(int x1, int y1, int x2, int y2) 
{
    return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
}
}