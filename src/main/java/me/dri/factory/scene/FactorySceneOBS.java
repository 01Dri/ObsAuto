package me.dri.factory.scene;

import io.obswebsocket.community.client.model.Scene;

import java.util.List;

public interface FactorySceneOBS {

    Scene createScene(String sceneName);

    Integer getIndexScene(String sceneName);

    List<Scene> getScenes();
}
