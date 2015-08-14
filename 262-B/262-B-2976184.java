import java.util.*;
public class b2 {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt();
    int[] data = new int[n];
    int sum = 0;
    for(int i = 0; i<n; i++)
    {
        data[i] = input.nextInt();
        sum += data[i];
    }
    int changed = 0, i = 0;
    while(changed < k && i < n && data[i] < 0)
    {
        changed++;
        sum -= 2*data[i];
        data[i]*=-1;
        i++;
    }
    Arrays.sort(data);
    int left = k - changed;
    if(left %2 == 1)
        sum -= 2*data[0];
    System.out.println(sum);
}
}