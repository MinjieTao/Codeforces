import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    int[] a = new int[n], b = new int[n];
    for(int i = 0; i<n; i++) a[i] = b[i] = input.nextInt();
    Arrays.sort(b);
    ArrayList<Integer> ls = new ArrayList<Integer>(), rs = new ArrayList<Integer>();
    for(int i = 0; i<n; i++)
    {
        if(a[i] == b[i]) continue;
        for(int j = i+1; j<n; j++)
        {
            if(a[j] == b[i])
            {
                ls.add(i);
                rs.add(j);
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                break;
            }
        }
    }
    out.println(ls.size());
    for(int i = 0; i<ls.size(); i++)
    {
        out.println(ls.get(i)+" "+rs.get(i));
    }
    out.close();
    
}
}