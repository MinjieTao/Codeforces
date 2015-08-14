import java.util.*;
import java.io.*;
public class m{
public static void main(String[]a) throws IOException
{
    Scanner input = new Scanner(new File("input.txt"));
    PrintWriter out = new PrintWriter(new File("output.txt"));
    int T = input.nextInt();
    for(int t=0; t<T; t++)out.println(1-input.nextInt()%2);
    out.close();
}
}