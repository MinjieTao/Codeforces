import java.util.*;
public class a {
public static void main(String[] args)
{
	Scanner input = new Scanner(System.in);
	int n = input.nextInt();
	boolean[][] data = new boolean[n][3];
	for(int i = 0; i<n; i++)
		for(int j = 0; j<3; j++)
			data[i][j] = input.nextInt() == 1;
	int count = 0;
	for(int i = 0; i<n; i++)
	{
		int p = 0;
		for(int j = 0; j<3; j++)
			if(data[i][j]) p++;
		if(p>=2)
			count++;
	}
	System.out.println(count);
	
}
}