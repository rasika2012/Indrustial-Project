/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package industria.lproject;
import java.net.*;
import java.io.*;
/**
 *
 * @author Rasika
 */
class DeviceConector {
    static public void setStatus(String ip) throws Exception{
        requester(ip);
    }
    static public boolean getStatus(String ip){
        return true;
    }
    static public void setSetings(Setings setings){
        
    }
    
    


    private static void requester(String ip) throws Exception {
        URL yahoo = new URL("http://192.168.8.1");
        URLConnection yc = yahoo.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                yc.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
        in.close();
    }

}
