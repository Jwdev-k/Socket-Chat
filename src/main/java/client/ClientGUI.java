/*
 * Created by JFormDesigner on Mon Apr 25 23:39:22 KST 2022
 */

package client;

import java.awt.*;
import javax.swing.event.*;
import client.Thread.WritingThread;
import java.awt.event.*;
import java.net.Socket;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author GomGom
 * Using JFD
 */
public class ClientGUI extends JFrame {

    private final Socket socket = MySocketClient.socket;

    public ClientGUI() {
        initComponents();
    }

    private void Enter(ActionEvent e) {
        ChatText.setText("");
    }

    private void ChatTextKeyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            ChatText.setText("");
        }
    }

    private void thisWindowClosing(WindowEvent e) {
        System.exit(1);
    }

    private void thisWindowActivated(WindowEvent e) {
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Enter = new JButton();
        ChatText = new JFormattedTextField();
        scrollPane1 = new JScrollPane();
        panel1 = new JPanel();
        ChatList = new JTextArea();

        //======== this ========
        setTitle("TestClient");
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                thisWindowActivated(e);
            }
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        var contentPane = getContentPane();

        //---- Enter ----
        Enter.setText("Enter");
        Enter.addActionListener(e -> Enter(e));

        //---- ChatText ----
        ChatText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                ChatTextKeyPressed(e);
            }
        });

        //======== scrollPane1 ========
        {

            //======== panel1 ========
            {
                panel1.setLayout(new BorderLayout());

                //---- ChatList ----
                ChatList.setEditable(false);
                panel1.add(ChatList, BorderLayout.CENTER);
            }
            scrollPane1.setViewportView(panel1);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(scrollPane1)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(ChatText, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Enter, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGap(113, 113, 113))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Enter, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addComponent(ChatText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(45, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton Enter;
    private JFormattedTextField ChatText;
    private JScrollPane scrollPane1;
    private JPanel panel1;
    private JTextArea ChatList;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
