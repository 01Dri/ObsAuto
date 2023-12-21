package me.dri.models;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.model.Scene;
import me.dri.input.InputKinds;

public class OBSInputConfiguration {


    private Scene scene;

    private String inputName;
    private InputKinds inputKind;
    JsonObject settings;
    Boolean itemEnable;


    public OBSInputConfiguration(Scene scene, String inputName, InputKinds inputKind, JsonObject settings, Boolean itemEnable) {
        this.scene = scene;
        this.inputName = inputName;
        this.inputKind = inputKind;
        this.settings = settings;
        this.itemEnable = itemEnable;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public InputKinds getInputKind() {
        return inputKind;
    }

    public void setInputKind(InputKinds inputKind) {
        this.inputKind = inputKind;
    }

    public JsonObject getSettings() {
        return settings;
    }

    public void setSettings(JsonObject settings) {
        this.settings = settings;
    }

    public Boolean getItemEnable() {
        return itemEnable;
    }

    public void setItemEnable(Boolean itemEnable) {
        this.itemEnable = itemEnable;
    }
}
