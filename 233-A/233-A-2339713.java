import java.util.*;
public class a {
public static void main(String[] args)
{
	Scanner input = new Scanner(System.in);
	int n =input.nextInt();
	if(n%2==1)
		System.out.println(-1);
	else
	{
		for(int i = 0; i<n; i++)
		{
			if(i%2 == 0)
				System.out.print((i+2) + " ");
			else
				System.out.print(i + " ");
		}
		System.out.println();
	}
}
}