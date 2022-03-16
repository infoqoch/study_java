package effective.c37;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

// EnumMap을 사용해 열거 타입에 데이터를 연관시키기 (226-228쪽)

// 식물을 아주 단순하게 표현한 클래스 (226쪽)
class Plant {
    enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL}

    final String name;
    final LifeCycle lifeCycle;

    Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }

    public void test1() {
        Plant[] garden = {
                new Plant("바질", LifeCycle.ANNUAL),
                new Plant("캐러웨이", LifeCycle.BIENNIAL),
                new Plant("딜", LifeCycle.ANNUAL),
                new Plant("라벤더", LifeCycle.PERENNIAL),
                new Plant("파슬리", LifeCycle.BIENNIAL),
                new Plant("로즈마리", LifeCycle.PERENNIAL)
        };

        final EnumMap<LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(LifeCycle.class);

        // EnumMap 을 초기화 한다.
        for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
            plantsByLifeCycle.put(lc, new HashSet<>());
        }

        // 각 Plant 객체를 삽입한다.
        for (Plant p : garden) {
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        }

        for (LifeCycle lifeCycle : plantsByLifeCycle.keySet()) {
            System.out.println("lifeCycle = " + lifeCycle);
            System.out.println("plantsByLifeCycle.get(lifeCycle) = " + plantsByLifeCycle.get(lifeCycle));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Plant[] garden = {
                new Plant("바질", LifeCycle.ANNUAL),
                new Plant("캐러웨이", LifeCycle.BIENNIAL),
                new Plant("딜", LifeCycle.ANNUAL),
                new Plant("라벤더", LifeCycle.PERENNIAL),
                new Plant("파슬리", LifeCycle.BIENNIAL),
                new Plant("로즈마리", LifeCycle.PERENNIAL)
        };

        final Map<LifeCycle, List<Plant>> plantsByLifeCycle1 = Arrays.stream(garden)
                .collect(groupingBy(p -> p.lifeCycle));
        System.out.println("plantsByLifeCycle1.getClass() = " + plantsByLifeCycle1.getClass());

        final EnumMap<LifeCycle, Set<Plant>> plantsByLifeCycle2 = Arrays.stream(garden)
                .collect(groupingBy(
                        p -> p.lifeCycle
                        , () -> new EnumMap<>(LifeCycle.class)
                        , toSet()));
    }
}

