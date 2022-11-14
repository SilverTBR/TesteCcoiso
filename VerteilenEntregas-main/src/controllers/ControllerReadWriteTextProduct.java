package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import model.bean.ModelProduct;

public class ControllerReadWriteTextProduct extends ControllerReadWriteText {

    private ModelProduct product;
    List<ModelProduct> productList;

    public List<ModelProduct> getProduct() {
        return productList;
    }

    public void setProduct(List<ModelProduct> productList) {
        this.productList = productList;
    }

    public void readProduct() {
        setFile("Abrir");
        readContent();
        String aux = getText();

        productList = new ArrayList<>();
        String tk = String.valueOf('\t') + String.valueOf('\n');
        StringTokenizer stringTokenizer = new StringTokenizer(aux, tk);
        while (stringTokenizer.hasMoreTokens()) {
            product = new ModelProduct();

            product.setName(stringTokenizer.nextToken());
            product.setLoadCategory(stringTokenizer.nextToken());
            product.setStackingCapacity(stringTokenizer.nextToken());

            productList.add(product);
        }
    }

    public void writeProduct(List<ModelProduct> list, boolean append) {
        String aux;

        if (list == null) {
            JOptionPane.showMessageDialog(null, "Nenhuma alteração foi realizada", "Inalterado", JOptionPane.WARNING_MESSAGE);
        } else {
            for (int i = 0; i < list.size(); i++) {
                aux = list.get(i).getName() + "\t"
                        + list.get(i).getLoadCategory() + "\t"
                        + list.get(i).getStackingCapacity() + "\t\n";
                setText(aux);
            }
            setFile("Salvar");
            writeContent(append);
        }
    }

}
