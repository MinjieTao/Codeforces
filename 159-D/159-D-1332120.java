import java.util.*;
public class d {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String s = input.next();
    char[] array = s.toCharArray();
    boolean[][] precomp = new boolean[2002][2002];
    //create array pf whether or not each is a palindrome
    for(int start = 0; start <array.length; start++)
    {
        //odd
        for(int length = 0; length <= array.length/2+1; length++)
        {
            if(start + length >= array.length || start - length < 0)
                break;
            if(array[start+length] == array[start-length])
                precomp[start+1][2*length+1] = true;
            else
                break;
        }
        //even
        for(int length = 0; length <= array.length/2+1; length++)
        {
            if(start + length + 1 >= array.length || start - length < 0)
                break;
            if(array[start+length+1] == array[start-length])
                precomp[start+1][2*length+2] = true;
            else
                break;
        }
    }
//  for(int i =0; i<=7; i++)
//  {
//      for(int j = 0; j<=7; j++)
//          System.out.print(precomp[i][j]+ " ");
//      System.out.println();
//  }
    int[] fromStart = new int[2002];
    int[] fromEnd = new int[2002];
    //from start
    fromStart[0] = 0;
    for(int i = 1; i<=array.length; i++)
    {
        //fromStart[i] = fromStart[i-1];
        for(int j = 1; j<=i; j++)
        {
            if(precomp[i-(j)/2][j])
                fromStart[i]++;
        }
    }
//  for(int i = 0; i<10; i++)
//      System.out.println(fromStart[i]);
//  System.out.println();
    //from end
    fromEnd[array.length+1] = 0;
    for(int i = array.length; i> 0; i--)
    {
        fromEnd[i] = fromEnd[i+1];
        for(int j = 1; j<=array.length-i+1; j++)
        {
            if(precomp[i+(j-1)/2][j])
                fromEnd[i]++;
        }
    }
//  for(int i = 0; i<10; i++)
//      System.out.println(fromEnd[i]);
//  System.out.println();
    long count = 0;
    for(int i = 1; i<=array.length; i++)
    {
        count += fromStart[i] * fromEnd[i+1];
    }
    System.out.println(count);
}
}