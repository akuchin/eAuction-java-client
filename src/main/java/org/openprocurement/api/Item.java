
package org.openprocurement.api;

import java.util.ArrayList;
import java.util.List;


public class Item {

    private String description;
    private Classification classification;
    private List<AdditionalClassification> additionalClassifications = new ArrayList<AdditionalClassification>();
    private String id;
    private Unit unit;
    private Integer quantity;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Item() {
    }

    /**
     * 
     * @param id
     * @param unit
     * @param description
     * @param classification
     * @param quantity
     * @param additionalClassifications
     */
    public Item(String description, Classification classification, List<AdditionalClassification> additionalClassifications, String id, Unit unit, Integer quantity) {
        this.description = description;
        this.classification = classification;
        this.additionalClassifications = additionalClassifications;
        this.id = id;
        this.unit = unit;
        this.quantity = quantity;
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

    public Item withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * 
     * @return
     *     The classification
     */
    public Classification getClassification() {
        return classification;
    }

    /**
     * 
     * @param classification
     *     The classification
     */
    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public Item withClassification(Classification classification) {
        this.classification = classification;
        return this;
    }

    /**
     * 
     * @return
     *     The additionalClassifications
     */
    public List<AdditionalClassification> getAdditionalClassifications() {
        return additionalClassifications;
    }

    /**
     * 
     * @param additionalClassifications
     *     The additionalClassifications
     */
    public void setAdditionalClassifications(List<AdditionalClassification> additionalClassifications) {
        this.additionalClassifications = additionalClassifications;
    }

    public Item withAdditionalClassifications(List<AdditionalClassification> additionalClassifications) {
        this.additionalClassifications = additionalClassifications;
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

    public Item withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The unit
     */
    public Unit getUnit() {
        return unit;
    }

    /**
     * 
     * @param unit
     *     The unit
     */
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Item withUnit(Unit unit) {
        this.unit = unit;
        return this;
    }

    /**
     * 
     * @return
     *     The quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 
     * @param quantity
     *     The quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Item withQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

}
