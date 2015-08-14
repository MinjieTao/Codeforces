import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int k = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++)
        data[i] = input.nextInt();
    Arrays.sort(data);
    int count = 0;
    for(int i = 0; i<n; i++)
        if(data[i] >= data[n-k] && data[i] > 0)
            count++;
    System.out.println(count);
}
}