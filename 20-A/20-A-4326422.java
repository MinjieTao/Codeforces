import java.util.*;
public class a {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        for(int i = 0; i<s.length()-1; i++)
        {
            if(s.charAt(i)=='/' && s.charAt(i+1) == '/')
            {
                s = s.substring(0, i) + s.substring(i+1);
                i--;
            }
        }
        if(s.length()>1 && s.charAt(s.length()-1) == '/') s = s.substring(0,s.length()-1);
        System.out.println(s);
    }

}