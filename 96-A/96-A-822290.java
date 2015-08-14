import java.util.*;
public class Football {

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        boolean b = false;
        for(int i = 0; i < s.length()-6; i++)
        {
            boolean okay = true;
            for(int j = 0; j<6; j++)
            {
                if(s.charAt(i+j)!=s.charAt(i+j+1))
                    okay = false;
                
            }
            if(okay)
                b = true;
        }
        if(b)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

}