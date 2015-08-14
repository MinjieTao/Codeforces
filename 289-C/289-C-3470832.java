import java.util.*;
import java.io.*;
public class j {
public static void main(String[] args) throws Exception
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt();
    PrintWriter out = new PrintWriter(System.out);
    if(k>n) out.println(-1);
    else if(k==1)
    {
        if(n==1) out.print('a');
        else out.println(-1);
    }
    else
    {
        int x = n - k+2;
        for(int i = 0; i<x/2; i++) out.print("ab");
        if(x%2==1) out.print("a");
        for(int i = 0; i<k-2; i++) out.print((char)('c'+i));
    }
    out.close();
}
}