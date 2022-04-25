package client.Thread;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class WritingThread extends Thread { // 서버로 메세지 보내는 clinet.Thread
    Socket socket = null;

    public static String str;

    public WritingThread(Socket socket) { // 생성자
        // 받아온 Socket Parameter를 해당 클래스 Socket에 넣기
        this.socket = socket;
    }

    public static void str(String text) {
        str = text;
    }

    public void run() {
        try {
            // OutputStream - 클라이언트에서 Server로 메세지 발송
            // socket의 OutputStream 정보를 OutputStream out에 넣은 뒤
            OutputStream out = socket.getOutputStream();
            // PrintWriter에 위 OutputStream을 담아 사용
            PrintWriter writer = new PrintWriter(out, true);
            if (str != null) {
                writer.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외처리
        }
    }


}