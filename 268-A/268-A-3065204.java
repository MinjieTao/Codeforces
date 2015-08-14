import java.util.*;
public class a2 {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] as = new int[n], bs = new int[n];
    for(int i= 0; i<n; i++)
    {
        as[i] = input.nextInt();
        bs[i] = input.nextInt();
    }
    int count = 0;
    for(int i = 0; i<n; i++)
        for(int j = 0; j<n; j++)
        {
            if(i==j) continue;
            if(as[i]==bs[j]) count++;
        }
    System.out.println(count);
}
}