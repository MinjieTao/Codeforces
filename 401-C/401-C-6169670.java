import java.io.PrintWriter;
import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), m = input.nextInt();
    if(n > m+1 || m > 2*n+2)
    {
        out.println(-1);
    }
    else
    {
        if(n>m)
        {
            out.print(0);
            n--;
        }
        while(m>n && n>0)
        {
            out.print("110");
            m-=2;
            n--;
        }
        while(m>0 && n>0)
        {
            out.print("10");
            n--;
            m--;
        }
        while(m>0)
        {
            out.print(1);
            m--;
        }
    }
    out.close();
}
}