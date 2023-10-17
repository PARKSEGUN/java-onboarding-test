package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        System.out.println(isPageNormal(pobi));
        System.out.println(isPageNormal(crong));
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
    public static boolean isPageNormal(List<Integer> user) {
        int leftPage = user.get(0);
        int rightPage = user.get(1);
        if(!(leftPage>0&&leftPage<=400&&rightPage>0&&rightPage<=400)){
            return false;
        }
        if (leftPage + 1 != rightPage) {
            return false;
        }
        if (leftPage % 2 != 1 || rightPage % 2 != 0) {
            return false;
        }
        return true;
    }
}