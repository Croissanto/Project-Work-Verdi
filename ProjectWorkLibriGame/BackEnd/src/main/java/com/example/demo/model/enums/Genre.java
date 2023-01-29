package com.example.demo.model.enums;

public enum Genre {
	ACTION("Action"),
	HORROR("Horror"),
	FANTASY("Fantasy"),
	CRIME("Crime"),
	THRILLER("Thriller"),
	COMEDY("Comedy"),
	ROMANCE("Romance"),
	MYTHS("Myths"),
	HISTORY("History"),
	SCI_FI("Sci-Fi"),
	SPORT("Sport");

	public String label;

    private Genre(String label) {
        this.label = label;
    }

	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label=label;
	}
	
}
