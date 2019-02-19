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
    static boolean lightState[] = new boolean[6];
    static String ips[] = new String[6];
    
    static public void setIp(String ip,int adr){
        ips[adr]=ip;
    }
    static public String getIp(int adr){
        return ips[adr];
    }
    
    static public void setL(int adr,boolean state){
        lightState[adr-1]=state;
    }
    static public boolean getL(int adr){
        return lightState[adr];
    }
    static public void flip(int adr){
        lightState[adr] = lightState[adr] ^ true;
        refresh();
        sendReq(adr,lightState[adr]);
    }
    private static void refresh(){
        if(lightState[1]&& lightState[2]&&lightState[3]&&lightState[4]&&lightState[5]){
            lightState[0]=true;
        }else{
            lightState[0]=false;
        }
    }
    static void flipAll() {
        if( lightState[0]){
            for (int i =0;i<6;i++){
                lightState[i]=false;
                sendReq(i,false);
            }
        }else{
            for (int i =0;i<6;i++){
                lightState[i]=true;
                sendReq(i,true);
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private static void sendReq(int adr,boolean state){
        if(adr>0){
            System.out.println("Request Sent to:"+ adr + ":"+state);
        }
    }
    static void stop() {
        for (int i =0;i<6;i++){
                lightState[i]=false;
                sendReq(i,false);
        }//To change body of generated methods, choose Tools | Templates.
    }
}
