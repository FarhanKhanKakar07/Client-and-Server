/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Farhan
 */
public class ServerFrame extends javax.swing.JFrame {

    /**
     * Creates new form ServerFrame
     */
    public ServerFrame() {
        initComponents();
        //In this we added the action listener in the Text field
        jTextField1.addActionListener((java.awt.event.ActionEvent e) -> {
            sendData();
        });
        
        
        //Toolkit.getDefaultToolkit().beep();
        
    }
    
    
    
        // We have created method to start server
        void Server() {
            // we use port no 808p
            int port=8080; 
            //To get the port we used try and catch exception
            try{port=Integer.parseInt(portField.getText()); }catch(Exception e){}
            //For error handling we used try and catch
        try (ServerSocket serverSocket = new ServerSocket(port)) { 
        System.out.println("Server started on port "+port);
        //It will show the message in the TextArea
        box.append("Server started on port "+port+"\n");
        //After connection the button get disabled
        startButton.setEnabled(false);
        while (true) {
            try {
                // Accept a client connection
                Socket clientSocket = serverSocket.accept(); 
                //It runs the input stream to get data
                InputStream fin = clientSocket.getInputStream(); 
                // It sleep the software for 2 milli seconds
                Thread.sleep(200);
                // Read data from the client
                byte[] b = new byte[fin.available()]; 
                fin.read(b); // Read data into the buffer

                    // Convert bytes to string
                    String data = new String(b);
                    System.out.println("Data:"+data);
                    //It shows the message in the Textarea
                    box.append("Client : " + data + "\n");
                    //Created responses in string
                    String response=""; 
                    
                    if (data.trim().isEmpty() || data.contains("<") || data.contains("#")
                            || data.contains("&") || data.contains("@") || data.contains("!")
                            || data.contains("%")|| data.contains("*")|| data.contains("/")
                            || data.contains("^")|| data.contains(";")|| data.contains(":")) {
                    response = "Error: Invalid message Contains \n <,!,@,#,&,%,*,^,;,;";
                    } else {
                    switch(data.toLowerCase()){
                        case "hello": response="Hi How are you."; break;
                        case "how are you?": response="I am good."; break;
                        case "what is your name?": response="I am your friendly server assistant."; break;
                        case "What do you do?": response="I help my Clients."; break;
                        case "How is your day?": response="It's Quite Good."; break;
                        case "2+2=": response="4"; break;
                        case "I need your help": response="Sure I'm here to assist you."; break;
                        case "How many days are in a week": response="There are 7 days in week."; break;
                        case "What is your port number": response="I'm connected with 8080 port."; break;
                        case "What can you do?": response="I can answer questions, provide information, and assist with various tasks!"; break;
                        case "Do you work like AI?": response="Yes I'm like AI. i assist my Clients."; break;

                        default: 
                        response = "Error: Message! Try: hello, how are you.";
                        break;

                    }
                    }
                    //It runs the output stram to get the data
                    OutputStream out=clientSocket.getOutputStream(); 
                    //It shows the message
                    box.append("Server : " + response + "\n");
                    //for checking the reponse fully works
                    System.out.println("Response:"+response);
                   //writes the response
                   out.write(response.getBytes());
                   //flush is used to send Data
                   out.flush();
                    
                    // Append data to the box to shows the messages in textarea
                    //box.append("Client: " + data + "\n"); 
                
                // Software Sleeps for 2 seconds
                   Thread.sleep(2000);
                clientSocket.close(); 
            } catch (Exception e) {
                // Log the error
                System.err.println("Error handling client: " + e.getMessage()); 
            }
        }
    } catch (Exception e) {
        // Log server errors
        System.err.println("Server error: " + e.getMessage()); 
    }
}
    
        public String processData(String data){
            String tr=""; 
            String[] d=data.split(":"); 
            switch(d[0]){
                case "connect": 
                    box.append(d[1]+" connected!\n");
                    tr= "connected"; 
                    break; 
            
            }
            
            
        return tr; 
        }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        portField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        box = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();

        jLabel2.setText("Port");

        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        box.setColumns(20);
        box.setRows(5);
        box.setFocusable(false);
        jScrollPane1.setViewportView(box);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 38, 287, 230);

        jLabel1.setText("SERVER");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 14, 73, 16);

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        getContentPane().add(startButton);
        startButton.setBounds(200, 10, 90, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
        new Thread(new Runnable(){public void run(){
            //starts the server
        Server(); 
        }}).start();
        
    }//GEN-LAST:event_startButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here
        //    sendData();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
     void sendData(){
    String data=jTextField1.getText();

    if (data.isEmpty()) {
        // Ignore blank message, do nothing
        return;
    }
    //empty the textfield initially
    jTextField1.setText("");
    //shows the messages
    box.append("Server : "+data+"\n");
    try{ //exceptions handling with try and catch 
        //make the port connection b/w server and client
    Socket socket=new Socket("localhost",5000); 
    
    OutputStream out=socket.getOutputStream();
    //gets the byte message
    out.write(data.getBytes());
    //to ensure the data is sent
    out.flush();
    
    }catch(Exception e){}
    //error handling
    
    }

     
     
     
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea box;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField portField;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
