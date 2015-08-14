import java.util.*;
public class a {
public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    String[] data = new String[]
            {
                "+------------------------+",
                "|#.#.#.#.#.#.#.#.#.#.#.|D|)",
                "|#.#.#.#.#.#.#.#.#.#.#.|.|",
                "|#.......................|",
                "|#.#.#.#.#.#.#.#.#.#.#.|.|)",
                "+------------------------+"
            };
    int n = input.nextInt();
    for(int x = 0; x<n; x++)
    {
        boolean found = false;
        for(int j = 0; j<data[0].length(); j++)
            for(int i = 0; i<data.length && !found; i++)
            {
                if(data[i].charAt(j) == '#')
                {
                    data[i] = data[i].substring(0, j)+"O"+data[i].substring(j+1);
                    found = true;
                }
            }
    }
    for(String s: data) System.out.println(s);
}
}