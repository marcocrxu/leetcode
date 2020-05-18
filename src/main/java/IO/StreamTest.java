package IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StreamTest {
    static FileReader fileReader;

    public static void main(String[] args) throws IOException {
        fileReader = new FileReader("testReader.txt");
        if (fileReader == null) {
            System.out.println("file not exist");
            return;
        }
        char[] c=new char[100];
        int x=fileReader.read();
        System.out.println(x);
    }
}
