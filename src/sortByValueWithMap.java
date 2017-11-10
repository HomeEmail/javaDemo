import java.util.HashMap;
import java.util.Map;
import java.util.*;

/**
 * Created by ivan on 17/11/11.
 * 这个demo解决：如何让HashMap来根据值来排序，如何使用泛型方法
 */
public class sortByValueWithMap {
    public static void main(String[] args){
        HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
        hashMap.put("a",10);
        hashMap.put("b",30);
        hashMap.put("c",50);
        hashMap.put("d",40);
        hashMap.put("e",20);
        System.out.println(hashMap);

        Map<String,Integer> map=sortByValue(hashMap);//排序函数要求返回的是Map类型
        
        System.out.println(hashMap);
        System.out.println(map);
        
    }
    public static <K,V extends Comparable<? super V>> Map<K,V> sortByValue(Map<K,V> map){
        
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
                return (e1.getValue()).compareTo(e2.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
