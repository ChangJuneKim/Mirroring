package com.ssafy.live5.parse.sax;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.ssafy.live5.parse.BoxOffice;


public class BoxOfficeSaxParser extends DefaultHandler {
    private final File xml = new File("./src/com/ssafy/live5/parse/boxoffice.xml");
    // 파싱된 내용을 저장할 List
    private List<BoxOffice> list = new ArrayList<>();
    // 현재 파싱하고 있는 대상 객체
    private BoxOffice current;
    // 방금 읽은 텍스트 내용
    private String content;

    public List<BoxOffice> getBoxOffice() {
        // TODO: SAXParser를 구성하고 boxoffice.xml을 파싱하시오.
        // END:
        return list;
    }
    
    // TODO: 필요한 매서드를 재정의 하여 boxOffice.xml을 파싱하시오.
    // END:
}
