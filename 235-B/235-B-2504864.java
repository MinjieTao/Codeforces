import java.util.*;
public class B235 {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    double[] prob = new double[n];
    for(int i = 0; i<n; i++) prob[i] = input.nextDouble();
    double[] sum = new double[n];
    sum[0] = 0;
    double res = 0;
    for(int i = 0; i<n; i++)
        res += prob[i];
    for(int i = 1; i<n; i++)
    {
        sum[i] = (sum[i-1] + prob[i-1])*prob[i];
        res += 2*sum[i];
    }
    System.out.println(res);
}
}