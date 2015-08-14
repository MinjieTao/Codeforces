import java.util.*;
public class b {
public static void main(String[] args)
{
	Scanner input = new Scanner(System.in);
	long n = input.nextLong();
	int min = 1000000001;
	for(int i = 1; i<=200; i++)
	{
		int lo = 0, hi = (int)1e9;
		for(int j = 0; j<100; j++)
		{
			int mid = (lo+hi)/2;
			if(go(mid, i) > n)
				hi = mid;
			else
				lo = mid;
		}
		//System.out.println(i + " " + lo);
		if(go(lo, i) == n && sum(lo) == i)
			min = Math.min(min, lo);
	}
	if(min > 1e9)
		System.out.println(-1);
	else
		System.out.println(min);
}
public static long go(int x, int s)
{
	return (long)x*(x+s);
}
public static long sum(long n)
{
	long res = 0;
	while(n > 0)
	{
		res += n%10;
		n/=10;
	}
	return res;
}
}