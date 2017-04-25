package de.technophilia.netrunnerdeckexchange.models;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by alainsarti on 25.04.17.
 */

public class Card {
    URL imageUrl;
    String factionCode;
    String title;

    Card(String url, String factionCode, String title) {
        this.factionCode = factionCode;
        this.title = title;
        try {
            this.imageUrl = new URL(url);
        } catch (MalformedURLException e) {
            this.imageUrl = null;
        }
    }
}
