package edu.neu.khoury.madsea.chrisholzheu.data;

import static edu.neu.khoury.madsea.chrisholzheu.Constants.EMPTY_VALUE;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TaskAddress {

    private String streetNumber;

    private String streetName;

    private String city;

    private String state;

    private String postalCode;

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    static TaskAddress fillJSONObject(JSONObject object) throws JSONException {
        TaskAddress item = new TaskAddress();
        if (object.has("streetNumber")) {
            item.setStreetNumber(object.getString("streetNumber"));
        }
        if (object.has("streetName")) {
            item.setStreetNumber(object.getString("streetName"));
        }
        if (object.has("city")) {
            item.setStreetNumber(object.getString("city"));
        }
        if (object.has("state")) {
            item.setStreetNumber(object.getString("state"));
        }
        if (object.has("postalCode")) {
            item.setStreetNumber(object.getString("streetNumber"));
        }

        return item;
    }

    static List<TaskAddress> fillJSONArray(JSONArray array) throws JSONException {
        if (array == null || array.length() == EMPTY_VALUE)
            return null;
        List<TaskAddress> list = new ArrayList<TaskAddress>();
        for (int i = 0; i < array.length(); i++) {
            list.add(fillJSONObject(array.getJSONObject(i)));
        }
        return list;
    }

    @Override
    public String toString() {
        return "TaskAddress{" +
                "streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
