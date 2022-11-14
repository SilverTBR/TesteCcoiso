
package model.bean;

public class ModelClient implements java.io.Serializable{
    private static long serialVersionUID = 1L;
    private int id;
    private String name;
    private String cpf;
    private String email;
    private String phoneNumber;
    private ModelAdress adress;

    /**
     * @return the name
     */
    
    public ModelClient(){
        this.name = "";
        this.cpf = "";
        this.email = "";
        this.phoneNumber = "";
        this.adress = new ModelAdress();
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
    
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

   
}
