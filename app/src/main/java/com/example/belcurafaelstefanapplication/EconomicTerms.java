package com.example.belcurafaelstefanapplication;

public class EconomicTerms {

    private String economicterm;
    private String termdefinition;

    public EconomicTerms(String economicterm, String termdefinition) {
        this.economicterm = economicterm;
        this.termdefinition = termdefinition;
    }

    public String geteconomicterm() {
        return economicterm;
    }

    public void seteconomicterm(String economicterm) {
        this.economicterm = economicterm;
    }

    public String gettermdefinition() {
        return termdefinition;
    }

    public void settermdefinition(String termdefinition) {
        this.termdefinition = termdefinition;
    }
}
