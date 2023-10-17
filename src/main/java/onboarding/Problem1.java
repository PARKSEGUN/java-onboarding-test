package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        findMaxByUser(pobi);
        return answer;
    }

    public static int findMaxByUser(List<Integer> pages) {
        int leftPageMax = findMaxByPage(pages.get(0));
        int rightPageMax= findMaxByPage(pages.get(1));
        return Math.max(leftPageMax, rightPageMax);
    }
    public static int findMaxByPage(int page) {
        int PageAddScore=0;
        int PageMultiScore =1;
        while(page>0){
            PageAddScore+=page%10;
            PageMultiScore *= page % 10;
            page /= 10;
        }
        System.out.println(PageAddScore);
        System.out.println(PageMultiScore);
        return Math.max(PageAddScore, PageMultiScore);
    }
}