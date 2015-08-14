import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    Scanner input = new Scanner(new File("input.txt"));
    PrintWriter out = new PrintWriter(new File("output.txt"));
    int a = input.nextInt(), b = input.nextInt();
    int i;
    for(i = 0; i<Math.min(a, b); i++)
        out.print(a > b ? "BG" : "GB");
    a -= i;
    b -= i;
    for(i = 0; i<a; i++)
        out.print("B");
    for(i = 0; i<b; i++)
        out.print("G");
    out.close();
}
}