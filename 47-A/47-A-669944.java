import java.util.*;
public class triangular
{
public static void main(String[] args)
{
Scanner input = new Scanner(System.in);
int in = input.nextInt();
String out = "NO";
for(int i = 1; i < 500; i++)
{
if(in==i*(i+1)/2)
out = ("YES");
}
System.out.println(out);
}

}