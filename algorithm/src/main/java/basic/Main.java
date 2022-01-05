package basic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int st = Integer.parseInt(str.split(" ")[0]);
        int en = Integer.parseInt(str.split(" ")[1]);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final List<Integer> primesV3 = getPrimesWithEratosthenes(st, en);
        primesV3.stream().forEach(System.out::println);


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
                    idxOfStart = list.size()-1;
                }
            }
        }
        list = list.subList(idxOfStart, list.size());
        return list;
    }

}
