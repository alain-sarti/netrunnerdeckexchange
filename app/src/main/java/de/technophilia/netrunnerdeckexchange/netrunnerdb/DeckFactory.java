package de.technophilia.netrunnerdeckexchange.netrunnerdb;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import de.technophilia.netrunnerdeckexchange.models.Deck;

/**
 * Created by alainsarti on 25.04.17.
 */

public class DeckFactory {
    private final static String DATA ="data";
    private final static String CARDS ="cards";
    private final static String NAME ="name";
    private final static String DESCRIPTION = "description";

    public static Deck buildDeck(JSONObject json) {
        Deck deck = null;
        try {
            JSONObject data = json.getJSONArray(DATA).getJSONObject(0);
            deck = new Deck(data.getString(NAME), data.getString(DESCRIPTION));

            JSONObject cards = data.getJSONObject(CARDS);
            Log.d("DECKFACTORY", cards.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return deck;
    }
}
