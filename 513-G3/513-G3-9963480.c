#include <stdlib.h>
#include <stdio.h>
int main()
{
    int n, k;
    scanf("%d %d", &n, &k);
    k = k > 1000 ? 1000 : k;
    int data[101];
    int i, j, x;
    int count1[101][101][202];
    int count2[101][101][202];
    int count3[101][101][202];
    for(i = 0; i<n; i++) scanf("%d", &data[i]);
    double dp [101][101], next[101][101], pneither[101][101];
    for(i = 0; i<n; i++)
        for(j = i+1; j<n; j++)
            dp[i][j] = data[i] > data[j] ? 1 : 0;
    for(i = 0; i<n; i++)
        for(j = i+1; j<n; j++)
            pneither[i][j] = (i*(i+1) + (n-j)*(n-j-1) + (j-i)*(j-i-1))/2;
    for(i = 0; i<n; i++)
        for(j = i+1; j<n; j++)
        {
            for(x = j; x < i+n; x++)
            {
                int right = i < x - j ? i : x - j;//Math.min(i, x - j);
                int left = x - (n-1) > 0 ? x - (n-1) : 0;
                count1[i][j][x] = (right - left + 1);
            }
            for(x = i; x < i+j; x++)
            {
                int right = i < x - i ? i : x - i;
                int left = x - (j - 1) > 0 ? x - (j - 1) : 0;
                count2[i][j][x] = (right - left + 1);
            }
            for(x = j+i+1; x<j+n; x++)
            {
                int left = i+1 > x - (n-1) ? i+1 : x - (n-1);
                int right = j < x - j ? j : x - j;
                count3[i][j][x] = (right - left + 1);
            }
        }
        int iter;
    for(iter = 0; iter < k; iter++)
    {
        for(i = 0; i<n; i++)
            for(j = i+1; j<n; j++)
            {
                next[i][j] = pneither[i][j] * dp[i][j]; // Neither of them is affected.
                for(x = j; x < i+n; x++)
                {
                    next[i][j] += count1[i][j][x] * (1 - dp[x-j][x-i]);
                }
                for(x = i; x < i+j; x++)
                {
                    next[i][j] += count2[i][j][x] * dp[x-i][j];
                }
                for(x = j+i+1; x<j+n; x++)
                {
                    next[i][j] += count3[i][j][x] * dp[i][x - j];
                }
                next[i][j] /= (n*(n+1)/2);
            }
        for(i = 0; i<n; i++)
            for(j = i+1; j<n; j++)
                dp[i][j] = next[i][j];
    }
    double res = 0;
    for(i = 0; i<n; i++)
        for(j = i+1; j<n; j++)
        {
            //System.out.println(dp[i][j]);
            res += dp[i][j];
        }
    printf("%.12f\n", res);
    return 0;
}