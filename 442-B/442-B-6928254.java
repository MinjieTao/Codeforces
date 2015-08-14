import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    double[] data = new double[n];
    for(int i = 0; i<n; i++) data[i] = input.nextDouble();
    Arrays.sort(data);
    if(data[n-1] >= .5) System.out.println(data[n-1]);
    else
    {
        double res = 0;
        for(int end = 0; end<n; end++)
        {
            double prob = 0;
            double probZero = 1;
            for(int i = end; i<n; i++)
            {
                prob = (probZero)*data[i] + prob*(1-data[i]);
                probZero *= (1-data[i]);
            }
            res = Math.max(res, prob);
        }
        System.out.println(res);
    }
}
}