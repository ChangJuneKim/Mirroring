package com.ssafy.live5.parse.json;

import java.io.File;
import java.io.IOException;
import java.security.KeyStore.TrustedCertificateEntry;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.live5.parse.BoxOffice;


public class UseJson {
    private final File json = new File("./src/com/ssafy/live5/parse/boxoffice.json");
    private List<BoxOffice> list = new ArrayList<>();

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<BoxOffice> getBoxOffice() throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        // 날짜 변경과 관련된 룰 지정
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));

        // TODO: json을 파싱해서 list를 구성하시오.
        Map<String, Map<String, Object>> result = mapper.readValue(json, Map.class);
        List<Map<String, Object>> list = (List) result.get("boxOfficeResult").get("dailyBoxOfficeList");
        
        for(Map<String, Object> info:list) {
        	BoxOffice boxOffice = mapper.convertValue(info, BoxOffice.class);
        	this.list.add(boxOffice);
        }
        // END:
        return this.list;
    }

}
