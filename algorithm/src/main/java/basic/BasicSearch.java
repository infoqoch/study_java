package basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class BasicSearch {

    private static List<Integer> init(int size, int max, int target) {
        Set<Integer> sets = randomSets(size-1, max);
        sets.add(target);
        List<Integer> result = new ArrayList<>(sets);
        Collections.shuffle(result);
        return result;
    }

    private static Set<Integer> randomSets(int size, int max) {
        Set<Integer> sets = new HashSet<>();
        do{
            int random = (int) (Math.random() * max);
            sets.add(random);
        } while(sets.size()<size);

        return sets;
    }

    @Test
    void 순차탐색(){
        // given
        final int target = 7653;
        final List<Integer> list = init(100, 100000, target);

        // when
        final int idx = linearSearch(list, target);

        // then
        Assertions.assertThat(list.get(idx)).isEqualTo(target);
    }

    private static int linearSearch(List<Integer> list, int target) {
        for(int i=0; i<list.size(); i++) {
            if(list.get(i)==target) {
                return i;
            }
        }
        return -1;
    }

    @Test
    void 이진탐색(){
        // given
        final int target = 7653;
        final List<Integer> list = init(100, 100000, target);
        list.sort(INTEGER_ASC);

        // when
        final int idx = binarySearch(list, target);

        // then
        Assertions.assertThat(list.get(idx)).isEqualTo(target);
    }
    public static final Comparator<Integer> INTEGER_ASC = new IntegerDescOrderComparator();

    static class IntegerDescOrderComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1>o2? 1 :
                    o1<o2? -1 : 0;
        }
    }

    private static int binarySearch(List<Integer> listOrdered, int target) {
        int front = 0;
        int rear = listOrdered.size()-1;

        do {
            int mid = (rear+front)/2;
            int value =  listOrdered.get(mid);
            if(value==target) {
                return mid;
            }else if(target>value) {
//                front = mid;
                front = mid + 1;
            }else {
//                rear = mid;
                rear = mid - 1;
            }

        }while(front<=rear);

        return -1;
    }

    @Test
    void 이진탐색_순차탐색_비교_정렬포함(){
        final List<Integer> list = init(1000, 1000000, 50000);
        
        final long start2 = System.currentTimeMillis();
        for(int i=0; i<list.size(); i++){
            int target = list.get(i);
            final List<Integer> list2 = init(10000, 1000000, target);
            Assertions.assertThat(list2.get(linearSearch(list2, target))).isEqualTo(target);
        }
        System.out.println(System.currentTimeMillis()-start2);

        final long start1 = System.currentTimeMillis();
        for(int i=0; i<list.size(); i++){
            int target = list.get(i);
            final List<Integer> list2 = init(10000, 1000000, target);
            list2.sort(INTEGER_ASC);
            Assertions.assertThat(list2.get(binarySearch(list2, target))).isEqualTo(target);
        }
        System.out.println(System.currentTimeMillis()-start1);
    }


    @Test
    void 이진탐색_순차탐색_비교_정렬미포함(){
        final Map<Integer, List<Integer>> orderedMap = getOrderedList(10000, 1000000);
        final Set<Integer> keys = orderedMap.keySet();

        final Iterator<Integer> iterator = keys.iterator();

        final long start2 = System.currentTimeMillis();
        while(iterator.hasNext()){
            Integer target = iterator.next();
            final List<Integer> list = orderedMap.get(target);
            final int index = binarySearch(list, target);
            Assertions.assertThat(list.get(index)).isEqualTo(target);
        }
        System.out.println(System.currentTimeMillis()-start2);


        final Iterator<Integer> iterator2 = keys.iterator();

        final long start1 = System.currentTimeMillis();
        while(iterator2.hasNext()){
            Integer target = iterator2.next();
            final List<Integer> list = orderedMap.get(target);
            final int index = linearSearch(list, target);
            Assertions.assertThat(list.get(index)).isEqualTo(target);
        }
        System.out.println(System.currentTimeMillis()-start1);


    }

    private Map<Integer, List<Integer>> getOrderedList(int size, int max){
        final Map<Integer, List<Integer>> result = new HashMap();
        for(int i=0; i<size; i++){
            int target = (int) (Math.random()*max);
            final List<Integer> list = init(size, max, target);
            list.sort(INTEGER_ASC);
            result.put(target, list);
        }
        return result;

    }

}
