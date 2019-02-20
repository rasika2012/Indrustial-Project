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
        if(ip.length()>0)
        requester(ip);
    }
    static public boolean getStatus(String ip){
        return true;
    }
    static public void setSetings(Setings setings){
        
    }
    
    


    private static void requester(String ip) throws Exception {
        String host="http://"+ip;
        URL yahoo = new URL(host.toString());
        System.out.print(host);
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
