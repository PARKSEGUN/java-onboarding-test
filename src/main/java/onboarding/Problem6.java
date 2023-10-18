package onboarding;

import net.bytebuddy.TypeCache;

import java.util.*;


//1. 주어진 forms의 nickname 정보를 2글자 기준으로 나누기
//        2. Map<String,List<String>> 에 값을 넣어주기위한 함수
//        3. Map에 잘라진 문자들을 key로 key값에 맞는 email을 저장
//        4. key값이 존재한다면 List에 추가하면서 저장
//        5. Map의 value부분의 크기가 2이상인 것들을 빼오기
//        6. 이 값들은 중복된 정보들의 email을 뜻하기에 정렬후 반환

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = findEmails(forms);

        return answer;
    }

    private static List<String> findEmails(List<List<String>> forms) {
        Map<String, List<String>> emailByDividedNickName = new HashMap<>();
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            List<String> dividedList = divideString(nickname);
            emailByDividedNickName = checkDuplication(emailByDividedNickName, dividedList, email);
        }
        List<String> emailsByDuplicatedNickname = findEmailsByMap(emailByDividedNickName);
        List<String> sortedEmails = sortEmail(emailsByDuplicatedNickname);
        return sortedEmails;
    }


    private static List<String> sortEmail(List<String> emailsByDuplicatedNickname) {
        Collections.sort(emailsByDuplicatedNickname);
        return emailsByDuplicatedNickname;
    }

    private static List<String> findEmailsByMap(Map<String, List<String>> emailByDividedNickName) {
        List<String> result = new ArrayList<>();
        for (List<String> emails: emailByDividedNickName.values()) {
            result=inputResult(result, emails);
        }
        return result;
    }
    //
    private static List<String> inputResult(List<String> result, List<String> emails) {
        if (emails.size() >= 2) {
            for (String email : emails) {
                result.add(email);
            }
        }
        return result;
    }

    //쪼개진 부분을 Map에서 Key값으로 갖고있는지를 확인
    //갖고있다면 중복이므로 value에 추가
    //갖고있지 않다면 value 초기화
    private static Map<String, List<String>> checkDuplication(Map<String, List<String>> emailByDividedNickName, List<String> dividedList, String email) {
        for (String divided : dividedList) {
            if (emailByDividedNickName.containsKey(divided)) {
                List<String> emailList = emailByDividedNickName.get(divided);
                emailList.add(email);
                emailByDividedNickName.put(divided, emailList);
            } else {
                emailByDividedNickName.put(divided, new ArrayList(Arrays.asList(email)));
            }
        }
        return emailByDividedNickName;
    }

    //문자열을 받아서 길이가 2인 쪼개진 문자열List로 반환
    private static List<String> divideString(String nickname) {
        List<String> dividedStrings = new ArrayList<>();
        for (int i = 0; i + 1 < nickname.length(); i++) {
            String dividedString = nickname.substring(i, i + 2);
            dividedStrings.add(dividedString);
        }
        return dividedStrings;
    }


}
