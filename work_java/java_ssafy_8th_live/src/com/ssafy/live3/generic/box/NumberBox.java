// ##DELETE_FILE:
package com.ssafy.live3.generic.box;

public class NumberBox <T extends Number>{
    @SuppressWarnings("unchecked")
    public void addSomes(T... ts) {
        double sum = 0;
        for(T t: ts) {
            sum+=t.doubleValue();
        }
        System.out.printf("총 합은: %f%n", sum);
    }
    
    private T some;

    public T getSome() {
        return some;
    }

    public void setSome(T some) {
        this.some = some;
    }
}
