import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        int count = 0;
        while(true)
        {
            int tot = 0;
            if(s.length() == 1)
                break;
            for(int i =0; i<s.length(); i++)
                tot += s.charAt(i)-'0';
            s = tot+"";
            count++;
        }
        System.out.println(count);
        
    }
}