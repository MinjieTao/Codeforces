import java.util.*;
public class math
{
public static void main(String[] args)
{
Scanner input = new Scanner(System.in);
String a = input.next();
String b = input.next();
String c = "";
for(int i = 0; i < a.length(); i++)
{
if(a.substring(i,i+1).equals(b.substring(i,i+1)))
c += "0";
else
c+= "1";
}
System.out.println(c);
}
}