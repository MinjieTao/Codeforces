import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    char[] c = input.next().toCharArray();
    String res = "";
    for(int k = 0; k<10; k++)
    {
        for(int shift = 0; shift < n; shift++)
        {
            char[] cur = new char[n];
            for(int i = 0; i<n; i++) cur[i] = c[(i+shift)%n];
            String s = new String(cur);
            if(res.length() == 0 || res.compareTo(s) > 0) res = s;
        }
        for(int i = 0; i<n; i++)
        {
            if(c[i] == '9') c[i] -= 9;
            else c[i] ++;
        }
    }
    System.out.println(res);
}
}