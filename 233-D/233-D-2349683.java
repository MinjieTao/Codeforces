import java.util.*;
public class d {
	public static int mod = 1000000007;
	public static long[][] comb;
	public static long[][] memo;
	public static long[] data;
public static void main(String[] args)
{
	Scanner input = new Scanner(System.in);
	long n = input.nextLong(), m = input.nextLong(), k = input.nextLong();
	comb = new long[10100][1010];
	for(int i = 0; i< 10100; i++)
		comb[i][0] = 1;
	for(int i = 1; i<10100; i++)
	{
		for(int j = 1; j<i && j < 1010; j++)
			comb[i][j] = (comb[i-1][j] + comb[i-1][j-1])%mod;
		if(i < 1010)
		comb[i][i] = 1;
	}
	if(m==n)
	{
		System.out.println(comb[(int)(n*n)][(int)k]);
	}
//	else if(m <= 2*n)
//	{
//		long repeat = m - n;
//		long res = 0;
//		for(int i = 0; i <= k; i++)
//		{
//			memo = new long[(int)n+1][(int)k+1];
//			for(long[] j: memo)
//				Arrays.fill(j, -1);
//			//long outer = pow(comb[(int)n][i], 2*repeat);
//			long outer = go((int)n, (int)repeat, i)%mod;
//			long inner = comb[(int)(n*(n-repeat))][(int)(k - i)]%mod;
//			//System.out.println(i + " " + inner + " " + outer);
//			//System.out.println(outer + " " + inner);
//			res += (outer*inner)%mod;
//			res%= mod;
//		}
//		System.out.println(res);
//	}
	else
	{
			//fix this case!
		memo = new long[(int)n+1][(int)k+1];
		for(long[] j: memo)
			Arrays.fill(j, -1);
			q = m/n; r = m%n;
			pows = new long[(int)n+1];
			for(int i = 0; i<n+1; i++)
				pows[i] = pow(comb[(int)n][i], q);
			System.out.println(go2((int)n, (int)n, (int)k));
	}
}
public static long q, r;
public static long[] pows;
public static long pow(long a, long b)
{
	if(b==0)
		return 1;
	if(b%2 == 0)
	{
		long sqrt = pow(a, b/2);
		return (sqrt*sqrt)%mod;
	}
	return (a*pow(a, b-1))%mod;
}
public static long go2(int n, int cols, int left)
{
	if(cols < 0)
	{
		return 0;
	}
	if(left == 0)
		return 1;
	if(memo[cols][left] != -1)
		return memo[cols][left];
	long res = 0;
	for(int i = 0; i<= left && i<=n; i++)
	{
		//long mult = pow((long)comb[n][i], q)%mod;
		long mult = pows[i];
		if(n-cols < r)
		{
			mult*=comb[n][i];
			mult%= mod;
		}
		res += (go2(n, cols-1, left-i) * mult)%mod;
		res%= mod;
	}
	//System.out.println(cols + " " + left + " " + res);
	return memo[cols][left]=  res%mod;
}
public static long go(int n, int cols, int left)
{
	if(cols < 0)
	{
		return 0;
	}
	if(left == 0)
		return 1;
	if(memo[cols][left] != -1)
		return memo[cols][left];
	long res = 0;
	for(int i = 0; i<= left && i<=n; i++)
	{
		res += (go(n, cols-1, left-i) * ((long)comb[n][i]*comb[n][i])%mod)%mod;
		res%= mod;
	}
	//System.out.println(cols + " " + left + " " + res);
	return memo[cols][left]=  res%mod;
}
}