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
    boolean valid = true;
    for(int i = k; i<n; i++)
        if(data[i] != data[k-1])
            valid = false;
    if(!valid)
        System.out.println(-1);
    else
    {
        int index = -1;
        for(int i = k-2; i>=0; i--)
            if(data[i] != data[k-1])
            {
                index = i;
                break;
            }
        System.out.println((int)(index+1));
    }
}
}