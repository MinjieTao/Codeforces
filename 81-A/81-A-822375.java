import java.util.*;
public class PlugIn {

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        StringBuilder s = new StringBuilder(input.next());
        StringBuilder out = new StringBuilder(s.charAt(0) + "");
        for(int i = 1; i<s.length(); i++)
        {
            //System.out.println(out);
            if(out.length()==0)
            {
                out.append(s.charAt(i));
                continue;
            }
            if(s.charAt(i) == out.charAt(out.length()-1))
                out.deleteCharAt(out.length()-1);
            else
                out.append(s.charAt(i));
        }
        System.out.println(out);

    }

}