
package model.bean;

public class ModelProduct implements java.io.Serializable{
    private static long serialVersionUID = 1L;
    private int id;
    private String name;
    private String loadCategory;
    private String stackingCapacity;

    public ModelProduct(){
        this.name = "";
        this.loadCategory = "";
        this.stackingCapacity = "";
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
     * @return the name
     */
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
     * @return the loadCategory
     */
    public String getLoadCategory() {
        return loadCategory;
    }

    /**
     * @param loadCategory the loadCategory to set
     */
    public void setLoadCategory(String loadCategory) {
        this.loadCategory = loadCategory;
    }

    /**
     * @return the stackingCapacity
     */
    public String getStackingCapacity() {
        return stackingCapacity;
    }

    /**
     * @param stackingCapacity the stackingCapacity to set
     */
    public void setStackingCapacity(String stackingCapacity) {
        this.stackingCapacity = stackingCapacity;
    }
}
