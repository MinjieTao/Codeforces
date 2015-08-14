import java.util.*;
public class RoomLeader {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int max = -1000000000;
        String maxString = "";
        for(int i = 0; i<num; i++)
        {
            String s = input.next();
            int score = 100*input.nextInt() - 50*input.nextInt() + input.nextInt() + input.nextInt() + input.nextInt() + input.nextInt() + input.nextInt();
            if(score >max)
            {
                max = score;
                maxString = s;
            }
        }
        System.out.println(maxString);
    }

}