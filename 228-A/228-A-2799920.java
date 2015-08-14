import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int[] data = new int[4];
        for(int i = 0; i<4; i++) data[i] = input.nextInt();
        Arrays.sort(data);
        int res = 0;
        for(int i = 0; i<3; i++)
            if(data[i] == data[i+1])
                res++;
        System.out.println(res);
    }
}