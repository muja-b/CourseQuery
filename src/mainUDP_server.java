import java.io.*;
import java.net.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
public class mainUDP_server {
    public static void main(String args[]) throws IOException {
        String course;
        DatagramSocket Ssocket =new DatagramSocket(8888);
        File myFile=new File("C:\\Users\\muja\\IdeaProjects\\network\\src\\mytxt.txt");
        boolean request;
        while(true){
            byte[] dataSent=new byte[1024];
            byte[] dataReceived =new byte[1024];
            String Data;

            Scanner myScan=new Scanner(myFile);
            request=true;

            DatagramPacket packetsReceived =new DatagramPacket(dataReceived,dataReceived.length);
            Ssocket.receive(packetsReceived);
            Data =new String(packetsReceived.getData());
            InetAddress IP =packetsReceived.getAddress();
            int portNum =packetsReceived.getPort();
            System.out.println(Data);
            course="";
            while (myScan.hasNextLine()){
                String data =myScan.nextLine();
                String[] words=data.split(" ");
                System.out.println(Data.trim()+" "+words[0].trim());
                if(words[0].trim().equalsIgnoreCase(Data.trim())) {
                    for(int i=1;i<words.length;i++){
                        course=course+" "+words[i];
                        request=false;
                    }


                    }
                }
            if(request){
                course="ERORR404";
            }
            dataSent=course.getBytes(StandardCharsets.UTF_8);
            DatagramPacket packetSent =new DatagramPacket(dataSent,dataSent.length,IP,portNum);
            Ssocket.send(packetSent);
            }

        }

    }

