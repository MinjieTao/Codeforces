import java.util.*;
public class j {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String s = input.next().toLowerCase();
    int n = input.nextInt();
    for(int i =0 ; i<s.length(); i++)
        if(s.charAt(i)-'a' < n) s = s.substring(0, i)+(char)(s.charAt(i)+'A'-'a')+s.substring(i+1);
    System.out.println(s);
}
}