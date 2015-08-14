import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long[] data = new long[n], prizes = new long[5], answers = new long[5];
        for(int i = 0; i<n; i++) data[i] = input.nextInt();
        for(int i = 0; i<5; i++) prizes[i] = input.nextInt();
        long points = 0;
        for(int i = 0; i<n; i++)
        {
            points += data[i];
            for(int j = 4; j>=0; j--)
            {
                long x = points/prizes[j];
                answers[j] += x;
                points -= prizes[j]*x;
            }
        }
        for(long i: answers) System.out.print(i + " ");
                System.out.println("\n"+points);
    }
}