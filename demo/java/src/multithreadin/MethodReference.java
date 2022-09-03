package multithreadin;

import javafx.scene.layout.Priority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MethodReference {
	public static void main(String[] args){
		Testable test = (str)-> { return str;};
		System.out.println(test.test("string is"));

		Testable testable = Testable1::test;
		System.out.println(testable.test("string"));
		System.out.println("-------");
		List<Integer> list = Arrays.asList(1,2,3,3,4);
		list.forEach((e) -> System.out.println(e));
		System.out.println("-----------");
		list.forEach(System.out::println);

		Map<Integer, Integer> map =  new HashMap<>();
		map.put(3, 2);
		map.put(1, 1);
		map.put(6, 8);
		map.put(2, 3);
		System.out.println("Before sort : "+ map);
		map = map.entrySet().stream().sorted((a, b) -> a.getValue().compareTo(b.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (key, val) -> key, LinkedHashMap::new));
		System.out.println(map);
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		/*for(int key : map.keySet()){
			pq.add(new int[]{key, map.get(key)});
		}
		Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
		while(!pq.isEmpty()){
			int[] keyval = pq.remove();
			linkedHashMap.put(keyval[0], keyval[1]);
		}
		System.out.println(linkedHashMap);*/

	}
	static void method(){
		System.out.println("method");
		//return "method";
	}
	interface Testable{
		String test(String str);
	}
	interface Testable1{
		static String test(String str){
			return str;
		}
		default String test2() {
			return "default";
		}
		String test3();
	}
}

