import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    String s = "";
    String inp = input.next();
    for(int i = 0; i<inp.length(); i++)
    {
        char c = inp.charAt(i);
        if(c == '0' || c == '1') s += "";
        else if(c == '4') s += "322";
        else if(c == '6') s += "53";
        else if(c == '8') s += "7222";
        else if(c == '9') s += "7332";
        else s += c+"";
    }
    char[] ss = s.toCharArray();
    Arrays.sort(ss);
    for(int i = ss.length-1; i>=0;i--) System.out.print(ss[i]);
}
}