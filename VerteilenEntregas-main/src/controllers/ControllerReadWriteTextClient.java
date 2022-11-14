package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import model.bean.ModelClient;

public class ControllerReadWriteTextClient extends ControllerReadWriteText {

    private ModelClient client;
    List<ModelClient> clientList;
   
    public List<ModelClient> getClient() {
        return clientList;
    }
   
    public void setClient(List<ModelClient> clientList) {
        this.clientList = clientList;
    }

    public void readClient() {
        setFile("Abrir");
        readContent();
        String aux = getText();

        clientList = new ArrayList<>();
        String tk = String.valueOf('\t') + String.valueOf('\n');
        StringTokenizer stringTokenizer = new StringTokenizer(aux, tk);
        while (stringTokenizer.hasMoreTokens()) {
            client = new ModelClient();

            client.setName(stringTokenizer.nextToken());
            client.setCpf(stringTokenizer.nextToken());
            client.setPhoneNumber(stringTokenizer.nextToken());
            client.setEmail(stringTokenizer.nextToken());
            client.getAdress().setState(stringTokenizer.nextToken());
            client.getAdress().setCity(stringTokenizer.nextToken());
            client.getAdress().setStreetName(stringTokenizer.nextToken());
            client.getAdress().setNumber(Integer.parseInt(stringTokenizer.nextToken()));

            clientList.add(client);
        }
    }

    public void writeClient(List<ModelClient> list, boolean append) {
        String aux;

        if (list == null) {
            JOptionPane.showMessageDialog(null, "Nenhuma alteração foi realizada", "Inalterado", JOptionPane.WARNING_MESSAGE);
        } else {
            for (int i = 0; i < list.size(); i++) {
                aux = list.get(i).getName() + "\t"
                        + list.get(i).getCpf() + "\t"
                        + list.get(i).getPhoneNumber() + "\t"
                        + list.get(i).getEmail() + "\t"
                        + list.get(i).getAdress().getState() + "\t"
                        + list.get(i).getAdress().getCity() + "\t"
                        + list.get(i).getAdress().getStreetName() + "\t"
                        + String.valueOf(list.get(i).getAdress().getNumber()) + "\t\n";
                setText(aux);
            }
            setFile("Salvar");
            writeContent(append);
        }
    }

}
