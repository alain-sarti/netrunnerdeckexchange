package de.technophilia.netrunnerdeckexchange.netrunnerdb;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import de.technophilia.netrunnerdeckexchange.models.Card;

/**
 * Created by alainsarti on 26.04.17.
 */

public class CardFactory {
    private final static String DATA ="data";
    private final static String URL ="imageUrlTemplate";
    private final static String FACTION_CODE ="faction_code";
    private final static String TITLE ="title";
    private final static String CODE ="code";

    public static Card loadCard(JSONObject json) {
        Card card = null;

        try {
            JSONObject data = json.getJSONArray(DATA).getJSONObject(0);
            String url = json.getString(URL).replace("{code}", json.getString(CODE));
            card = new Card(url, data.getString(FACTION_CODE), data.getString(TITLE));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return card;
    }

    public static ArrayList<Card> loadCards(JSONArray json) {
        ArrayList<Card> cards = null;
        //TODO: implement!
        return cards;
    }
}
