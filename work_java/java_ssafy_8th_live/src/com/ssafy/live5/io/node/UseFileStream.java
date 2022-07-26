package com.ssafy.live5.io.node;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class UseFileStream {
    public static void main(String[] args) throws IOException {
        UseFileStream st = new UseFileStream();
        st.testFile();

        // System.out.printf("buffer size: %d, time: %d%n", 100, st.fileMove(100));
        // System.out.printf("buffer size: %d, time: %d%n", 1000, st.fileMove(1000));
        // System.out.printf("buffer size: %d, time: %d%n", 10000, st.fileMove(10000));
        // System.out.printf("buffer size: %d, time: %d%n", 100000, st.fileMove(100000));
        // System.out.printf("buffer size: %d, time: %d%n", 1000000, st.fileMove(1000000));
    }


    private void testFile() throws IOException {
        // 절대 경로
        File temp = new File("c:\\Temp");
        System.out.printf("존재? %b, 디렉토리? %b%n", temp.exists(), temp.isDirectory());

        // 상대경로
        File current = new File(".");
        System.out.printf("여기는 어디? %s%n", current.getCanonicalPath());
        
        // 상대경로의 기준은 java program을 실행하는 위치(소스와 무관)
        //d:\>java -cp .;c:\SSAFY\workspace\java\live\bin com.ssafy.live5.io.node.UseFileStream
        //c:\SSAFY\workspace\java\live\bin>java com.ssafy.live5.io.node.UseFileStream
        
        // @@TODOBLOCK: readme.txt에 해당하는 File 객체를 만들어 보자.
        // @@KEEP: 프로젝트와 무관하게 파일을 찾을 
        //File readMe = new File("/Volumes/Data/workspace/ssafy/java_ssafy_8th_live/src/com/ssafy/live5/io/node/readme.txt");
        // @@KEEP: 프로젝트 내부에서 파일을 찾을 
        //File readMe = new File("./src/com/ssafy/live5/io/node/readme.txt");
        //File readMe = new File("./bin/com/ssafy/live5/io/node/readme.txt");
        // @@KEEP: 특정 클래스 기준으로 파일을 찾을 
        File readMe = new File(UseFileStream.class.getResource("readme.txt").getFile());
        System.out.println(readMe);
        System.out.println(readMe.canRead());
        // @@END:
    }

    public long fileMove(int bufferSize) {
        long start = System.currentTimeMillis();
        // @@TODOINLINE: 본인의 컴퓨터에서 크기가 큰 파일을 선택하세요.
        File src = new File("c:\\ssafy\\eclipse-jee-2018-09-win32-x86_64.zip");
        File target = new File("c:\\Temp\\eclipse.zip");
        // @@TODOBLOCK: bufferSize 크기의 byte []을 이용해서 src를 target에 복사하시오.
        try (FileInputStream fin = new FileInputStream(src);
                FileOutputStream fout = new FileOutputStream(target)) {
            byte[] buffer = new byte[bufferSize];

            int read = 0;
            while ((read = fin.read(buffer)) > 0) {
                fout.write(buffer, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // @@END:
        return System.currentTimeMillis() - start;
    }
}
