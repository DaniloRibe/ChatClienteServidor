/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpclient;

import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class TCPClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Socket s = null;
        Scanner tc = new Scanner(System.in);
        while (true) {
            System.out.print("mensagem:");
            String mensagem = tc.nextLine();

            try {
                int serverPort = 6789;
                s = new Socket("localhost", serverPort);

                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                out.writeUTF(mensagem);        	// UTF is a string encoding see Sn 4.3
                DataInputStream in = new DataInputStream(s.getInputStream());
                String data = in.readUTF();
                System.out.println("Received: " + data);
            } catch (UnknownHostException e) {
                System.out.println("Sock:" + e.getMessage());
            } catch (EOFException e) {
                System.out.println("EOF:" + e.getMessage());
            } catch (IOException e) {
                System.out.println("IO:" + e.getMessage());
            } finally {
                if (s != null) {
                    try {
                        s.close();
                    } catch (IOException e) {
                        System.out.println("close:" + e.getMessage());
                    }
                }
            }
        }
    }
}