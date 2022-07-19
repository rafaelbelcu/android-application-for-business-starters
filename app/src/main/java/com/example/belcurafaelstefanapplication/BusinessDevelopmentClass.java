package com.example.belcurafaelstefanapplication;

public class BusinessDevelopmentClass {

    private String title, description;
    private boolean expandable;

    public BusinessDevelopmentClass(String title, String description) {
        this.title = title;
        this.description = description;
        this.expandable = false;
    }

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDefinition() {
        return description;
    }

    public void setDefinition(String definition) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BusinessDevelopmentClass{" +
                "title='" + title + '\'' +
                ", definition='" + description + '\'' +
                '}';
    }
}