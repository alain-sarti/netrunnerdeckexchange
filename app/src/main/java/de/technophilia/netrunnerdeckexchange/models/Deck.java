package de.technophilia.netrunnerdeckexchange.models;

import java.util.ArrayList;

/**
 * Created by alainsarti on 25.04.17.
 */

public class Deck {
    String name;
    String description;
    ArrayList<Card> deckList;

    public Deck(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Card> getDeckList() {
        return deckList;
    }

    public void setDeckList(ArrayList<Card> deckList) {
        this.deckList = deckList;
    }
}
