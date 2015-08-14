import java.util.*;
import java.io.*;
public class j {
public static void main(String[] args) throws Exception
{
    Scanner input = new Scanner(new File("input.txt"));
    PrintWriter out = new PrintWriter(new File("output.txt"));
    
    
    int n = input.nextInt(), k = input.nextInt();
    int[] data = new int[n];
    int res = 0;
    for(int i =0 ; i<n; i++)
    {
        data[i] = input.nextInt();
        if(data[i]>3*k) res += data[i] - 3*k;
        else res += data[i]%k;
    }
    out.println(res);
    
    out.close();
}
}