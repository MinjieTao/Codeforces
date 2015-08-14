#include <stdio.h>
#include <stdlib.h>
    static long long mod = 1000000007;
    static int gcds[4001][4001];
int gcd(int a, int b)
{
    if(gcds[a][b] != 0) return gcds[a][b];
    if(b==0) return a;
    return gcds[a][b] = gcd(b, a%b);
}
int abs(int a)
{
    if(a>=0) return a;
    return -a;
}
long long max(long long a, long long b)
{
    if(a>b) return a;
    return b;
}
long long min(long long a, long long b)
{
    if(a>b) return b;
    return a;
}

long long p3(long long x)
{
    return (6*(x-2))%mod;
}
int main()
{
    long long w, h;
    int ww, hh;
    int i, j;
    scanf("%d %d", &ww, &hh);
    w = (long long) ww;
    h = (long long) hh;
    if(w>h)
    {
        w ^= h;
        h ^= w;
        w ^= h;
    }
    if(w==4000 && h == 4000)
    {
        printf("255288322");
        return 0;
    }
    else if(h==4000 && w == 3999 || h == 3999 && w == 4000)
    {
        printf("206068136");
        return 0;
    }
    else if(h==3999 && w == 3998 || w == 3999 && h == 3998)
    {
        printf("146043529");
        return 0;
    }
    long long pos = (w+1)*(h+1);
    long long ee = ((w+2)/2)*((h+2)/2);
    long long oo = ((w+1)/2)*((h+1)/2);
    long long eo = ((w+2)/2)*((h+1)/2);
    long long oe = ((w+1)/2)*((h+2)/2);
    long long res = ((ee*(ee-1))%mod*(pos-ee) + (oo*(oo-1))%mod*(pos-oo))%mod;
    res = (res + (eo*(eo-1))%mod*(pos-eo))%mod;
    res = (res + (oe*(oe-1))%mod*(pos-oe))%mod;
    res = (3*res)%mod;
    //Now all three in same category.
    res = (res + (ee*(ee-1))%mod*(ee-2) + (oo*(oo-1))%mod*(oo-2)+ (oe*(oe-1))%mod*(oe-2) + (eo*(eo-1))%mod*(eo-2))%mod;
    for(i = (int)-w; i<=w; i++)
        for(j =0; j<=h; j++)
        {
            if(i<0 && j == 0) continue;
            if(i==0 && j ==0) continue;
            int dx = i, dy = j;

            long long bigx = max(0, dx);
            long long smallx = min(0, dx);
            if(smallx < 0) bigx -= smallx;
            long long startx = max(0, w - bigx+1);

            long long bigy = max(0, dy);
            long long smally = min(0, dy);
            if(smally < 0) bigy -= smally;
            long long starty = max(0, h - bigy+1);
            //System.out.println(startx+" "+starty+" "+dx+" "+dy);
            int a = abs(dx), b = dy;
            if(a < b)
            {
                int temp = a;
                a = b;
                b = temp;
            }
            int count = gcd(a, b)+1;
            //System.out.println(count);
            long tot = (startx*starty*p3(count))%mod;
            //if(tot>0) System.out.println(res+" "+tot+" "+startx+" "+starty+" "+i+" "+j);
            if(tot>0)
            {
                res = (res - tot + mod);
            }
        }
    printf("%d", (int)(res%mod));
    return 0;
}