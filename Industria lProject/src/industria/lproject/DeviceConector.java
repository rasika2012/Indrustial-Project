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
    static public void setStatus(int id) throws Exception{
        if(Setings.getL(id)){
            
            requester(id,"on");
        }else{
            requester(id,"off");
        }
        
    }
    static public void getStatus(int id) throws Exception{
        requester(id,"status");
    }
    static public void setSetings(Setings setings){
        
    }
    
    


    private static void requester(int id,String type) throws Exception {
        
        String ip = Setings.getIp(id);
        String respond=null;
        if(ip!=null && ip.length()>3){
            String host="http://"+ip+"/"+type;
            URL yahoo = new URL(host.toString());
            System.out.print(host);
            URLConnection yc = yahoo.openConnection();
            BufferedReader in = new BufferedReader(
                                    new InputStreamReader(
                                    yc.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) 
                respond = inputLine;
            in.close();
        }
        if(respond!=null){
            System.out.println("\n"+respond);
            if(respond.equals("HIGH")){
                Setings.setL(id, true);
            }else if(respond.equals("LOW")){
                Setings.setL(id, false);
            }
        }
    }

}
