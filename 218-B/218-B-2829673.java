import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        int[] data = new int[m], data2 = new int[m];
        for(int i =0; i<m; i++)
        {
            data[i] = input.nextInt();
            data2[i] = data[i];
        }
        Arrays.sort(data);
        Arrays.sort(data2);
        //find min
        int at = 0, min = 0, max = 0, needed = n;
        while(needed > 0)
        {
            min += data[at];
            data[at]--;
            needed--;
            if(data[at] == 0)
                at++;
        }
        needed = n;
        while(needed > 0)
        {
            needed--;
            max += data2[m-1];
            data2[m-1]--;
            Arrays.sort(data2);
        }
        System.out.println(max + " " + min);
    }
}