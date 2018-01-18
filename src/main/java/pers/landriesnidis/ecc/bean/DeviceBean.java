package pers.landriesnidis.ecc.bean;

import org.json.JSONObject;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Created by landriesnidis on 18-1-17.
 */
public class DeviceBean {
    int deviceId;
    String deviceModel,deviceFlag,deviceAPIkey,deviceNote;

    public int getDeviceId() {
        return deviceId;
    }

    public String getDeviceAPIkey() {
        return deviceAPIkey;
    }

    public String getDeviceFlag() {
        return deviceFlag;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public String getDeviceNote() {
        return deviceNote;
    }

    public void setDeviceAPIkey(String deviceAPIkey) {
        this.deviceAPIkey = deviceAPIkey;
    }

    public void setDeviceFlag(String deviceFlag) {
        this.deviceFlag = deviceFlag;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public void setDeviceNote(String deviceNote) {
        this.deviceNote = deviceNote;
    }

    public JSONObject toJson(){
        JSONObject json = new JSONObject();
        json.put("deviceId",deviceId);
        json.put("deviceModel",deviceModel);
        json.put("deviceFlag",deviceFlag);
        json.put("deviceAPIkey",deviceAPIkey);
        json.put("deviceNote",deviceNote);
        return json;
    }
}
