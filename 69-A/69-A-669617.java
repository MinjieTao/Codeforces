import java.util.*;
public class physicist
{
public static void main(String[] args)
{
Scanner input = new Scanner(System.in);
long num = input.nextLong();
long x = 0;
long y = 0;
long z = 0;
for(int i = 0; i < num; i++)
{
x+= input.nextInt();
y+= input.nextInt();
z+= input.nextInt();
}
if(x==0&&y==0&&z==0)
System.out.println("YES");
else
System.out.println("NO");

}
}