import java.util.*;
import java.io.*;
public class b {
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(System.in);
    Scanner input = new Scanner(new File("input.txt"));
    PrintWriter out = new PrintWriter(new File("output.txt"));
    //insert code here
    int n = input.nextInt(), k = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++)
        data[i] = input.nextInt();
    int[] data2 = new int[n];
    for(int i = 0; i<n; i++)
        data2[i] = data[i];
    Arrays.sort(data2);
    int res = data2[n-k];
    int found = 0;
    out.println(res);
    for(int i = 0; i<n; i++)
    {
        if(data[i] >= res && found < k)
        {
            found++;
            if(found == k)
                out.println((i+1));
            else
                out.print((i+1) + " ");
        }
    }
    out.close();
}
}