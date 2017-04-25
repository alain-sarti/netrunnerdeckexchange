package de.technophilia.netrunnerdeckexchange.netrunnerdb;

import android.util.Log;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by alainsarti on 23.04.17.
 */

public class Api {
    private static final String TAG = "NDB-API";
    private static final String GET_DECK = "public/decklist/";

    public void loadDeck(int deckId) {
        RestClient.get(GET_DECK + deckId, null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                EventBus.getDefault().post(DeckFactory.buildDeck(response));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d(TAG, throwable.toString());
            }
        });
    }
}
