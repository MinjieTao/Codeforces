import java.util.*;
public class Translation {


    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        String s1 = input.next();
        String s2 = input.next();
        int len = s1.length();
        if(s2.length()!=len)
            System.out.println("NO");
        else
        {
            boolean same = true;
            for(int i = 0; i<len; i++)
                if(s1.charAt(i)!=s2.charAt(len-1-i))
                    same = false;
            if(same)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

}