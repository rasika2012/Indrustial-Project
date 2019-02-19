/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package industria.lproject;

/**
 *
 * @author Rasika
 */


class Setings {
    static boolean lightState[] = new boolean[5];
    static String ips[] = new String[5];
    
    public void setIp(String ip,int adr){
        ips[adr]=ip;
    }
    public String getIp(int adr){
        return ips[adr];
    }
    
    public void setL(boolean ip,int adr){
        lightState[adr]=ip;
    }
    public boolean getL(int adr){
        return lightState[adr];
    }
}
