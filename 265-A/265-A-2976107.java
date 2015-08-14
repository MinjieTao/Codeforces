import java.util.*;
public class a
{
public static void main(String[] args)
{
Scanner input = new Scanner(System.in);
String s = input.next(), t = input.next();
int at = 0;
for(int i = 0; i<t.length(); i++)
{
if(t.charAt(i) == s.charAt(at))
at++;
}
System.out.println((int)(at+1));
}
}