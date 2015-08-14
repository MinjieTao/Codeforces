import java.io.PrintWriter;
import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = input.nextInt();
    int[] size = new int[n];
    for(int i = 0; i<n; i++) size[i] = input.nextInt();
    int min = 987654321;
    for(int i = 0; i<n; i++)
    {
        int tot = 0;
        for(int j = 0; j<size[i]; j++) tot += input.nextInt();
        tot = tot*5 + size[i]*15;
        min = Math.min(min, tot);
    }
    out.println(min);
    
    out.close();
}
}