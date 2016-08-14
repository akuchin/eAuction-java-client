
package org.openprocurement.api;

public class Identifier {

    private String scheme;
    private String id;
    private String legalName;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Identifier() {
    }

    /**
     * 
     * @param id
     * @param legalName
     * @param scheme
     */
    public Identifier(String scheme, String id, String legalName) {
        this.scheme = scheme;
        this.id = id;
        this.legalName = legalName;
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

    public Identifier withScheme(String scheme) {
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

    public Identifier withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The legalName
     */
    public String getLegalName() {
        return legalName;
    }

    /**
     * 
     * @param legalName
     *     The legalName
     */
    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public Identifier withLegalName(String legalName) {
        this.legalName = legalName;
        return this;
    }

}
