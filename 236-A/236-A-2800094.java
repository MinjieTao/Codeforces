import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        char[] data = input.next().toCharArray();
        Arrays.sort(data);
        int count = 1;
        for(int i = 1; i<data.length; i++)
            if(data[i] != data[i-1])
                count++;
        System.out.println(count%2 == 0 ? "CHAT WITH HER!" : "IGNORE HIM!");
    }
}