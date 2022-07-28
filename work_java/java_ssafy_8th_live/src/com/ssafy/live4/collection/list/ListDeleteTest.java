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
        // TODO: 3의 배수인 요소들을 삭제해보자.
        // END:
        System.out.println("3의 배수 삭제 후: " + nums);

        // TODO: 3n+1인 요소들을 삭제해보자.
        // END:
        System.out.println("3n+1 삭제 후: " + nums);
        
        // TODO: 3n+2인 요소들을 삭제해보자.
        // END:
        
        List<String> strs = Arrays.asList("Hello", "Collection", "World");
        // TODO: strs에 자료를 추가, 수정, 삭제해보자.
        // END:
        System.out.println(strs);
    }

}
