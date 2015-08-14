import java.util.*;
public class a {
public static void main(String[] args)
{
	Scanner input = new Scanner(System.in);
	int n = input.nextInt();
	System.out.print(n+" ");
	for(int i = 1; i<n-1; i++)
		System.out.print(i+" ");
	if(n>1)
	System.out.println(n-1);
}
}