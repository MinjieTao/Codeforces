import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt(), t = input.nextInt();
        long res = 0;
        long[][] comb = comb(61);
        for(int i = 4; i<= t - 1; i++)
            res += comb[n][i]*comb[m][t-i];
        System.out.println(res);
    }
    //Returns array of combinations (Pascals's triangle) up to nCn - O(n^2)
    //comb[i][j] represents the value of i choose j
    public static long[][] comb(int n)
    {
        long[][] comb = new long[n+1][n+1];
        for(int i = 0; i<= n; i++)
            comb[i][0] = 1;
        for(int i = 1; i<= n; i++)
            for(int j = 1; j<= i; j++)
                comb[i][j] = (comb[i-1][j] + comb[i-1][j-1]);
        return comb;
    }
}