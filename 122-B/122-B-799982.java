import java.util.*;
public class b {

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        int four = 0;
        int seven = 0;
        for(int i = 0; i<s.length(); i++)
        {
            if(s.charAt(i)=='4')
                four++;
            else if(s.charAt(i)=='7')
                seven++;
        }
        if(seven==0 && four==0)
            System.out.println(-1);
        else if (four >= seven)
            System.out.println(4);
        else
            System.out.println(7);

    }

}