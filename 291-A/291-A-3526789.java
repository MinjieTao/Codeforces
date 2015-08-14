import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    Arrays.sort(data);
    boolean valid = true;
    for(int i = 2; i<n; i++) if(data[i] != 0 && data[i] == data[i-1] && data[i] == data[i-2]) valid = false;
    if(!valid) System.out.println(-1);
    else
    {
        int count = 0;
        for(int i = 1; i<n; i++)
        {
            if(data[i] != 0 && data[i] == data[i-1])
            {
                count++;
                i++;
            }
        }
        System.out.println(count);
    }
}
}