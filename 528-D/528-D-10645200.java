import java.util.*;
import java.io.*;
public class d {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt(), m = input.nextInt(), k = input.nextInt();
    String s = input.next(), t = input.next();
    String alpha = "ACGT";
    int[] matches = new int[n];
    for(char c : alpha.toCharArray())
    {
        int[] delta = new int[n+1];
        for(int i = 0; i<n; i++)
        {
            if(s.charAt(i) == c)
            {
                delta[Math.max(0, i-k)]++;
                delta[Math.min(n, i+k+1)]--;
            }
        }
        long[] poly = new long[n];
        int csum = 0;
        for(int i = 0; i<n; i++)
        {
            csum += delta[i];
            if(csum > 0) poly[i] = 1;
        }
        long[] other = new long[m];
        for(int i = 0; i<m; i++)
        {
            if(t.charAt(i) == c)
                other[m-1-i] = 1;
        }
        long[] prod = multiply(poly, other);
        for(int i = 0; i<n; i++) matches[i] += prod[n+m-2-i];
        //System.out.println(Arrays.toString(matches));
    }
    int count = 0;
    for(int i = 0; i<n; i++) if(matches[i] >= m) count++;
    System.out.println(count);
}
public static void fft(double[] a, double[] b, boolean invert) {
    int count = a.length;
    for (int i = 1, j = 0; i < count; i++) {
        int bit = count >> 1;
        for (; j >= bit; bit >>= 1) j -= bit;
        j += bit;
        if (i < j) {
            double temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            temp = b[i];
            b[i] = b[j];
            b[j] = temp;
        }
    }
    for (int len = 2; len <= count; len <<= 1) {
        int halfLen = len >> 1;
        double angle = 2 * Math.PI / len;
        if (invert) angle = -angle;
        double wLenA = Math.cos(angle), wLenB = Math.sin(angle);
        for (int i = 0; i < count; i += len) {
            double wA = 1, wB = 0;
            for (int j = 0; j < halfLen; j++) {
                double uA = a[i + j], uB = b[i + j];
                double vA = a[i + j + halfLen] * wA - b[i + j + halfLen] * wB;
                double vB = a[i + j + halfLen] * wB + b[i + j + halfLen] * wA;
                a[i + j] = uA + vA;
                b[i + j] = uB + vB;
                a[i + j + halfLen] = uA - vA;
                b[i + j + halfLen] = uB - vB;
                double nextWA = wA * wLenA - wB * wLenB;
                wB = wA * wLenB + wB * wLenA;
                wA = nextWA;
            }
        }
    }
    if (invert) {
        for (int i = 0; i < count; i++) {
            a[i] /= count;
            b[i] /= count;
        }
    }
}

public static long[] multiply(long[] a, long[] b) {
    int resultSize = Integer.highestOneBit(Math.max(a.length, b.length) - 1) << 2;
    resultSize = Math.max(resultSize, 1);
    double[] aReal = new double[resultSize], aImaginary = new double[resultSize];
    double[] bReal = new double[resultSize], bImaginary = new double[resultSize];
    for (int i = 0; i < a.length; i++) aReal[i] = a[i];
    for (int i = 0; i < b.length; i++) bReal[i] = b[i];
    fft(aReal, aImaginary, false);
    if (a == b) 
    {
        System.arraycopy(aReal, 0, bReal, 0, aReal.length);
        System.arraycopy(aImaginary, 0, bImaginary, 0, aImaginary.length);
    } 
    else fft(bReal, bImaginary, false);
    for (int i = 0; i < resultSize; i++) {
        double real = aReal[i] * bReal[i] - aImaginary[i] * bImaginary[i];
        aImaginary[i] = aImaginary[i] * bReal[i] + bImaginary[i] * aReal[i];
        aReal[i] = real;
    }
    fft(aReal, aImaginary, true);
    long[] result = new long[resultSize];
    for (int i = 0; i < resultSize; i++) result[i] = Math.round(aReal[i]);
    return result;
}
public static class input {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}
}