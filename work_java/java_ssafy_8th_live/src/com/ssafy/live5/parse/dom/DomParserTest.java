package com.ssafy.live5.parse.dom;

import java.util.List;

import com.ssafy.live5.parse.BoxOffice;

/**
 * @since 2021. 7. 9.
 */
public class DomParserTest {
    public static void main(String[] args) {
        BoxOfficeDomParser parser = new BoxOfficeDomParser();
        List<BoxOffice> list = parser.getBoxOffice();
        
        for(BoxOffice info: list) {
            System.out.println(info);
        }
    }   
}
