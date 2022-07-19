package com.ssafy.live5.parse.sax;

import java.util.List;

import com.ssafy.live5.parse.BoxOffice;


public class SaxParserTest {

    public static void main(String[] args) {
        BoxOfficeSaxParser handler = new BoxOfficeSaxParser();

        List<BoxOffice> list = handler.getBoxOffice();
        for (BoxOffice boxOffice : list) {
            System.out.println(boxOffice);
        }

    }
}
