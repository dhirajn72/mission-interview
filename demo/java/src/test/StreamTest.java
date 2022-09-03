package test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamTest {
	public static void main(String[] args){
		IntStream.iterate(2, e -> e + 1).limit(50).filter(e -> e % 2 != 0).forEach(System.out::println);
		Arrays.stream(new String[]{"as","asx","xdf","er","x", "vfd","cdv","ght"})
				.filter(str -> str.contains("x") || str.contains("v"))
				.forEach(System.out::println);
	}
}
