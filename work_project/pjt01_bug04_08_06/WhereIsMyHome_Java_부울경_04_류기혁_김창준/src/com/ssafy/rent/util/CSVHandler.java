package com.ssafy.rent.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.rent.model.dto.EnvironmentInfo;

public class CSVHandler {
	private List<EnvironmentInfo> datas;

	public void loadData() throws IOException {
		File src = new File("seoul.csv");
		datas = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(src));) {
			String line = null;
			int number = 0;
			br.readLine();
			
			while(true) {
				line = br.readLine();
				if(line == null) break;
				
				System.out.println(line);
				number++;
				
				String[] splitedLine = line.split(",");
		
				String name = splitedLine[0];
				String date = splitedLine[4];
				String desc = splitedLine[9];
				String addr = splitedLine[12];
				
				EnvironmentInfo data = new EnvironmentInfo(number, name, date, desc, addr);
				datas.add(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<EnvironmentInfo> getEnvironmentInfos() {
		try {
			loadData();
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return datas;
	}

}
