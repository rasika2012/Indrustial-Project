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
public class IndustriaLProject {

    /**
     * @param args the command line arguments
     */
    static DeviceConector dc = new DeviceConector();
    static GUI gui = new GUI();
    static SetingsReader sr = new SetingsReader();
    public static void main(String[] args) {
        // TODO code application logic here
        gui=gui.display();
        SetingsReader.reload();
        //gui.setOff(0);
        controler();
    }
    
    public static void controler(){
        Thread t = new Thread() {
            public void run() {
                while(true){
                    for(int i =0;i<6;i++){
                        gui.setTitles(i);
                        boolean state =Setings.getL(i);
                        if(state){
                            gui.setOn(i);
                        }else{
                            gui.setOff(i);
                        }
                    }
              
                }
            }
        };
        t.start();
        
    }
    
}
