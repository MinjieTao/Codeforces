import java.util.*;
public class Word {

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        int low = 0, up = 0;
        for(int i =0 ; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(c-'A' >= 0 && c - 'A' <=25)
                up++;
            else
                low++;
            
        }
        if(up > low)
            System.out.println(s.toUpperCase());
            else
                System.out.println(s.toLowerCase());
    }

}