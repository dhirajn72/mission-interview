import java.io.*;
public class InfiniteLoops{
    public static void main(String[] args) throws IOException{
        Runtime runtime=Runtime.getRuntime();
		Process exec = runtime.exec("ps -ef");
		InputStream inputStream=exec.getInputStream();
		OutputStream outputStream=System.out;
		byte[] bytes=new byte[1024];
		while (true) {
			//outputStream.write(bytes);
			outputStream.write(inputStream.read());
		}
    }
}
