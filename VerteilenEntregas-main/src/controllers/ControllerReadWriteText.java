package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerReadWriteText extends ControllerReadWriteAbstract{

    private String text = null;
    private BufferedReader reader = null;
    private BufferedWriter writer = null;
    
    public String getText() {
        return text;
    }

    public void setText(String texto) {
        this.text = texto;
    }
    
    // Trabalhar com array de objetos, quebrar pra jogar na tela
    
    @Override
    public boolean readContent() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            while(reader.ready()){
                stringBuilder.append(reader.readLine());
            } 
            reader.close();
            setText(stringBuilder.toString());
            return true;
        }catch (FileNotFoundException ex) {
            Logger.getLogger(ControllerReadWriteText.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControllerReadWriteText.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }   
        
    @Override
    public boolean writeContent(boolean append) {  
        if(file != null){
            try {
                writer = new BufferedWriter(new FileWriter(file, append));
                writer.write(this.getText());
                writer.close();
                return true;            
            } catch (IOException ex) {
                Logger.getLogger(ControllerReadWriteText.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }else{
            return false;
        }       
    }
    
}
