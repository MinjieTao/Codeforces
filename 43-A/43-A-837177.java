import java.util.*;
public class Football43A {

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String[] s = new String[n];
        for(int i = 0; i<n; i++)
            s[i] = input.next();
        Arrays.sort(s);
        int max = 0;
        String best = "";
        for(int i = 0; i<n; i++)
        {
            String str = s[i];
            int count = 1;

            while(i <n-1 && s[i+1].equals(str))
            {
                i++;
                count++;
            }
            if(count > max)
            {
                max = count;
                best = str;
            }
        }
        System.out.println(best);
    }

}