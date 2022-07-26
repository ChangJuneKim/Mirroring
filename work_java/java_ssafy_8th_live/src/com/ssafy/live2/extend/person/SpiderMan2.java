// ##DELETE_FILE:
package com.ssafy.live2.extend.person;

public class SpiderMan2 extends Person {
    // @@TODOBLOCK: SpiderMan2가 거미줄을 쏠 수 있도록 Spider를 포함해서 사용해보자.
    Spider spider = new Spider();
    boolean isSpider;

    public void fireWeb() {
        if (isSpider) {
            spider.fireWeb();
        } else {
            System.out.println("Person은 거미줄 발사 불가");
        }
    }
    // @@END:

    // @@TODOBLOCK: SpiderMan2가 더 잘 뛸 수 있도록 메서드를 재정의해보자.
    @Override
    public void jump() {
        if (isSpider) {
            spider.jump();
        } else {
            // System.out.println("뛰기");
            super.jump();
        }
    }
    // @@END:
}
