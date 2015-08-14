import java.util.*;
public class a
{
public static void main(String[] args)
{
Scanner input = new Scanner(System.in);
int n= input.nextInt();
int[] data = new int[n];
for(int i = 0; i<n; i++) data[i] = input.nextInt();
int res = 0;
for(int i = 0; i<n; i++)
{
int xor = 0;
for(int j = i; j<n; j++)
{
xor ^= data[j];
res = Math.max(res, xor);
}
}
System.out.println(res);
}
}