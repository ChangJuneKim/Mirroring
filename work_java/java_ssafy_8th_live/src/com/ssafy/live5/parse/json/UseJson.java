package com.ssafy.live5.parse.json;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.live5.parse.BoxOffice;

public class UseJson {
    private final File json = new File("./src/com/ssafy/live5/parse/boxoffice.json");
    private List<BoxOffice> list = new ArrayList<>();

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<BoxOffice> getBoxOffice() {
        ObjectMapper mapper = new ObjectMapper();

        // 날짜 변경과 관련된 룰 지정
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));

        // TODO: json을 파싱해서 list를 구성하시오.
        // END:
        return list;
    }

}
