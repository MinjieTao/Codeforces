import java.util.*;
import java.io.*;
public class j {
public static void main(String[] args) throws Exception
{
    Scanner input = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    out.println((long)6*n*n-6*n+1);
    out.close();
}
}