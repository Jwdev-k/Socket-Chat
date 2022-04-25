package client;

import client.Thread.ListeningThread;
import client.Thread.WritingThread;

import java.io.IOException;
import java.net.Socket;

// 소켓통신용 클라이언트 부분
public class MySocketClient {
    public static Socket socket;

    public static void main(String[] args) {
        try {
            socket = new Socket("127.0.0.1", 7777);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 서버에서 보낸 메세지 읽는 clinet.Thread
        ListeningThread t1 = new ListeningThread(socket); //서버에서 받아오는 쓰레드
        t1.start(); // clinet.Thread.ListeningThread Start

        ClientGUI gui = new ClientGUI();
        gui.setVisible(true);
        // 소켓 서버에 접속
        System.out.println("서버에 접속 성공!"); // 접속 확인용
    }
}