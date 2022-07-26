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

        // @@TODOBLOCK: json을 파싱해서 list를 구성하시오.
        // 기본적으로는 Map의 구조를 가짐
        Map<String, Map<String, Object>> result;
        try {
            result = mapper.readValue(json, Map.class);
            // 배열은 List
            List<Map<String, Object>> dailyBoxOfficeList = (List) result.get("boxOfficeResult").get("dailyBoxOfficeList");

            /*
            for (Map<String, Object> info : dailyBoxOfficeList) {
                // 필요한 객체 형으로 변환
                BoxOffice boxOffice = mapper.convertValue(info, BoxOffice.class);
                this.list.add(boxOffice);
            }
            */
            this.list = dailyBoxOfficeList.stream().map(info -> mapper.convertValue(info, BoxOffice.class)).collect(Collectors.toList());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        // @@END:
        return list;
    }

}