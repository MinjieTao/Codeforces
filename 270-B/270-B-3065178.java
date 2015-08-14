import java.util.*;
public class a2 {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++)data[i] = input.nextInt();
    int max = data[n-1];
    int count = 0;
    for(int i = n-2;i>=0;i--)
    {
        if(data[i] > max)
        {
            count+=(i+1);
            break;
        }
        else max = data[i];
    }
    System.out.println(count);
}
}