import java.util.*;
public class b {
public static void main(String[] args)
{
	Scanner input = new Scanner(System.in);
	int n = input.nextInt(), d = input.nextInt(), l = input.nextInt();
	int minsum = (n+1)/2, maxsum = l*(n+1)/2;
	int mineven = n/2, maxeven = l*(n/2);
	if(maxsum - mineven < d || minsum - maxeven > d)
		System.out.println(-1);
	else
	{
		for(int i = 1; i<= l; i++)
		{
			boolean possible = false;
			int needed = d + i*(n/2);
			if(needed >= minsum && needed <= maxsum)
			{
				possible = true;
				int[] data = new int[n];
				for(int j = 0; j<n; j++)
				{
					if(j%2 == 0)
						data[j] = 1;
					else
						data[j] = i;
				}
				needed -= minsum;
				for(int j = 0; j<n; j+=2)
				{
					if(needed == 0)
						break;
					int change = Math.min(l-1, needed);
					data[j] += change;
					needed -= change;
				}
				for(int x: data)
					System.out.print(x + " ");
				System.out.println();
			}
			if(possible)
				break;
		}
			
	}
}
}