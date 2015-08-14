import java.util.*;
public class g {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    double tot = 0;
    for(int i = 0; i<n; i++)
    {
        input.nextDouble();
        tot += input.nextDouble();
    }
    System.out.printf("%.3f\n", tot/n+5);
}
}