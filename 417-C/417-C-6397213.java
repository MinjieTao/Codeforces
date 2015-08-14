import java.util.*;
import java.io.*;
public class cc {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), k = input.nextInt();
    if(n == 1 || k*2 >= n) out.println(-1);
    else
    {
        out.println(n*k);
        for(int i = 0; i<n; i++)
        {
            int other = i;
            for(int j = 0; j<k; j++)
            {
                other = (other +1)%n;
                if(other == i) other = (other + 1)%n;
                out.println((i+1)+" "+(other+1));
            }
        }
    }
    out.close();
}
}