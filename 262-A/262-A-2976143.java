import java.util.*;
public class a
{
public static void main(String[] args)
{
Scanner input = new Scanner(System.in);
int n = input.nextInt(), k = input.nextInt();
int count = 0;
for(int i = 0; i<n; i++)
{
String s = input.next();
int luck = 0;
for(int j = 0; j<s.length(); j++)
if(s.charAt(j) == '4' || s.charAt(j) == '7') luck++;
if(luck <= k) count++;
}
System.out.println(count);
}

}