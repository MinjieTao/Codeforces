import java.util.Scanner;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] perim = new int[n];
    int[] height = new int[n];
    for(int i = 0; i<n; i++)
    {
        perim[i] += 2*input.nextInt();
        perim[i] += 2*input.nextInt();
        height[i] = input.nextInt();
    }
    int m = input.nextInt();
    int[] length = new int[m];
    int[] width = new int[m];
    int[] price = new int[m];
    for(int i = 0; i<m; i++)
    {
        length[i] = input.nextInt();
        width[i] = input.nextInt();
        price[i] = input.nextInt();
    }
    int total = 0;
    for(int i = 0; i < n; i++)
    {
        int min = 1000000000;
        int mindex = 0;
        for(int j = 0; j<m; j++)
        {
            int area = length[j];
            if(area < height[i])
                continue;
            int per = area/height[i];
            per *= width[j];
            //System.out.println(per);
            int cost = perim[i]/per * price[j];
            if(perim[i] % per != 0)
                cost += price[j];
            if(cost < min)
            {
                min = cost;
                mindex = j;
            }
            //System.out.println(cost);
        }
        total += min;
    }
    System.out.println(total);
}
}