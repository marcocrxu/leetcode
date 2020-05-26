package IO;

import javax.print.DocFlavor;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class StreamTest {
    static FileReader fileReader;

    public static void main(String[] args) throws IOException {
        new Thread(()->{
            for(int i=0;i<10;i++){
                System.out.println(i);
            }
        }).start();
        Map<Integer,Integer> map=new HashMap<>();
        List<Map.Entry<Integer, Integer>> list=new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getKey));
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        System.out.println(stack.pop());
        try {
            fileReader = new FileReader("testReader1.txt");
            char[] c = new char[100];
            int x = fileReader.read();
            System.out.println(x);
        }catch (FileNotFoundException e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
