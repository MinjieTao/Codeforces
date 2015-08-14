import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String s1 = input.next(), s2 = input.next();
        ArrayList<Integer> diff = new ArrayList<Integer>();
        if(s1.length() != s2.length())
            System.out.println("NO");
        else
        {
            for(int i = 0; i<s1.length(); i++)
            {
                if(s1.charAt(i) != s2.charAt(i)) diff.add(i);
            }
            if(diff.size() == 2 && s1.charAt(diff.get(0)) == s2.charAt(diff.get(1)) && s2.charAt(diff.get(0)) == s1.charAt(diff.get(1)))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}