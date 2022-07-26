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
        // @@TODOBLOCK: SAXParser를 구성하고 boxoffice.xml을 파싱하시오.
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            
            parser.parse(xml, this);
        } catch (IOException | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        // @@END:
        return list;
    }
    
    // @@TODOBLOCK: 필요한 매서드를 재정의 하여 boxOffice.xml을 파싱하시오.
    @Override
    public void startDocument() throws SAXException {
        System.out.println("문서 시작");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("문서 종료");
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // 방금 읽은 태그가 student라면 --> 새로운 Student 생성
        if (qName.equals("dailyBoxOffice")) {
            current = new BoxOffice();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        this.content = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("dailyBoxOffice")) {
            list.add(current);
            current = null;
        } else if (qName.equals("rank")) {
            current.setRank(Integer.parseInt(content));
        } else if (qName.equals("movieNm")) {
            current.setMovieNm(this.content);
        } else if (qName.equals("openDt")) {
            current.setOpenDt(current.toDate(this.content));
        } else if (qName.equals("audiAcc")) {
            current.setAudiAcc(Integer.parseInt(content));
        }
    }
    // @@END:
}
