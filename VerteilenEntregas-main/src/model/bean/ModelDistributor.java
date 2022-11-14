package model.bean;

public class ModelDistributor implements java.io.Serializable{
    private static long serialVersionUID = 1L;
    private int id;
    private String distributorName;
    private String distributorCNPJ;    
    private String distributorMail;    
    private String phoneNumber;
    private String loadType;
    private String splitMaxCapacity;
    private String unitMaxCapacity;
    private ModelAdress adress;
    
    public ModelDistributor(){
        this.distributorName = "";
        this.distributorCNPJ = "";
        this.adress = new ModelAdress();
        this.distributorMail = "";    
        this.phoneNumber = "";
        this.loadType = "";
        this.splitMaxCapacity = "";
        this.unitMaxCapacity = "";
    }
    
     /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * @return the distributorName
     */
    public String getDistributorName() {
        return distributorName;
    }

    /**
     * @param distributorName the distributorName to set
     */
    public void setDistributorName(String distributorName) {
        this.distributorName = distributorName;
    }

    /**
     * @return the distributorCNPJ
     */
    public String getDistributorCNPJ() {
        return distributorCNPJ;
    }

    /**
     * @param distributorCNPJ the distributorCNPJ to set
     */
    public void setDistributorCNPJ(String distributorCNPJ) {
        this.distributorCNPJ = distributorCNPJ;
    }

    /**
     * @return the adress
     */
    public ModelAdress getAdress() {
        return adress;
    }
    /**
     * @param adress the adress to set
     */
    public void setAdress(ModelAdress adress) {
        this.adress = adress;
    }

    /**
     * @return the distributosMail
     */
    public String getDistributosMail() {
        return distributorMail;
    }

    /**
     * @param distributosMail the distributosMail to set
     */
    public void setDistributosMail(String distributosMail) {
        this.distributorMail = distributosMail;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the loadType
     */
    public String getLoadType() {
        return loadType;
    }

    /**
     * @param loadType the loadType to set
     */
    public void setLoadType(String loadType) {
        this.loadType = loadType;
    }

    /**
     * @return the splitMaxCapacity
     */
    public String getSplitMaxCapacity() {
        return splitMaxCapacity;
    }

    /**
     * @param splitMaxCapacity the splitMaxCapacity to set
     */
    public void setSplitMaxCapacity(String splitMaxCapacity) {
        this.splitMaxCapacity = splitMaxCapacity;
    }

    /**
     * @return the unitMaxCapacity
     */
    public String getUnitMaxCapacity() {
        return unitMaxCapacity;
    }

    /**
     * @param unitMaxCapacity the unitMaxCapacity to set
     */
    public void setUnitMaxCapacity(String unitMaxCapacity) {
        this.unitMaxCapacity = unitMaxCapacity;
    }
    
}
