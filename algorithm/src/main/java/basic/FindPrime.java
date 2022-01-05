package basic;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class FindPrime {
    List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997, 1009, 1013, 1019, 1021, 1031, 1033, 1039, 1049, 1051, 1061, 1063, 1069, 1087, 1091, 1093, 1097, 1103, 1109, 1117, 1123, 1129, 1151, 1153, 1163, 1171, 1181, 1187, 1193, 1201, 1213, 1217, 1223, 1229, 1231, 1237, 1249, 1259, 1277, 1279, 1283, 1289, 1291, 1297, 1301, 1303, 1307, 1319, 1321, 1327, 1361, 1367, 1373, 1381, 1399, 1409, 1423, 1427, 1429, 1433, 1439, 1447, 1451, 1453, 1459, 1471, 1481, 1483, 1487, 1489, 1493, 1499, 1511, 1523, 1531, 1543, 1549, 1553, 1559, 1567, 1571, 1579, 1583, 1597);

    @Test
    void pixedPrimeSelectTest(){
        List<PrimeSample> list = new ArrayList<>();
        list.add(PrimeSample.builder().from(5).isFromPrime(true).to(53).isToPrime(true).build());
        list.add(PrimeSample.builder().from(5).isFromPrime(true).to(54).isToPrime(false).expectTo(53).build());
        list.add(PrimeSample.builder().from(6).isFromPrime(false).expectFrom(7).to(53).isToPrime(true).build());
        list.add(PrimeSample.builder().from(6).isFromPrime(false).expectFrom(7).to(54).isToPrime(false).expectTo(53).build());

        for(int i=0; i<list.size(); i++){
            final PrimeSample primeSample = list.get(i);
            final List<Integer> primes = fixedPrimes(primeSample.getFrom(), primeSample.getTo());
            if(primeSample.isFromPrime()){
                Assertions.assertThat(primes.get(0)).isEqualTo(primeSample.getFrom());
            }else{
                Assertions.assertThat(primes.get(0)).isEqualTo(primeSample.getExpectFrom());
            }

            if(primeSample.isToPrime()){
                Assertions.assertThat(primes.get(primes.size()-1)).isEqualTo(primeSample.getTo());
            }else{
                Assertions.assertThat(primes.get(primes.size()-1)).isEqualTo(primeSample.getExpectTo());
            }
        }
    }

    private List<Integer> fixedPrimes(int start) {
        int indexOfStart = 0;
        for(int i=0; i<primes.size(); i++){
            if(primes.get(i)>= start){
                indexOfStart = i;
                break;
            }
        }
        return primes.subList(indexOfStart, primes.size());
    }

    private List<Integer> fixedPrimes(int start, int end) {
        int indexOfStart = 0;
        boolean isFoundFirstIdx = false;
        int indexOfEnd = 0;
        for(int i=0; i<primes.size(); i++){
            if(!isFoundFirstIdx&&primes.get(i)>= start){
                isFoundFirstIdx = true;
                indexOfStart = i;
            }
            if(primes.get(i)== end){
                indexOfEnd = i;
                break;
            }
            if(primes.get(i)> end){
                indexOfEnd = i-1;
                break;
            }
        }

        return primes.subList(indexOfStart, indexOfEnd+1);
    }

    @Test
    void 소수_구하기V1(){
        // given
        int start = 2;
        int end = 1597;

        //when
        List<Integer> result = getPrimesV1(start, end);

        // then
        Assertions.assertThat(result).isEqualTo(primes);
    }

    @Test
    void 소수_구하기V1_startIdx(){
        // given
        int start = 50;
        int end = 1597;

        // when
        primes = fixedPrimes(start);
        List<Integer> result = getPrimesV1(start, end);

        // then
        Assertions.assertThat(result).isEqualTo(primes);
    }

    private List<Integer> getPrimesV1(int start, int end) {
        int idxOfStart = 0;
        boolean isFoundIdxOfStart = false;
        List<Integer> list = new ArrayList<>();
        for(int i = 2; i<= end; i++){
            boolean isPrime = true;
            for(int j=2; j<i; j++){
                if(i%j==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                list.add(i);
                if(!isFoundIdxOfStart&&i>= start){
                    isFoundIdxOfStart = true;
                    idxOfStart = list.size()-1;
                }
            }
        }
        return list.subList(idxOfStart, list.size());
    }

    @Test
    void 소수_구하기V2(){
        // given
        int start = 50;
        int end = 1597;

        // when

        // 모든 숫자로 나눌 필요가 없이, 이전에 소수로 판별된 값으로 나누면 된다.
        List<Integer> list = getPrimesV2(start, end);

        final List<Integer> subPrimes = fixedPrimes(start,end);


        // then
        Assertions.assertThat(list).isEqualTo(subPrimes);

    }

    private List<Integer> getPrimesV2(int start, int end) {
        int idxOfStart = 0;
        boolean isFoundIdxOfStart = false;
        List<Integer> list = new ArrayList<>();
        list.add(2);
        for(int i = 3; i<= end; i++){
            boolean isPrime = true;
            for(int j=0; j<list.size(); j++){
                if(i%list.get(j)==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                list.add(i);
                if(!isFoundIdxOfStart&&i>= start){
                    isFoundIdxOfStart = true;
                    idxOfStart = list.size()-1;
                }
            }
        }
        list = list.subList(idxOfStart, primes.size());
        return list;
    }

    @Test
    void 소수_구하기V3(){
        // given
        int start = 50;
        int end = 1597;

        // when
        // 제곱근 미만으로 구한다.
        List<Integer> list = getPrimesV3(start, end);

        final List<Integer> subPrimes = fixedPrimes(start);

        // then
        Assertions.assertThat(list).isEqualTo(subPrimes);

    }

    @Test
    void 소수_구하기V3_테스트2(){
        List<PrimeSample> list = new ArrayList<>();
        list.add(PrimeSample.builder().from(2).isFromPrime(true).to(2).isToPrime(true).expectSize(1).build());
        list.add(PrimeSample.builder().from(2).isFromPrime(true).to(3).isToPrime(true).expectSize(2).build());
        list.add(PrimeSample.builder().from(5).isFromPrime(true).to(53).isToPrime(true).build());
        list.add(PrimeSample.builder().from(5).isFromPrime(true).to(59).isToPrime(true).build());
        list.add(PrimeSample.builder().from(5).isFromPrime(true).to(54).isToPrime(false).expectTo(53).build());
        list.add(PrimeSample.builder().from(5).isFromPrime(true).to(55).isToPrime(false).expectTo(53).build());
        list.add(PrimeSample.builder().from(5).isFromPrime(true).to(56).isToPrime(false).expectTo(53).build());
        list.add(PrimeSample.builder().from(5).isFromPrime(true).to(57).isToPrime(false).expectTo(53).build());
        list.add(PrimeSample.builder().from(5).isFromPrime(true).to(58).isToPrime(false).expectTo(53).build());
        list.add(PrimeSample.builder().from(20).isFromPrime(false).expectFrom(23).to(53).isToPrime(true).build());
        list.add(PrimeSample.builder().from(21).isFromPrime(false).expectFrom(23).to(53).isToPrime(true).build());
        list.add(PrimeSample.builder().from(22).isFromPrime(false).expectFrom(23).to(53).isToPrime(true).build());
        list.add(PrimeSample.builder().from(6).isFromPrime(false).expectFrom(7).to(54).isToPrime(false).expectTo(53).expectSize(13).build());

        for(int i=0; i<list.size(); i++){
            final PrimeSample primeSample = list.get(i);
            final List<Integer> primes = getPrimesV3(primeSample.getFrom(), primeSample.getTo());
            if(primeSample.isFromPrime()){
                Assertions.assertThat(primes.get(0)).isEqualTo(primeSample.getFrom());
            }else{
                Assertions.assertThat(primes.get(0)).isEqualTo(primeSample.getExpectFrom());
            }

            if(primeSample.isToPrime()){
                Assertions.assertThat(primes.get(primes.size()-1)).isEqualTo(primeSample.getTo());
            }else{
                Assertions.assertThat(primes.get(primes.size()-1)).isEqualTo(primeSample.getExpectTo());
            }
            if(primeSample.getExpectSize()>0){
                Assertions.assertThat(primes.size()).isEqualTo(primeSample.getExpectSize());
            }
        }

    }

    public static List<Integer> getPrimesV3(int start, int end) {
        int idxOfStart = 0;
        boolean isFoundIdxOfStart = false;
        List<Integer> list = new ArrayList<>();
        list.add(2);
        for(int i = 3; i<= end; i++){
            boolean isPrime = true;
            for(int j=0; j<Math.sqrt(list.size()); j++){
                if(i%list.get(j)==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                list.add(i);

                if(!isFoundIdxOfStart&&i>= start){
                    isFoundIdxOfStart = true;
                    if(start==2) {
                        idxOfStart = 0;
                    }else if(i == start){
                        idxOfStart = list.size()-1;
                    }else if(i > start){
                        idxOfStart = list.size()-1;
                    }


                }
            }
        }
        list = list.subList(idxOfStart, list.size());
        return list;
    }

    @Test
    void 에라토스테네스의_체(){
        // given
        int start = 50;
        int end = 1597;

        // when
        // 에라토스테네스의 체로 풀기
        // 낮은 숫자부터 자신을 제외하되 자신의 배수인 모든 숫자를 제거한다.
        // 위에 해당하는 숫자는 남은 숫자 중 가장 작은 숫자를 한다.
        List<Integer> list = getPrimesWithEratosthenes(start, end);

        final List<Integer> subPrimes = fixedPrimes(start);

        // then
        Assertions.assertThat(list).isEqualTo(subPrimes);

    }

    @Test
    void 에라토스의_체_테스트2(){
        List<PrimeSample> list = new ArrayList<>();
        list.add(PrimeSample.builder().from(2).isFromPrime(true).to(2).isToPrime(true).expectSize(1).build());
        list.add(PrimeSample.builder().from(2).isFromPrime(true).to(3).isToPrime(true).expectSize(2).build());
        list.add(PrimeSample.builder().from(5).isFromPrime(true).to(53).isToPrime(true).build());
        list.add(PrimeSample.builder().from(5).isFromPrime(true).to(59).isToPrime(true).build());
        list.add(PrimeSample.builder().from(5).isFromPrime(true).to(54).isToPrime(false).expectTo(53).build());
        list.add(PrimeSample.builder().from(5).isFromPrime(true).to(55).isToPrime(false).expectTo(53).build());
        list.add(PrimeSample.builder().from(5).isFromPrime(true).to(56).isToPrime(false).expectTo(53).build());
        list.add(PrimeSample.builder().from(5).isFromPrime(true).to(57).isToPrime(false).expectTo(53).build());
        list.add(PrimeSample.builder().from(5).isFromPrime(true).to(58).isToPrime(false).expectTo(53).build());
        list.add(PrimeSample.builder().from(20).isFromPrime(false).expectFrom(23).to(53).isToPrime(true).build());
        list.add(PrimeSample.builder().from(21).isFromPrime(false).expectFrom(23).to(53).isToPrime(true).build());
        list.add(PrimeSample.builder().from(22).isFromPrime(false).expectFrom(23).to(53).isToPrime(true).build());
        list.add(PrimeSample.builder().from(6).isFromPrime(false).expectFrom(7).to(54).isToPrime(false).expectTo(53).expectSize(13).build());

        for(int i=0; i<list.size(); i++){
            final PrimeSample primeSample = list.get(i);
            final List<Integer> primes = getPrimesWithEratosthenes(primeSample.getFrom(), primeSample.getTo());
            if(primeSample.isFromPrime()){
                Assertions.assertThat(primes.get(0)).isEqualTo(primeSample.getFrom());
            }else{
                Assertions.assertThat(primes.get(0)).isEqualTo(primeSample.getExpectFrom());
            }

            if(primeSample.isToPrime()){
                Assertions.assertThat(primes.get(primes.size()-1)).isEqualTo(primeSample.getTo());
            }else{
                Assertions.assertThat(primes.get(primes.size()-1)).isEqualTo(primeSample.getExpectTo());
            }
            if(primeSample.getExpectSize()>0){
                Assertions.assertThat(primes.size()).isEqualTo(primeSample.getExpectSize());
            }
        }

    }

    private static Set<Integer> randomSets(int size, int max) {
        Set<Integer> sets = new HashSet<>();
        do{
            int random = (int) (Math.random() * max);
            sets.add(random);
        } while(sets.size()<size);

        return sets;
    }

    public static final Comparator<Integer> INTEGER_ASC = new IntegerDescOrderComparator();

    static class IntegerDescOrderComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1>o2? 1 :
                    o1<o2? -1 : 0;
        }

    }



    @Test
    void 에라토스테네스의_체_와_V3_비교(){

        Set<Integer> randomSets = randomSets(1000, 10000);
        final ArrayList<Integer> randomList = new ArrayList<>(randomSets);
        randomList.sort(INTEGER_ASC);

        for(int i=0; i<500; i++){
            final Integer start = randomList.get(i);
            final Integer end = randomList.get(i+500);

            List<Integer> list1 = getPrimesWithEratosthenes(start, end);

            final List<Integer> list2 = getPrimesV3(start, end);

            // then
            Assertions.assertThat(list1).isEqualTo(list2);

            System.out.printf("[%d] %d : %d \n", i, list1.size(), list2.size());
        }
    }


    public static List<Integer> getPrimesWithEratosthenes(int start, int end) {

        // 소수가 아닌 값을 모두 true 처리 한다.
        boolean[] list = new boolean[end+1];
        for(int i=2; i<=end; i++) {
            if(list[i]==false) {
                for(int j=2; j<=end/i; j++) {
                    list[j*i]=true;
                }
            }
        }

        // boolean 배열을 integer 리스트로 변환한다.
        List<Integer> result = new ArrayList<>();
        for(int i=2; i<list.length; i++) {
            if(list[i]==false) {
                if(i>= start){
                    result.add(i);
                }
            }
        }
        return result;
    }
}

@Builder
@Getter
@ToString
class PrimeSample{
    private int from;
    private boolean isFromPrime;
    private int expectFrom;
    private int to;
    private boolean isToPrime;
    private int expectTo;
    private int expectSize;
}