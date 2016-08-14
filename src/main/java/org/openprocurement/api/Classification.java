
package org.openprocurement.api;

public class Classification {

    private String scheme;
    private String description;
    private String id;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Classification() {
    }

    /**
     * 
     * @param id
     * @param scheme
     * @param description
     */
    public Classification(String scheme, String description, String id) {
        this.scheme = scheme;
        this.description = description;
        this.id = id;
    }

    /**
     * 
     * @return
     *     The scheme
     */
    public String getScheme() {
        return scheme;
    }

    /**
     * 
     * @param scheme
     *     The scheme
     */
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public Classification withScheme(String scheme) {
        this.scheme = scheme;
        return this;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public Classification withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    public Classification withId(String id) {
        this.id = id;
        return this;
    }

}
