package vilares.mirante.androidperguntas.Service;

import com.google.gson.Gson;

import net.eunainter.r2std2oid.HandleRequests;
import net.eunainter.r2std2oid.RequestR2D2;
import net.eunainter.r2std2oid.ResponseR2D2;
import net.eunainter.r2std2oid.RestObserver;
import net.eunainter.r2std2oid.Skyrunner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Joao Mirante on 28/07/2018.
 */

public class RestConnect implements RestObserver {

    Skyrunner msky;
    JSONArray jsonArray;
    JSONObject jsonObject;
    boolean isFinish = false;

    public RestConnect(String url, byte method, Object obj) {
        this.msky = new Skyrunner(20);
        isFinish = false;
        msky.addObserver(this);
        RequestR2D2 req = HandleRequests.getRequest(url,method);


        if(obj!=null){
            try {
                //req.addParValue("formando",);
                req.setJson(new JSONObject(new Gson().toJson(obj)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


        msky.sendRequest(req, Skyrunner.RequestTag.KPOSONE);

    }

    public boolean isFinish() {
        return isFinish;
    }

    public void setFinish(boolean finish) {
        isFinish = finish;
    }

    public JSONArray getJsonArray() {
        return jsonArray;
    }

    public void setJsonArray(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    @Override
    public void receivedResponse(ResponseR2D2 response) {
        int req = msky.getRequestIds().get(response.getId());

        switch (req) {
            case Skyrunner.RequestTag.KPOSONE: {
                // do something with

                jsonArray = response.getJSONArray();
                isFinish = true;
                break;
            }
            case Skyrunner.RequestTag.KPOSTWO: {
                jsonObject = response.getJSONObj();
                isFinish = true;
                break;
            }
        }
    }

    @Override
    public void startConnecting(){

    }

    @Override
    public void endConnecting() {

    }

    @Override
    public void requestTimeout() {

    }
}
