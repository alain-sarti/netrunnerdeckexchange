package de.technophilia.netrunnerdeckexchange.events;

import de.technophilia.netrunnerdeckexchange.models.Deck;

/**
 * Created by alainsarti on 25.04.17.
 */

public class DeckEvent {
    Deck deck;

    public DeckEvent(Deck deck) {
        this.deck = deck;
    }

    public Deck getDeck() {
        return deck;
    }
}
