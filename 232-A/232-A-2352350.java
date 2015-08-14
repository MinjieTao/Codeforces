import java.util.*;
public class a {
public static void main(String[] args)
{
	Scanner input = new Scanner(System.in);
	int k = input.nextInt();
	
	int[] comb = new int[1001];
	for(int i = 3; i < 101; i++)
		comb[i] = i*(i-1)*(i-2)/6;
	int[] comb2 = new int[101];
	for(int i = 2; i<101; i++)
		comb2[i] = i*(i-1)/2;
	int max = 0;
	ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 3; i<101; i++)
		{
			if(comb[i] > k)
			{
				max = i-1;
				break;
			}
		}
		k -= comb[max];
		//System.out.println(k);
	while(k > 0)
	{
		for(int i = 2; i<max+1; i++)
		{
			//System.out.println(i + " " + comb2[i]);
			if(comb2[i] > k)
			{
				//System.out.println(comb2[i] + " " + comb2[i-1]);
				list.add(i-1);
				k -= (comb2[i-1]);
				break;
			}
		}
		//break;
	}
	int n = max;
	for(int i: list)
		n++;
			System.out.println(n);
	boolean[][] adj = new boolean[n][n];
		for(int q = 0; q<max; q++)
			for(int p = 0; p<max; p++)
			{
				if(p!=q)
				adj[p][q] = true;
			}
		for(int i = 0; i<list.size(); i++)
		{
			for(int j = 0; j<list.get(i); j++)
			{
				adj[max+i][j] = true;
				adj[j][max+i] = true;
			}
		}
	for(int i = 0; i<n; i++)
	{
		for(int j = 0; j<n; j++)
			System.out.print(adj[i][j] ? "1" : "0");
		System.out.println();
	}
}
}