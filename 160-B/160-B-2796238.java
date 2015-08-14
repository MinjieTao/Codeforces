import java.util.*;
public class UnluckyTicket {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int n= input.nextInt();
        int[] first = new int[n], second = new int[n];
        String s = input.next();
        for(int i = 0; i<n; i++)
        {
            first[i] = s.charAt(i);
            second[i] = s.charAt(i + n);
        }
        Arrays.sort(first);
        Arrays.sort(second);
        boolean allGreater = true, allSmaller = true;
        for(int i = 0; i<n; i++)
        {
            allGreater &= first[i] > second[i];
            allSmaller &= first[i] < second[i];
        }
        System.out.println(allGreater || allSmaller ? "YES" : "NO");
}
}