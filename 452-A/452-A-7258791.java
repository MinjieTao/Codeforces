import java.util.*;
import java.io.*;
public class a {
    static String s;
public static void main(String[] args) throws IOException
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    s = input.next();
    if(n == 6) System.out.println("espeon");
    else if(n == 8) System.out.println("vaporeon");
    else
    {
        String[] poss = new String[]{"umbreon", "jolteon", "flareon", "sylveon", "glaceon", "leafeon"};
        for(int i = 0; i<poss.length; i++)
        {
            boolean good = true;
            for (int j = 0; j<s.length(); j++)
            {
                good &= s.charAt(j) == '.' || s.charAt(j) == poss[i].charAt(j);
            }
            if(good) System.out.println(poss[i]);
        }
    }
}

}