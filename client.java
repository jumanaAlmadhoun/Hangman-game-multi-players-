
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.*;

public class client extends javax.swing.JFrame {
    
    private static DataInputStream fromServer;
    private static DataOutputStream toServer;
    private static Socket serverSocket;
    private static int playerNum;
    private static String word;
    private static int attempts = 0;
    private static int opponent = 0;
    private static String resultMsg;
    private static String guess;
    private static String finalResult;
    
    public client() {
        initComponents();
        answer.setBackground(new Color(46, 196, 182));
        //set Icon
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().
                getResource("hangmanIcon.png")));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        above = new javax.swing.JLabel();
        Enter = new javax.swing.JLabel();
        GUESS = new javax.swing.JTextField();
        result = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        label_playerNo = new javax.swing.JLabel();
        label_img = new javax.swing.JLabel();
        label_img1 = new javax.swing.JLabel();
        answer = new javax.swing.JButton();
        waiting = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hangman Game");
        setBackground(new java.awt.Color(253, 255, 252));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        above.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        above.setForeground(new java.awt.Color(231, 29, 54));

        Enter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Enter.setForeground(new java.awt.Color(46, 196, 182));
        Enter.setText("It's your turn, Enter your guess:");

        GUESS.setForeground(new java.awt.Color(231, 29, 54));
        GUESS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GUESSActionPerformed(evt);
            }
        });

        result.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(46, 196, 182));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(231, 29, 54));
        jLabel1.setText("HANGMAN");

        label_playerNo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label_playerNo.setForeground(new java.awt.Color(231, 29, 54));

        label_img.setMaximumSize(new java.awt.Dimension(845, 400));

        label_img1.setMaximumSize(new java.awt.Dimension(845, 400));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(label_playerNo, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_img, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_img1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(label_img1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_playerNo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        answer.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        answer.setText("GUESS");
        answer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerActionPerformed(evt);
            }
        });

        waiting.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        waiting.setForeground(new java.awt.Color(46, 196, 182));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Enter)
                                    .addComponent(GUESS, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(118, 118, 118))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(answer)
                                .addGap(244, 244, 244))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(result, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(above, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 47, Short.MAX_VALUE)
                                .addComponent(waiting, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(above, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(waiting, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Enter, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(GUESS, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answer)
                .addGap(73, 73, 73))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void GUESSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GUESSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GUESSActionPerformed

    private void answerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerActionPerformed
        if (GUESS.getText().isEmpty()) {
            return;
        }
        guess = GUESS.getText();
        GUESS.setText("");
    }//GEN-LAST:event_answerActionPerformed
    
    public static void main(String args[]) throws IOException {
        try {
            new client().setVisible(true);
            
            GUESS.setVisible(false);
            answer.setVisible(false);
            Enter.setVisible(false);

            // Connecting to server socket
            connectToServer();
            playerNum = fromServer.readInt();
            if (playerNum == 1) {
                label_playerNo.setText("You are player 1!");
                above.setText("Waiting for player 2 to join!");
                fromServer.readUTF();
                above.setText("Player 2 has joined. you start first");
           
            } else if (playerNum == 2) {
                label_playerNo.setText("You are player 2!");
                above.setText("Waiting for player 1 to start the game!");
                fromServer.readUTF();
            }
            
            hangmanStatus();
            
        } catch (Exception e) {
            long endTime = System.currentTimeMillis() + 10000;
            while (true) {
                if (endTime < System.currentTimeMillis()) {
                    System.exit(0);
                } else {
                    waiting.setText(finalResult);
                    above.setText(" .. [ Closing in " + (int) ((endTime / 1000.0) - (System.currentTimeMillis() / 1000.0)) + "]");
                }
            }
        }
        
    }
    
    public static void connectToServer() {
        try {
            serverSocket = new Socket("localhost", 4444);  // connecting to server at specified IP address and port number using a TCP connection
            System.out.println(new Date() + " Connecting to server\n");
            fromServer = new DataInputStream(serverSocket.getInputStream()); // creating an output stream to recieve Input from server
            toServer = new DataOutputStream(serverSocket.getOutputStream()); // creating an output stream to send data to the server
            System.out.println(new Date() + " Connected to server\n");
            
        } catch (IOException e) {
            System.out.println(e);
            // error meddage if the client tries to connect to the server when it is disconnected
            System.out.println(new Date() + " Failed to Connect\n");
            System.out.println("Server is Disconnected, Error");
            System.exit(0);
        }
    }

    //-----------------receive gama status from the server----------------------
    public static void hangmanStatus() throws IOException {
        while (true) {
            //read inf from server
            int playerTurn = fromServer.readInt();
            word = fromServer.readUTF();
            attempts = fromServer.readInt();
            opponent = fromServer.readInt();
            waiting.setText("");
            above.setText("   WORD: " + word + "   Your attempts: " + attempts
                    + "    Opponent's attempts: " + opponent);
            //set image based on attempts
            image(attempts);

            //inform the player that it is their turn 
            if (playerNum == playerTurn) {
                showBoxes();
                waitforAnswer();
                toServer.writeUTF(guess);
            }
            //inform the other player to wait
            if (playerNum != playerTurn) {
                waiting.setText("Waiting for player " + playerTurn + " to guess");
            }
            //read result of player guess from the server
            resultMsg = fromServer.readUTF();
            result.setText(resultMsg);
            //to ask the players if they want to play again when the round is over by someone winning
            if ((resultMsg.contains("WON"))) {
                playAgain();
                continue;
            }
            resultMsg = fromServer.readUTF();
            //to ask the players if they want to play again when the round is over and both lose
            if (resultMsg.contains("both")) {
                result.setText(resultMsg);
                above.setText("   WORD: " + word + "   Your attempts: " + 0
                        + "    Opponent's attempts: " + 0);
                image(0);
                waiting.setVisible(false);
                playAgain();
                clearBoxes();
            } else {
                result.setText(result.getText() + "   " + resultMsg);
                clearBoxes();
            }
        }
    }
    //------------invoked when the round is over--------------------------------
    public static void playAgain() throws IOException {
        String Answer = JOptionPane.showConfirmDialog(null,
                "Do you want play another round?",
                "", JOptionPane.YES_NO_OPTION) == 0 ? "y" : "n";
        toServer.writeUTF(Answer);
        if (Answer.equalsIgnoreCase("n")) {
            finalResult = fromServer.readUTF();
        }
        result.setText("");
        clearBoxes();
    }

    //------------to control the GUI boxes--------------------------------------
    public static void clearBoxes() {
        Enter.setVisible(false);
        GUESS.setVisible(false);
        answer.setVisible(false);
    }
    
    public static void showBoxes() {
        Enter.setVisible(true);
        GUESS.setVisible(true);
        answer.setVisible(true);
    }

    //-----------------to set the image based on attempts-----------------------
    public static void image(int attempts) {
        String imageName = (8 - attempts) + ".png";
        ImageIcon ico = new ImageIcon(imageName);
        Image img = ico.getImage();
        Image imgScale = img.getScaledInstance(label_img.getWidth(), label_img.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        label_img.setIcon(scaledIcon);  // set the game image to the label

    }

    //-----------------to make thread sleep until the guess is obtained---------
    private static void waitforAnswer() {
        guess = "";
        while (guess.isEmpty()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel Enter;
    private static javax.swing.JTextField GUESS;
    private static javax.swing.JLabel above;
    private static javax.swing.JButton answer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private static javax.swing.JLabel label_img;
    private static javax.swing.JLabel label_img1;
    private static javax.swing.JLabel label_playerNo;
    private static javax.swing.JLabel result;
    private static javax.swing.JLabel waiting;
    // End of variables declaration//GEN-END:variables
}
