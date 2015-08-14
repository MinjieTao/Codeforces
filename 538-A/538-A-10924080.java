import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String s = input.next();
    int n = s.length();
    boolean good = false;
    for(int i = 0; i<n; i++)
        for(int j = i+1; j<=n; j++)
        {
            good |= (s.substring(0, i) + s.substring(j)).equals("CODEFORCES");
        }
    System.out.println(good ? "YES": "NO");
}
}