import java.io.*;
import java.net.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class mainTCP_server {
    public static void main(String args[]) throws IOException {
        String coursename;
        String Csentence;
        boolean request;
        File myfile=new File("C:\\Users\\muja\\IdeaProjects\\network\\src\\mytxt.txt");
        Scanner myscan=new Scanner(myfile);
        ServerSocket myserverSocket = new ServerSocket(7788);
        while(true){
        request= true;
        Socket connectionSocket = myserverSocket.accept();
        myscan=new Scanner(myfile);

        BufferedReader Cinput=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        DataOutputStream Couput=new DataOutputStream(new DataOutputStream(connectionSocket.getOutputStream()));
        Csentence=Cinput.readLine();
        coursename="";
        while (myscan.hasNextLine()){
                String Data =myscan.nextLine();
                String[] seq =Data.split(" ");
                if(seq[0].equals(Csentence)){
                    for(int i = 1; i < seq.length; i++){
                        coursename=coursename +" "+seq[i];
                        request=false;
                    }
                }


        }
        if(request){
            coursename="ERORR404";
        }
        String readysentence =coursename+"\n";
        Couput.writeBytes(readysentence);
    }

    }
}
