package de.technophilia.netrunnerdeckexchange.events;

import java.util.ArrayList;

import de.technophilia.netrunnerdeckexchange.models.Card;

/**
 * Created by alainsarti on 26.04.17.
 */

public class CardsEvent {
    ArrayList<Card> cards;

    public CardsEvent(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
