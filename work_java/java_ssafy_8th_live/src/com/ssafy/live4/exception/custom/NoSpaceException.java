// ##DELETE_FILE:
package com.ssafy.live4.exception.custom;


@SuppressWarnings("serial")
public class NoSpaceException extends RuntimeException {
    public NoSpaceException(String name) {
        super(name + "을 넣을 공간이 없습니다.");
    }
}
