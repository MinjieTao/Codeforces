import java.util.*;
public class d {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String s = input.next();
    int n = s.length();
    int ms = 0, totms = 0, res = 0, max = 0, totfs = 0, last = 0;
    for(int i = 0; i<n; i++)
    {
        char c = s.charAt(i);
        if(c == 'M')
        {
            totms++;
        }
        else
        {
            if(totfs == 0)
            {
                max = last = i;
                totfs++;
                continue;
            }
            if(totms == 0 || i - totfs > last) last = i - totfs;
            else last++;
            max = last;
            totfs++;
        }
    }
    System.out.println(max+res);
}
}