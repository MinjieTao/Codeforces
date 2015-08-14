import java.util.*;
import java.io.*;
public class a
{
    public static void main(String[] args) throws IOException
    {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        int n = s.length();
        String best = s.charAt(0)+"";
        for(int mask = 1; mask < (1<<n); mask++)
        {
            String at = "";
            for(int i = 0; i<n; i++)
                if((mask & (1<<i)) > 0) at += s.charAt(i);
            if(isP(at) && at.compareTo(best) > 0) best = at;
        }
        System.out.println(best);
    }
    public static boolean isP(String s)
    {
        if(s.length() < 2) return true;
        boolean b = true;
        {
            for(int i = 0; i<s.length(); i++)
                b &= s.charAt(i) == s.charAt(s.length()-1-i);
        }
        return b;
    }
}