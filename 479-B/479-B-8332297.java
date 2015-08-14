import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    int[] as = new int[k], bs = new int[k];
    int i = 0;
    for(i = 0; i<k; i++)
    {
        as[i] = getMax(data);
        bs[i] = getMin(data);
        if(data[as[i]] == data[bs[i]]) break;
        data[as[i]]--;
        data[bs[i]]++;
    }
    System.out.println((data[getMax(data)] - data[getMin(data)])+" "+i);
    for(int j = 0; j<i; j++) System.out.println((as[j]+1)+" "+(bs[j]+1));
}
static int getMin(int[] A)
{
    int min = 100000;
    int res = -1;
    for(int i = 0; i<A.length; i++)
    {
        if(A[i] < min)
        {
            res = i;
            min = A[i];
        }
    }
    return res;
}
static int getMax(int[] A)
{
    int max = -1;
    int res = -1;
    for(int i = 0; i<A.length; i++)
    {
        if(A[i] > max)
        {
            res = i;
            max = A[i];
        }
    }
    return res;
}
}