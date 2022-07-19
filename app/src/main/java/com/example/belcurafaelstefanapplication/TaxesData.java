package com.example.belcurafaelstefanapplication;


public class TaxesData {

    private String taxName;
    private String taxDefinition;
    private Integer taxImage;

    public TaxesData(String taxName, String taxDefinition, Integer taxImage) {
        this.taxName = taxName;
        this.taxDefinition = taxDefinition;
        this.taxImage = taxImage;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public String getTaxDefinition() {
        return taxDefinition;
    }

    public void setTaxDefinition(String taxDefinition) {
        this.taxDefinition = taxDefinition;
    }

    public Integer getTaxImage() {
        return taxImage;
    }

    public void setTaxImage(Integer taxImage) {
        this.taxImage = taxImage;
    }
}

