package client;

import client.Thread.ListeningThread;
import client.Thread.WritingThread;

import java.io.IOException;
import java.net.Socket;

// 소켓통신용 클라이언트 부분
public class MySocketClient {

    public static void main(String[] args) {
        try {
            Socket socket = null;
            // 소켓 서버에 접속
            socket = new Socket("127.0.0.1", 7777);
            System.out.println("서버에 접속 성공!"); // 접속 확인용

            // 서버에서 보낸 메세지 읽는 clinet.Thread
            ListeningThread t1 = new ListeningThread(socket);
            WritingThread t2 = new WritingThread(socket); // 서버로 메세지 보내는 clinet.Thread

            t1.start(); // clinet.Thread.ListeningThread Start
            t2.start(); // clinet.Thread.WritingThread Start

        } catch (IOException e) {
            e.printStackTrace(); // 예외처리
        }
    }
}