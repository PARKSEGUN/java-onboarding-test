package onboarding;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.*;

class People implements Comparable<People> {
    String name;
    int score;

    public People(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(People o) {
        if (this.score == o.score) {
            return this.name.compareTo(o.name);
        }
        return o.score - this.score;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static List<String> peopleToList(List<People> peopleList) {
        List<String> result = new ArrayList<>();
        for (People people : peopleList) {
            result.add(people.name);
        }
        return result;
    }
}

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriends = findFriends(friends, user);
        List<String> friendsByUserFriends = findFriendsByUserFriends(friends, user, userFriends);
        Map<String, Integer> scoreByName = makeMap(user, userFriends, friendsByUserFriends, visitors);
        return findAnswer(scoreByName);
    }

    private static List<String> findAnswer(Map<String, Integer> scoreByName) {
        List<People> peopleList = mapToClass(scoreByName);
        Collections.sort(peopleList);
        return People.peopleToList(peopleList);
    }

    private static List<People> mapToClass(Map<String, Integer> scoreByName) {
        List<People> peopleList = new ArrayList<>();
        for (String name : scoreByName.keySet()) {
            peopleList.add(new People(name, scoreByName.get(name)));
        }
        return peopleList;
    }

    private static Map<String, Integer> makeMap(String user, List<String> userFriends, List<String> friendsByUserFriends, List<String> visitors) {
        Map<String, Integer> scoreByName = putToMap(friendsByUserFriends);
        plusScoreByVisitors(scoreByName, visitors);
        deleteUserAndUserFriend(scoreByName, user, userFriends);
        return scoreByName;
    }

    private static void plusScoreByVisitors(Map<String, Integer> scoreByName, List<String> visitors) {
        for (String visitor : visitors) {
            if (scoreByName.containsKey(visitor)) {
                int score = scoreByName.get(visitor);
                scoreByName.put(visitor, score + 1);
            } else {  //else 없애보자
                scoreByName.put(visitor, 1);
            }
        }
    }

    private static void deleteUserAndUserFriend(Map<String, Integer> scoreByName, String user, List<String> userFriends) {
        scoreByName.remove(user);
        for (String userFriend : userFriends) {
            scoreByName.remove(userFriend);
        }
    }

    private static Map<String, Integer> putToMap(List<String> friendsByUserFriends) {
        Map<String, Integer> scoreByName = new HashMap<>();
        for (String friendsByUserFriend : friendsByUserFriends) {
            if (scoreByName.containsKey(friendsByUserFriend)) {
                int score = scoreByName.get(friendsByUserFriend);
                scoreByName.put(friendsByUserFriend, score + 10);
            } else {  //else 없애보자
                scoreByName.put(friendsByUserFriend, 10);
            }
        }
        return scoreByName;
    }

    private static List<String> findFriendsByUserFriends(List<List<String>> friends, String person, List<String> userFriends) {
        List<String> friendsByUserFriends = new ArrayList<>();
        for (String userFriend : userFriends) {
            friendsByUserFriends.addAll(findFriends(friends, userFriend));
        }
        return friendsByUserFriends;

    }

    private static List<String> findFriends(List<List<String>> friends, String person) {
        List<String> userFriends = new ArrayList<>();
        for (List<String> friend : friends) {
            //메서드를 나눌 수 있을까
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);
            String friendByName = findFriendByName(friend1, friend2, person);
            if (!friendByName.equals("")) {
                userFriends.add(friendByName);
            }
        }
        return userFriends;
    }

    private static String findFriendByName(String friend1, String friend2, String person) {
        if (friend1.equals(person)) {
            return friend2;
        } else if (friend2.equals(person)) {
            return friend1;
        }
        return "";
    }
}

