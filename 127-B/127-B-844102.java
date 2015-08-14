import java.util.Scanner;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] len = new int[n];
    for(int i = 0; i<n; i++)
        len[i] = input.nextInt();
    int pairs = 0;
    for(int i = 0; i<n; i++)
    {
        for(int j = 0; j< n; j++)
        {
            if(len[i] >0 && len[i] == len[j] && i!=j)
            {
                pairs++;
                len[i] = -1;
                len[j] = -1;

            }
        }
    }
    System.out.println(pairs/2);
}
}