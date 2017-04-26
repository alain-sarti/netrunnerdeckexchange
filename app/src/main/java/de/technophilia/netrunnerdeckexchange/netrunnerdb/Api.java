package de.technophilia.netrunnerdeckexchange.netrunnerdb;

import android.util.Log;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import de.technophilia.netrunnerdeckexchange.events.CardsEvent;
import de.technophilia.netrunnerdeckexchange.events.DeckEvent;
import de.technophilia.netrunnerdeckexchange.models.Card;

/**
 * Created by alainsarti on 23.04.17.
 */

public class Api {
    private static final String TAG = "NDB-API";
    private static final String GET_DECK = "public/decklist/";
    private static final String GET_ALL_CARDS = "public/cards";

    public void loadDeck(int deckId) {
        RestClient.get(GET_DECK + deckId, null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                EventBus.getDefault().post(new DeckEvent(DeckFactory.buildDeck(response)));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d(TAG, throwable.toString());
            }
        });
    }

    public void loadAllCards() {
        RestClient.get(GET_ALL_CARDS, null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                EventBus.getDefault().post(new CardsEvent(CardFactory.loadCards()));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d(TAG, throwable.toString());
            }
        });
    }
}
