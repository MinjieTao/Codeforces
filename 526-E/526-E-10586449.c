#include <stdio.h>
static int jump[1000001];
static int add[1000001];
void makeJump(int* data, int n, long long k)
{
    long long csum [2*n];
    csum[0] = data[0];
    int i, left;
    for(i = 1; i<2*n; i++) csum[i] = csum[i-1] + data[i%n];
    int right = 2*n - 1;
    //System.out.println(Arrays.toString(csum)+" "+k);
    for(left = n-1; left>= 0; left--)
    {
        while(csum[right] - csum[left] > k) right--;
        //System.out.println(left+" "+right);
        jump[left] = right%n;
        add[left] = (right - left + n)%n;
    }
}
int go2(int* data, int n, int start)
{
    int at = start;
    int steps = 0;
    int count = 0;
    while(1)
    {
        steps++;
        //int next = jump[at];
        //if(add >= n) add -= n;
        count += add[at];
        if(count >= n) break;
        at = jump[at];
    }
    return steps;
}
int go(int* data, int n, long long k)
{
    
    makeJump(data, n, k);
//  if(n <= 1000)
//  {
//      int res = go(data, n, 0);
//      for(int i = 1; i<n; i++) res = Math.min(res, go(data, n, i));
//  }
    //System.out.println(Arrays.toString(jump));
    //ArrayList<Integer> stops = new ArrayList<Integer>();
    int at = 0;
    //stops.add(0);
    int steps = 0;
    int count = 0;
    int stops[n];
    int size = 0;
    stops[size++] = 0;
    while(1)
    {
        int next = at;
        long long left = k;
        steps++;
        while(left >= data[next])
        {
            left -= data[next];
            next = (next+1)%n;
            if(steps == 1 && next == 0) return 1;
            count++;
            if(count > 2*n) break;
            //if(next == n) break;
        }
        //System.out.println(next+" "+count);
        if(left == k) return -1;
        if(count >= n)
        {
            //at = 0;
            at = next;
            //stops.add(at);
            stops[size++] = at;
            break;
        }
        stops[size++] = next;
        at = next;
    }
    int min = 0;
    int i;
    for(i = 1; i<size - 1; i++)
    {
        if((stops[i+1] - stops[i] + n)%n < (stops[min+1] - stops[min] + n)%n)
            min = i;
    }
    if(steps == 1) return steps;
    i = stops[min];
    i = (i+n-1)%n;
    int cur = steps;
    while(1)
    {
        int next = go2(data, n, i);
        steps = next < steps ? next  : steps;
        if(steps < cur) return steps;
        if(i == (1+stops[min+1])%n) break;
        i++;
        if(i == n) i = 0;
    }
    return steps;
}
int main(void)
{
    int n, s;
    scanf("%d %d", &n, &s);
    int data[n];
    int i;
    for(i = 0; i<n; i++) scanf("%d", &data[i]);
    for(i = 0; i<s; i++)
    {
        long long x;
        scanf("%I64d", &x);
        int res = go(data, n, x);
        printf("%d\n", res);
    }
    return 0;
}