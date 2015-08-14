public class a {
public static void main(String[] args)
{
    String s = "";
    for(char c : (new java.util.Scanner(System.in)).next().toCharArray()) s += (c < '5' ? c : (char)('0' + '9' - c));
            if(s.charAt(0) == '0') System.out.println('9'+s.substring(1));
    else System.out.println(s);
}
}