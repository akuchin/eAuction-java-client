
package org.openprocurement.api;

public class AdditionalClassification {

    private String scheme;
    private String id;
    private String description;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AdditionalClassification() {
    }

    /**
     * 
     * @param id
     * @param scheme
     * @param description
     */
    public AdditionalClassification(String scheme, String id, String description) {
        this.scheme = scheme;
        this.id = id;
        this.description = description;
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

    public AdditionalClassification withScheme(String scheme) {
        this.scheme = scheme;
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

    public AdditionalClassification withId(String id) {
        this.id = id;
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

    public AdditionalClassification withDescription(String description) {
        this.description = description;
        return this;
    }

}
