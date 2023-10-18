package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//객체를 정렬하기위한 compareTo 메서드를 사용하기위해 Comparable interface 를 상속받는다.
//주어진 friends 정보에서 user의 친구를 뽑아낸다
//다시 friends에서 뽑아낸친구들의 친구를 뽑아낸다.
//이 친구들은 10점씩 추가해준다.
//visitors 중 user의 친구가 아닌 사람을 확인
//확인 한 친구들은 1점씩 추가
//모든 점수를 더해주었을때에 가장 점수가 높은 5명 추출
//점수가 같다면 이름을 기준으로 오름차순 정렬
class People implements Comparable {
    String name;
    boolean isUserFriend=false;
    int score = 0;

    public People(String name) {
        this.name = name;
    }

    public void modifyIsUserFriendTrue() {
        this.isUserFriend = true;
    }
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<People> userFriends = new ArrayList<>();
        userFriends=findUserFriends(userFriends,friends,user);
        return answer;
    }

    private static List<People> findUserFriends(List<People> userFriends,List<List<String>> friends,String user) {
        for (List<String> friend : friends) {
            String name1 = friend.get(0);
            String name2 = friend.get(1);
            People userFriend = new People(findUserFriend(name1, name2, user));
            userFriend.modifyIsUserFriendTrue();
            userFriends.add(userFriend);
        }
        return userFriends;
    }

    private static String findUserFriend(String name1, String name2, String user) {
        if (name1.equals(user)) {
            return name2;
        } else if (name2.equals(user)) {
            return name1;
        }
        return "";
    }

}
