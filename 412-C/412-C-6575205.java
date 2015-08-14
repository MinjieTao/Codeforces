import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    String[] data = new String[n];
    for(int i = 0; i<n; i++) data[i] = input.next();
    int len = data[0].length();
    StringBuilder sb = new StringBuilder("");
    for(int i = 0; i<len; i++)
    {
        HashSet<Character> set = new HashSet<Character>();
        for(int j = 0; j<n; j++)
        {
            char c = data[j].charAt(i);
            if(c != '?') set.add(c);
        }
        int[] a = new int[set.size()];
        int at = 0;
        for(char c: set) a[at++] = c;
        if(a.length == 0)
        {
            sb.append('x');
        }
        else if(a.length == 1)
        {
            sb.append((char)a[0]);
        }
        else sb.append('?');
    }
    System.out.println(sb.toString());
}
}