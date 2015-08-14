import java.util.*;
public class PetyaStrings {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s1 = input.next().toLowerCase();
        String s2 = input.next().toLowerCase();
        int a = s1.compareTo(s2);
        if(a!=0)
            System.out.println(a/Math.abs(a));
        else
            System.out.println(0);

    }

}