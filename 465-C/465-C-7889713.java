import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), p = input.nextInt();
    char[] s = input.next().toCharArray();
    boolean found = false;
    for(int i = n-1; i>=0 && !found; i--)
    {
        for(int j = s[i]-'a' + 1; j<p && !found; j++)
        {
            if(i > 0 && j == s[i-1] - 'a') continue;
            if(i > 1 && j == s[i-2] - 'a') continue;
            s[i] = (char)('a'+j);
            for(int k = i+1; k<n; k++)
            {
                for(int l = 0; l<p; l++)
                {
                    if(k > 0 && l == s[k-1] - 'a') continue;
                    if(k > 1 && l == s[k-2] - 'a') continue;
                    s[k] = (char)('a'+l);
                    break;
                }
            }
            found = true;
        }
    }
    if(!found) System.out.println("NO");
    else System.out.println(new String(s));
}
static boolean good(char[] s)
{
    char[] xs = new char[Math.min(s.length, 7)];
    for(int i = 0; i<xs.length; i++) xs[i] = s[s.length - 1- i];
    for(int i = 0; i < xs.length; i++)
        for(int j = i+1; j<xs.length; j++)
        {
            boolean pal = true;
            int len = (j-i+1);
            for(int k = 0; k<len; k++)
            {
                pal &= xs[i+k] == xs[i+(len-1-k)];
            }
            if(pal) return false;
        }
    return true;
}
}