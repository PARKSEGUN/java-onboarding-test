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

    //중복된 닉네임값을 갖는 이메일을 찾아주는 함수
    //forms 정보를 받고
    //정렬된 이메일 리스트를 반환
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

    //이메일들을 받아서 정렬시켜주는 함수
    //이메일 리스트를 받아서
    //오름차순 정렬된 이메일 리스트로 반환
    private static List<String> sortEmail(List<String> emailsByDuplicatedNickname) {
        Collections.sort(emailsByDuplicatedNickname);
        return emailsByDuplicatedNickname;
    }

    //Map에 저장한 값들중에서 중복된 닉네임이 있는지 확인하고 리턴시켜주는 함수
    //잘라진 닉네임과 연견된 email을 갖고있는 Map을 통해
    //중복된 닉네임의 이메일 리스트를 반환
    private static List<String> findEmailsByMap(Map<String, List<String>> emailByDividedNickName) {
        List<String> result = new ArrayList<>();
        for (List<String> emails: emailByDividedNickName.values()) {
            result=inputResult(result, emails);
        }
        return result;
    }
    //현재 탐색하고있는 이메일 리스트가 정답이 되는 것인지 확인하는 함수
    //반환시킬 result정보와 이메일 리스트 정보를 받아서
    //정답이되는 이메일 리스트를 result에 추가해서 반환
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
    //문자열을 받아서
    private static List<String> divideString(String nickname) {
        List<String> dividedStrings = new ArrayList<>();
        for (int i = 0; i + 1 < nickname.length(); i++) {
            String dividedString = nickname.substring(i, i + 2);
            dividedStrings.add(dividedString);
        }
        return dividedStrings;
    }


}
