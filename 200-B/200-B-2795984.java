import java.util.*;
public class b
{
public static void main(String[] args)
{
Scanner input = new Scanner(System.in);
int n = input.nextInt();
int num = 0, denom = 100*n;
for(int i = 0; i<n; i++) num += input.nextInt();
System.out.println(100.0*num/denom);
}
}