import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    int a = 0, b = n-1;
    int turn = 0;
    int[] res = new int[2];
    for(int i = 0; i<n; i++)
    {
        if(data[a] > data[b])
        {
            res[turn] += data[a];
            a++;
        }
        else
        {
            res[turn] += data[b];
            b--;
        }
        turn = 1-turn;
    }
    System.out.println(res[0]+" "+res[1]);
}
}