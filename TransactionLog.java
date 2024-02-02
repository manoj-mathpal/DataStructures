package amazonPrep;

import java.util.*;

public class TransactionLog {
    public static List<String> processLogs(List<String> logs, int threshold) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < logs.size(); i++) {
            String[] arr = logs.get(i).split(" ");
            map.put(arr[0], map.getOrDefault(arr[0], 0) + 1);
            if (!arr[0].equals(arr[1])) {
                map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
            }
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= threshold) result.add(entry.getKey().toString());
        }
        return result;
    }

    public void testStream() {

    }

    public static void main(String[] args) {
//        List<String> arr = Arrays.asList("345366 89921 45", "029323 38239 23", "38239 345366 15", "029323 38239 77", "345366 38239 23", "029323 345366 13", "38239 38239 23");
//        TransactionLog obj = new TransactionLog();
//        obj.processLogs(arr, 2);

//        Stream.iterate(1, element->element+1).filter(element->element%5==0)
//                .limit(5)
//                .forEach(System.out::println);
//    }

//        List<Integer> number = Arrays.asList(2, 3, 4, 5);
//        List<Integer> square = number.stream().map(x -> x + x).filter(s -> s<10).collect(Collectors.toList());
//        System.out.println(square.toString());

//
//        List<Integer> number = Arrays.asList(2,3,4,5);
//        int even = number.stream().filter(x->x%2==0).reduce(0,(ans, i)-> ans+i);
//        System.out.println(even);


//        List<Integer> list = IntStream.rangeClosed(1, 4)
//                .mapToObj(Integer::new)
//                .collect(Collectors.); //[Item [i=1], Item [i=2], Item [i=3], Item [i=4]]
//
//        Map<String, Item> map =
//                list.stream().collect(Collectors.toMap(Item::getKey, item -> item));
//
//        map.forEach((k, v) -> System.out.println(k + " => " + v));

    }
}