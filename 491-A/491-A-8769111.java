import java.io.PrintWriter;
import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int a = input.nextInt(), b = input.nextInt();
    int n = a+b+1;
    int[] data = new int[n];
    if(b< a)
    {
        for(int i = 0; i<n; i++) data[i] = 1 + i;
        for(int i = 0; i<b; i++)
        {
            int temp = data[2*i];
            data[2*i] = data[2*i+1];
            data[2*i+1] = temp;
        }
    }
    else
    {
        for(int i = 0; i<n; i++) data[i] = 1 + (n-1-i);
        for(int i = 0; i<a; i++)
        {
            int temp = data[2*i];
            data[2*i] = data[2*i+1];
            data[2*i+1] = temp;
        }
    }
    for(int x: data) out.print(x+" ");
            out.close();
}
}