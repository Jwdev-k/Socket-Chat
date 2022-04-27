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
            ClientGUI gui = new ClientGUI();
            socket = new Socket("127.0.0.1", 7777); // 소켓 서버에 접속
            ClientGUI.sendText(socket.getInetAddress() + ":" + socket.getPort() + "서버에 접속 성공!" + "\n"); // 접속 확인용
            gui.setVisible(true);
            ListeningThread lt = new ListeningThread(socket); //서버에서 받아오는 쓰레드
            lt.start();
            WritingThread wt = new WritingThread(socket);
            wt.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}