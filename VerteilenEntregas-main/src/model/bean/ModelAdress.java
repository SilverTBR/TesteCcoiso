package model.bean;

public class ModelAdress implements java.io.Serializable{
    private static long serialVersionUID = 1L;    
    private String state;
    private String city;
    private String streetName;
    private int number;

    public ModelAdress(){
        this.state = "";
        this.city = "";
        this.streetName = "";
        this.number = 0;
    }    
    
    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the streetName
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * @param streetName the streetName to set
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * @return the streetNumber
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param streetNumber the streetNumber to set
     */
    public void setNumber(int streetNumber) {
        this.number = streetNumber;
    }
    
    
}
