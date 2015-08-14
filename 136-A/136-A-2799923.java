import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] data = new int[n];
        for(int i = 1; i<=n; i++)
            data[input.nextInt()-1] = i;
        for(int i = 0; i<n; i++)
            System.out.print((data[i]) + " ");
        System.out.println();
    }
}