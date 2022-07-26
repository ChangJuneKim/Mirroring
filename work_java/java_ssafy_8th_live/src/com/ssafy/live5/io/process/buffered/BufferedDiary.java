// ##DELETE_FILE:
package com.ssafy.live5.io.process.buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;


public class BufferedDiary {
    public static void main(String[] args) throws IOException {
        BufferedDiary st = new BufferedDiary();

        st.writeDiary();
    }

    
    private void writeDiary() {
        File target = new File("c:" + File.separator + "Temp" + File.separator + "diary.txt");

        try (
                BufferedReader fromKey = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter writer = new BufferedWriter(new FileWriter(target, true));
          BufferedReader reader = new BufferedReader(new FileReader(target));
                ) {
          System.out.println("일기를 작성합니다. 그만두려면 x를 입력하세요.");
          writer.write("\n오늘 날짜: - " + new Date() + "\n");
          String str = null;
          while (true) {
            str = fromKey.readLine();
            if (str.equals("x")) {
              break;
            } else {
              writer.write(str + "\n");
            }
          }
          writer.flush();// 버퍼의 내용을 출력하고 비움

          String line = null;
          while ((line = reader.readLine()) !=null) {
            System.out.println(line);
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
    }
}
