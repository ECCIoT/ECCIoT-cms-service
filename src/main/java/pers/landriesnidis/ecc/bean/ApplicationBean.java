package pers.landriesnidis.ecc.bean;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;

/**
 * Created by landriesnidis on 17-12-30.
 */
public class ApplicationBean {
    private String appName,appNote,appAPIKey,appServerSettings;

    public String getAppAPIKey() {
        return appAPIKey;
    }

    public void setAppAPIKey(String appAPIKey) {
        this.appAPIKey = appAPIKey;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppNote() {
        return appNote;
    }

    public void setAppNote(String appNote) {
        this.appNote = appNote;
    }

    public String getAppServerSettings() {
        return appServerSettings;
    }

    public void setAppServerSettings(String appServerSettings) {
        this.appServerSettings = appServerSettings;
    }

    public JSONObject toJson(){
        JSONObject json = new JSONObject();
        json.put("appName",appName);
        json.put("appNote",appNote);
        json.put("appAPIKey",appAPIKey);
        json.put("appServerSettings",appServerSettings);
        return json;
    }
}
