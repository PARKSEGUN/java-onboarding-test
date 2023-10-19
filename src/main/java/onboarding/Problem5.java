package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        //List.of() 메서드를 사용하면 삽입, 삭제, 변경 이 불가능해진다.
        // Arrays.asList()를 사용해서도 삽입, 삭제 불가능
        // 삽입 삭제를 위한 리스트를 초기화 하고싶다면 new ArrayList(Arrays.asList()) 사용
        List<Integer> moneyUnit = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        moneyUnit.add(0);
        for (Integer unit : moneyUnit) {
            answer.add(findCount(money,unit));
            money %= unit;
        }
        return answer;
    }

    private static Integer findCount(int money, Integer unit) {
        return money / unit;
    }

}
