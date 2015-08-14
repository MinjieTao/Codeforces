import java.util.*;
public class d {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++)
        data[i] = input.nextInt();
    int sum = data[n-1];
    boolean[] pos = new boolean[n];
    pos[n-1] = true;
    for(int i = n-2; i>=0; i--)
        if(sum < 0)
        {
            pos[i] = true;
            sum += data[i];
        }
        else
            sum -= data[i];
    if(sum<0)
        for(int i = 0; i<n; i++) pos[i] = !pos[i];
    for(int i = 0; i<n; i++) System.out.print(pos[i] ? '+':'-');
}
}