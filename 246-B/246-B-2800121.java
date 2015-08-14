import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] data = new int[n];
        for(int i = 0; i<n; i++)
            data[i] = input.nextInt();
        int sum = 0;
        for(int element: data) sum += element;
        System.out.println(sum%n == 0 ? n : n-1);
    }
}