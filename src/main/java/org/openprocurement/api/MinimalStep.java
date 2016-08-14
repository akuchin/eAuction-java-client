
package org.openprocurement.api;

public class MinimalStep {

    private String currency;
    private Double amount;
    private Boolean valueAddedTaxIncluded;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MinimalStep() {
    }

    /**
     * 
     * @param amount
     * @param valueAddedTaxIncluded
     * @param currency
     */
    public MinimalStep(String currency, Double amount, Boolean valueAddedTaxIncluded) {
        this.currency = currency;
        this.amount = amount;
        this.valueAddedTaxIncluded = valueAddedTaxIncluded;
    }

    /**
     * 
     * @return
     *     The currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 
     * @param currency
     *     The currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public MinimalStep withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * 
     * @return
     *     The amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * 
     * @param amount
     *     The amount
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public MinimalStep withAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    /**
     * 
     * @return
     *     The valueAddedTaxIncluded
     */
    public Boolean getValueAddedTaxIncluded() {
        return valueAddedTaxIncluded;
    }

    /**
     * 
     * @param valueAddedTaxIncluded
     *     The valueAddedTaxIncluded
     */
    public void setValueAddedTaxIncluded(Boolean valueAddedTaxIncluded) {
        this.valueAddedTaxIncluded = valueAddedTaxIncluded;
    }

    public MinimalStep withValueAddedTaxIncluded(Boolean valueAddedTaxIncluded) {
        this.valueAddedTaxIncluded = valueAddedTaxIncluded;
        return this;
    }

}
