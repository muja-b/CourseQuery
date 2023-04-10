import java.io.*;
import java.net.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class mainUDP_client {
    public static void main(String args[]) throws IOException {
        String Data;
    BufferedReader userInput =new BufferedReader(new InputStreamReader(System.in));
    DatagramSocket Csocket =new DatagramSocket();
    InetAddress IP =InetAddress.getByName("");
    while(true){
        byte [] dataSent=new byte[1024];
        byte [] dataReceived=new byte[1024];
        System.out.println("course number pls");
        Data =userInput.readLine();
        if(Data.equalsIgnoreCase("exit")){
            Csocket.close();
            System.exit(0);
        }
        dataSent=Data.getBytes();
        DatagramPacket dataPacketSent=new DatagramPacket(dataSent,dataSent.length,IP,8888);
        Csocket.send(dataPacketSent);
        DatagramPacket dataPacketReceived=new DatagramPacket(dataReceived,dataReceived.length);
        Csocket.receive(dataPacketReceived);
        String modSentence=new String(dataPacketReceived.getData());
        System.out.println("DATA:"+modSentence);
    }
    }
}
