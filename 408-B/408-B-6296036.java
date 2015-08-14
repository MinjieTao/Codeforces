import java.io.PrintWriter;
import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int[] counts = new int[26];
    String in = input.next();
    for(int i = 0; i<in.length(); i++)
        counts[in.charAt(i)-'a']++;
    String t = input.next();
    int[] need = new int[26];
    for(int i = 0; i<t.length(); i++) need[t.charAt(i)-'a']++;
    int tot = 0;
    for(int i = 0; i<26; i++)
    {
        if(need[i] == 0) continue;
        int max = Math.min(need[i], counts[i]);
        if(max == 0)
        {
            out.println(-1);
            out.close();
            return;
        }
        tot += max;
    }
    out.println(tot);
    
    out.close();
}
}