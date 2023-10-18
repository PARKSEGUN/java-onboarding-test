package onboarding;

import java.util.*;

//객체를 정렬하기위한 compareTo 메서드를 사용하기위해 Comparable interface 를 상속받는다.
//주어진 friends 정보에서 user의 친구를 뽑아낸다
//다시 friends에서 뽑아낸친구들의 친구를 뽑아낸다.
//이 친구들은 10점씩 추가해준다.
//visitors 중 user의 친구가 아닌 사람을 확인
//확인 한 친구들은 1점씩 추가
//모든 점수를 더해주었을때에 가장 점수가 높은 5명 추출
//점수가 같다면 이름을 기준으로 오름차순 정렬
class People implements Comparable {

    private String name;

    private int score = 0;

//    private List<People> friends = new ArrayList<>();

    public People(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }


//

    public boolean isEqualName(String name) {
        if (this.name.equals(name)) {
            return true;
        }
        return false;
    }
//
//    public void saveFriends(List<People> userFriends) {
//        this.friends = userFriends;
//    }

    public Map<String, Integer> modifyScoreAdd10(Map<String, Integer> scoreByName, People people) {
        if (scoreByName.containsKey(people.name)) {
            int score = scoreByName.get(people.name).intValue();
            scoreByName.put(people.name, score+10);
        } else if (!scoreByName.containsKey(people.name)) {
            scoreByName.put(people.name, 10);
        }
        return scoreByName;
    }
}

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        People userByPeople = new People(user);
        List<People> userFriends = new ArrayList<>();
        List<People> friendsByUserFriends = new ArrayList<>();
        Map<String, Integer> scoreByName = new HashMap<>();

        userFriends = findFriends(userFriends, friends, userByPeople);
        friendsByUserFriends = findFriendsByUserFriends(userFriends, friends, friendsByUserFriends);
        for (People friendsByUserFriend : friendsByUserFriends) {
            friendsByUserFriend.modifyScoreAdd10(scoreByName, friendsByUserFriend);
        }
        System.out.println(scoreByName);
        
        return answer;
    }

    private static List<People> findFriendsByUserFriends(List<People> userFriends, List<List<String>> friends, List<People> friendsByUserFriends) {
        for (People userFriend : userFriends) {
            friendsByUserFriends = findFriends(friendsByUserFriends, friends, userFriend);
        }
        return friendsByUserFriends;
    }


    private static List<People> findFriends(List<People> userFriends, List<List<String>> friends, People people) {
        for (List<String> friend : friends) {
            String name1 = friend.get(0);
            String name2 = friend.get(1);
            String userFriend = findFriend(name1, name2, people);
            userFriends = addUserFriend(userFriends, userFriend);
        }
        return userFriends;
    }

    private static List<People> addUserFriend(List<People> userFriends, String userFriend) {
        if (userFriend.equals("")) {
            return userFriends;
        }
        People friend = new People(userFriend);
        userFriends.add(friend);
        return userFriends;
    }

    private static String findFriend(String name1, String name2, People people) {
        if (people.isEqualName(name1)) {
            return name2;
        } else if (people.isEqualName(name2)) {
            return name1;
        }
        return "";
    }


}
