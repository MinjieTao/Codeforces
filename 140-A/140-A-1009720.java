import java.util.*;
public class a {
public static void main(String[] args)
{
	Scanner input = new Scanner(System.in);
	int n = input.nextInt();
	int R = input.nextInt();
	int r = input.nextInt();
	if(n==1)
	{
		if(r<=R)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	else
	{
	double angle = Math.PI/n;
	double rgood = (R*Math.sin(angle)/(1+Math.sin(angle)));
	//System.out.println(rgood);
	if(rgood+1E-9 < r)
		System.out.println("NO");
	else
		System.out.println("YES");
	}
}
}