import java.io.*;
import java.net.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class mainTCP_client {
    public static void main(String args[]) throws IOException {
        String sentence;
        BufferedReader Inputuser = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            Socket CSocket = new Socket("", 7788);
            DataOutputStream serverOut =new DataOutputStream(CSocket.getOutputStream());
            BufferedReader serverIn =new BufferedReader(new InputStreamReader(CSocket.getInputStream()));
            System.out.println("course number pls :");
            sentence =Inputuser.readLine();
            if(sentence.equalsIgnoreCase("EXIT")){
                CSocket.close();
                System.exit(0);
            }
            serverOut.writeBytes(sentence+'\n');
            String modSentence =serverIn.readLine();
            System.out.println("Stored course name:"+modSentence);
        }
    }
}
