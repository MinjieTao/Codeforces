import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String a = input.next(), b = input.next();
    int pos = 0;
    for(int i = 0; i<a.length(); i++) if(a.charAt(i) == '+') pos++; else pos--;
    int plus = 0, minus = 0;
    for(int i = 0; i<b.length(); i++) if(b.charAt(i) == '+') plus++; else if(b.charAt(i) == '-') minus++;
    int need = pos - plus + minus;
    int left = b.length() - plus - minus;
    int count = 0;
    //System.out.println(left+" "+need);
    for(int i = 0; i<(1<<left); i++) if(Integer.bitCount(i) * 2 - left == need) count++;
    System.out.println(1.*count / (1<<left));
}
}