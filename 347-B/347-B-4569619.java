import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    int count  = 0;
    for(int i = 0; i<n; i++) if(data[i] == i) count++;
    if(count == n)
        System.out.println(n);
    else
    {
        int res = count+1;
        for(int i = 0; i<n; i++)
        {
            if(data[i] != i && data[data[i]] == i) res = count+2;
        }
        System.out.println(res);
    }
}
}