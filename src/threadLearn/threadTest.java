package threadLearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class threadTest {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int limit = Integer.parseInt(line);

            ZeroEvenOdd solution=new ZeroEvenOdd(limit);

        }

    }
}
