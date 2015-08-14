import java.util.*;
public class BeautyBeast {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
        String s = input.next();
        int h = Integer.parseInt(s.substring(0,2))%12;
        int m = Integer.parseInt(s.substring(3,5));
        int min = 60*h+m;
        double dh = .5*min;
        double dm = 6*m;
        System.out.println(dh + " " + dm);
        
}
}