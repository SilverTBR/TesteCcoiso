package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import model.bean.ModelDistributor;

public class ControllerReadWriteTextDistributor extends ControllerReadWriteText {

    private ModelDistributor distributor;
    List<ModelDistributor> distributorList;

    public List<ModelDistributor> getDistributor() {
        return distributorList;
    }
    
    public void setDistributor(List<ModelDistributor> distributorList) {
        this.distributorList = distributorList;
    }

    public void readDistributor() {
        setFile("Abrir");
        readContent();
        String aux = getText();

        distributorList = new ArrayList<>();
        String tk = String.valueOf('\t') + String.valueOf('\n');
        StringTokenizer stringTokenizer = new StringTokenizer(aux, tk);
        while (stringTokenizer.hasMoreTokens()) {
            distributor = new ModelDistributor();

            distributor.setDistributorName(stringTokenizer.nextToken());
            distributor.setDistributorCNPJ(stringTokenizer.nextToken());
            distributor.setDistributosMail(stringTokenizer.nextToken());
            distributor.setPhoneNumber(stringTokenizer.nextToken());
            distributor.setLoadType(stringTokenizer.nextToken());
            distributor.setSplitMaxCapacity(stringTokenizer.nextToken());
            distributor.setUnitMaxCapacity(stringTokenizer.nextToken());
            distributor.getAdress().setState(stringTokenizer.nextToken());
            distributor.getAdress().setCity(stringTokenizer.nextToken());
            distributor.getAdress().setStreetName(stringTokenizer.nextToken());
            distributor.getAdress().setNumber(Integer.parseInt(stringTokenizer.nextToken()));

            distributorList.add(distributor);
        }
    }

    public void writeDistributor(List<ModelDistributor> list, boolean append) {
        String aux;

        if (list == null) {
            JOptionPane.showMessageDialog(null, "Nenhuma alteração foi realizada", "Inalterado", JOptionPane.WARNING_MESSAGE);
        } else {
            for (int i = 0; i < list.size(); i++) {
                aux = list.get(i).getDistributorName() + "\t"
                        + list.get(i).getDistributorCNPJ() + "\t"
                        + list.get(i).getDistributosMail() + "\t"
                        + list.get(i).getPhoneNumber() + "\t"
                        + list.get(i).getLoadType() + "\t"
                        + list.get(i).getSplitMaxCapacity() + "\t"
                        + list.get(i).getUnitMaxCapacity() + "\t"
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
