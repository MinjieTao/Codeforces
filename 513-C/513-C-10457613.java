import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] ls = new int[n], rs = new int[n];
    for(int i = 0; i<n; i++)
    {
        ls[i] = input.nextInt();
        rs[i] = input.nextInt();
    }
    double res = 0;
    double tot = 0;
    for(int price = 1; price <= 10000; price++)
    {
        for(int first = 0; first < n; first++)
            for(int second = 0; second < n; second++)
            {
                if(first == second) continue;
                if(ls[second] > price || rs[second] < price) continue;
                if(rs[first] < price) continue;
                double prob = Math.max(0,  (rs[first] - Math.max(first > second ? price : price + 1, ls[first]) + 1) / (rs[first] - ls[first] + 1.));
                //System.out.println(prob);
                for(int i = 0; i<n; i++)
                {
                    if(i == first || i == second) continue;
                    if(ls[i] > price) prob = 0;
                    prob *= Math.max(0, (Math.min(rs[i], i > second ? price - 1 : price) - ls[i] + 1) / (rs[i] - ls[i] + 1.));
                }
                prob /= (rs[second] - ls[second] + 1.0);
                tot += prob;
                //if(prob > 0) System.out.println(price+" "+first+" "+second+" "+prob);
                prob *= price;
                res += prob;
            }

    }
    //System.out.println(tot);
    System.out.println(res);
}
}