import java.util.*;
public class a
{
public static void main(String[] args)
{
Scanner input = new Scanner(System.in);
int n = input.nextInt();
for(int c = 0; c<n; c++)
{
int a = input.nextInt(), b = input.nextInt();
System.out.println(go(a, b));
}
}
public static int go(int a, int b)
{
if(a == 0 || b == 0)
return 0;
if(a<b)
{
int temp = a;
a = b;
b = temp;
}
return a/b + go(b,a%b);
}
}