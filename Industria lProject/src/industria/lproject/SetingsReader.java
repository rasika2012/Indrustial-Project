/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package industria.lproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Rasika
 */
class SetingsReader {

    static void save() {
        String fileName = "./setings.pdn";
        File setingsFile = new File(fileName);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(setingsFile))) 
        {
            System.out.println("File was written to: "  + setingsFile.getCanonicalPath());
            for(int i =1; i <6;i++){
                bw.write(Setings.getName(i)+"\n");
                bw.write(Setings.getIp(i)+"\n");
            }
            
            
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
         //To change body of generated methods, choose Tools | Templates.
    }
    
    static void reload() {
        String fileName = "./setings.pdn";
        File setingsFile = new File(fileName);

        try (BufferedReader rw = new BufferedReader(new FileReader(setingsFile))) 
        {
            System.out.println("File was written to: "  + setingsFile.getCanonicalPath());
            for(int i =1; i <6;i++){
                Setings.setName(rw.readLine(), i);
                Setings.setIp(rw.readLine(), i);
            }
            
            
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
         //To change body of generated methods, choose Tools | Templates.
    }
   
}
