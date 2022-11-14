package controllers;

import java.io.File;
import javax.swing.JFileChooser;

public abstract class ControllerReadWriteAbstract {
    public File file = null;
    
    // MÉTODOS A SEREM IMPLEMENTADOS
    public abstract boolean readContent();
    public abstract boolean writeContent(boolean append);
    
    public File getFile(){
        return file;
    }    
    
    public void setFile(String textButton){
        file = null;
        String initialDirectory = System.getProperty("user.dir");
        JFileChooser chooser = new JFileChooser(initialDirectory);
        if(chooser.showDialog(null, textButton) == JFileChooser.APPROVE_OPTION){
            file = chooser.getSelectedFile();
        }
    }
}
