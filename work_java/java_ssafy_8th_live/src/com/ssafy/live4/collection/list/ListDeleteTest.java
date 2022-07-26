package com.ssafy.live4.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ListDeleteTest {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nums.add(i);
        }
        System.out.println("전체: " + nums);
        // @@TODOBLOCK: 3의 배수인 요소들을 삭제해보자.
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) % 3 == 0) {
                nums.remove(i);
                // @@REPLACE:
                i--;
            }
        }
        // @@END:
        System.out.println("3의 배수 삭제 후: " + nums);

        // @@TODOBLOCK: 3n+1인 요소들을 삭제해보자.
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (nums.get(i) % 3 == 1) {
                nums.remove(i);
            }
        }
        // @@END:
        System.out.println("3n+1 삭제 후: " + nums);
        
        // @@TODOBLOCK: 3n+2인 요소들을 삭제해보자.
        nums.removeIf(num -> num%3==2);
        System.out.println("3n+2 삭제 후: " + nums);
        // @@END:
        
        List<String> strs = Arrays.asList("Hello", "Collection", "World");
        // @@TODOBLOCK: strs에 자료를 추가, 수정, 삭제해보자.
        // Arrays.asList는 고정 크기 list 반환
        //strs.add("Hello");
        //strs.remove(0);
        strs.set(0, "Hi");
        // @@END:
        System.out.println(strs);
    }

}
