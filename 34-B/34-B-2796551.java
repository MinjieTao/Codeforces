import java.util.*;
public class b
{
public static void main(String[] args)
{
Scanner input = new Scanner(System.in);
int n = input.nextInt(), m = input.nextInt();
int[] data = new int[n];
for(int i = 0; i<n; i++) data[i] = input.nextInt();
int res = 0;
Arrays.sort(data);
for(int i = 0; i<m && i<n; i++)
{
if(data[i] > 0)
break;
res -= data[i];
}
System.out.println(res);
}
}