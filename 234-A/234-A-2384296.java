import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    Scanner input = new Scanner(new File("input.txt"));
    PrintWriter out = new PrintWriter(new File("output.txt"));
    int n = input.nextInt();
    String s = input.next();
    boolean[] left = new boolean[n];
    for(int i = 0; i<n; i++)
        left[i] = s.charAt(i) == 'L';
    for(int i = 0; i<n/2; i++)
    {
        if(left[i] && !left[i+n/2])
            out.println((i+1) + " " + (1+i+n/2));
        else
            out.println((1+i+n/2) + " " + (i+1));
    }
    out.close();
}
}