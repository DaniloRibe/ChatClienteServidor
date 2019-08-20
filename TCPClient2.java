/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpclient2;

import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class TCPClient2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        String clientSentence;
        ServerSocket welcomeSocket = new ServerSocket(6789);
        DataOutputStream out;
        Scanner tc = new Scanner(System.in);

        
        
        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            //System.out.println("Conexao aceita. \nPorta Cliente Remoto: "
                //+ connectionSocket.getPort() + "\nPorta Local: "
                //+ connectionSocket.getLocalPort());
            
            
            DataInputStream in;
            in = new DataInputStream(connectionSocket.getInputStream());
            clientSentence = in.readUTF();
            System.out.println("Recebido: " + clientSentence);
            
            System.out.print("Mensagem: ");

            out = new DataOutputStream(connectionSocket.getOutputStream());

            String mensagem = tc.nextLine();

            //System.out.println("processando...");
            //Thread.sleep((int) (Math.random() * 1000));
            //Thread.sleep(100);
            //System.out.println("processamento finalizado");
            //capitalizedSentence = clientSentence.toUpperCase() + '\n';
            out.writeUTF(mensagem);
        }

    }

}
