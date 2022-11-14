package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ControllerReadWriteBinaryObject extends ControllerReadWriteAbstract {

    private Object object = null;
    private List<Object> objectList = new ArrayList<>();
    private ObjectInputStream reader = null;
    private ObjectOutputStream writer = null;

    public Object getObject() {
        return this.object;
    }

    public void setClient(Object object) {
        this.object = object;
    }

    public List<Object> getListObject() {
        return this.objectList;
    }

    public void setListClient(List<Object> objectList) {
        this.objectList = objectList;
    }

    @Override
    public boolean readContent() {
        try {
            reader = new ObjectInputStream(new FileInputStream(file));
            object = reader.readObject();
            reader.close();
            return true;
        } catch (ClassNotFoundException erro) {            
            System.err.println(erro.getMessage() + "Classe não encontrada.");
            return false;
        } catch (IOException erro) {
            System.err.println(erro.getMessage() + "Erro ao ler arquivo binário.");
            return false;
        }
    }

    @Override
    public boolean writeContent(boolean append) {
        if (file != null) {
            try {
                writer = new ObjectOutputStream(new FileOutputStream(file, append));
                writer.writeObject(this.object);
                writer.close();
                return true;
            } catch (IOException erro) {
                System.err.println(erro.getMessage() + "Erro ao escrever arquivo binário.");
                return false;
            }
        } else {
            return false;
        }
    }

    // Métodos para escrever e ler uma lista
    public boolean readContentList() {
        try {
            reader = new ObjectInputStream(new FileInputStream(file));
            objectList.add(reader.readObject());                

            reader.close();
            return true;
        } catch (ClassNotFoundException erro) {            
            System.err.println(erro.getMessage() + " Classe não encontrada.");
            return false;
        } catch (IOException erro) {
            System.err.println(erro.getMessage() + " Erro ao ler arquivo binário.");
            return false;
        }
    }

    public boolean writeContentList(List<Object> listobj, boolean append) {
        if (file != null) {
            try {                
                writer = new ObjectOutputStream(new FileOutputStream(file, append));
                writer.writeObject(listobj);
                writer.close();
                return true;
            } catch (IOException erro) {
                System.err.println(erro.getMessage() + "Erro ao escrever arquivo binário.");
                return false;
            }
        } else {
            return false;
        }
    }

    public static ObjectOutputStream objectWriterContent(File file, boolean append) {
         ObjectOutputStream out = null;
        try {
            if (file.exists()) {
                FileOutputStream fos = new FileOutputStream(file, true);
                out = new ObjectOutputStream(fos) {

                    @Override
                    protected void writeStreamHeader() {
                        // do not write a header
                    }
                };
            } else {
                FileOutputStream fos = new FileOutputStream(file, true);
                out = new ObjectOutputStream(fos);
            }
        } catch (IOException erro) {
            System.out.println("Erro ao criar arquivo. " + erro);
        }
        return out;
    }

}
