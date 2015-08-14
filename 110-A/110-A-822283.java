import java.util.*;
public class NearlyLucky {

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        int l = 0;
        for(int i = 0; i<s.length(); i++)
            if(s.charAt(i) == '4' || s.charAt(i) == '7')
                l++;
        if(l==4 || l==7 || l==44)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

}