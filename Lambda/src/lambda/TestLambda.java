package lambda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TestLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable r1 = ()->System.out.println("Hello Word");
		List<Person> list = new ArrayList<>();
        list.add(new Person(3));
        list.add(new Person(1));
        list.add(new Person(8));
        list.add(new Person(7));
        list.add(new Person(5));
        
        //2.Lambda使用 - 升序
        //list.sort((o1, o2) ->  o1.getHeight().compareTo(o2.getHeight()));
        //降序
        //list.sort((o1, o2) ->  o2.getHeight().compareTo(o1.getHeight()));
        //升序
        list.sort(Comparator.comparingInt(Person::getHeight));
        //降序
        list.sort(Comparator.comparingInt(Person::getHeight).reversed());
        for (Person person : list) {
            System.out.println(person.getHeight());
        }
        
        List<People> list2 = new ArrayList<>();
        People pl = new People();
        pl.setAge(23);
        pl.setName("zildingyi");
        list2.add(pl);
        list2.add(new People("zs", 22));
        list2.add(new People("ls", 27));
        list2.add(new People("ww", 29));
        list2.add(new People("zl", 21));
        List<People> search = new ArrayList<>();
        // 2.Lambda使用
        // Stream是Java 8 提供的高效操作集合类（Collection）数据的API。
        search = list2.stream().filter((People people) -> people.getAge() >= 20 && people.getAge() <= 25).collect(Collectors.toList());

        // 打印结果
        for (People people : search) {
            System.out.println(people.getName() + "-" + people.getAge());
        }
        //map转list
        Map<String,Integer> map = new HashMap<>();
        map.put("height", 25);
        map.put("s", 21);
        map.put("size", 1);
        map.put("wig", 10);
        Set<String> keySet = map.keySet();
        Collection<Integer> values = map.values();
        System.out.println(keySet.size());
        System.out.println(keySet);
        System.out.println("values"+values);
//        List<Person> list3 = map.entrySet().stream().sorted(Comparator.comparing(e -> e.getKey()))
//                .map(e -> new Person(e.getKey(), e.getValue())).collect(Collectors.toList());
        
        List<Integer> list4 = map.values().stream().filter(predicate-> predicate>=20 && predicate<=25).collect(Collectors.toList());
        list4.forEach(System.out::println);
        
        Map<Integer,String> map2 = new HashMap<>();
        map2.put(1, "apple");
        map2.put(2, "orange");
        map2.put(3, "banana");
        map2.put(4, "watermelon");
        List<Integer> resultSortedKey = new ArrayList<>();
        List<String> resultValues = map2.entrySet().stream()
                //sort a Map by key and stored in resultSortedKey
                .sorted(Map.Entry.<Integer, String>comparingByKey().reversed())
                .peek(e -> resultSortedKey.add(e.getKey()))
                .map(x -> x.getValue())
                // filter banana and return it to resultValues
                .filter(x -> !"banana".equalsIgnoreCase(x))
                .collect(Collectors.toList());
        resultSortedKey.forEach(System.out::println);
        resultValues.forEach(System.out::println);

        
        
	}

}
