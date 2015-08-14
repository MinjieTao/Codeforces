import java.util.Scanner;


public class Tram {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i<n; i++)
        {
            a[i] = input.nextInt();
            b[i] = input.nextInt();
            
        }
        int max = 0;
        int count = 0;
        for(int i = 0; i<n; i++)
        {
            count -= a[i];
            count+= b[i];
            if(count > max)
                max = count;
        }
        System.out.println(max);
        

    }

}