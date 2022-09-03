import java.io.*;
import java.util.*;
import java.nio.file.*;
public class StringInternMemoryLeak{
    public static void main(String[] args) throws IOException{
        Path path=Paths.get("delete-me-file");
        List<String> read=Files.readAllLines(path);
        while(true){
            for(String s:read){
                String str=s.intern();
                System.out.println(str);
            }
        }
    }
}
