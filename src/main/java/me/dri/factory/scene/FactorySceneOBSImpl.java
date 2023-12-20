package me.dri.factory.scene;

import io.obswebsocket.community.client.OBSRemoteController;
import io.obswebsocket.community.client.model.Scene;
import me.dri.consts.LoggerConsts;
import me.dri.exceptions.FailedCreateOBSScene;
import me.dri.factory.controller.FactoryControllerOBSWebSocket;
import me.dri.models.ConfigurationSocket;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class FactorySceneOBSImpl implements FactorySceneOBS
{


    private final ConfigurationSocket configurationSocket;

    private final FactoryControllerOBSWebSocket factoryControllerOBSWebSocket;

    private final OBSRemoteController controller;

    Logger logger = Logger.getLogger(LoggerConsts.LOGGER_NAME);

    public FactorySceneOBSImpl(ConfigurationSocket configurationSocket, FactoryControllerOBSWebSocket factoryControllerOBSWebSocket) {
        this.configurationSocket = configurationSocket;
        this.factoryControllerOBSWebSocket = factoryControllerOBSWebSocket;
        this.controller = factoryControllerOBSWebSocket.createController();
    }

    @Override
    public Scene createScene(String name) {
        this.controller.connect();
        try {
            this.controller.createScene(name, createSceneResponse -> {
                if (createSceneResponse.isSuccessful()) {
                    logger.info("SCENE CREATED");
                    this.controller.disconnect();
                }
            });
            return new Scene(name, this.getIndexScene(name));
        } catch (Exception e) {
            throw new FailedCreateOBSScene(logger.getName() + e.getMessage());
        }
    }

    @Override
    public Integer getIndexScene(String sceneName) {
        List<Scene> scenes = this.getScenes();
        for (Scene scene : scenes) {
            if (scene.getSceneName().equals(sceneName)) {
                return scene.getSceneIndex();
            }
        }
        return null;
    }

    @Override
    public List<Scene> getScenes() {
        List<Scene> scenes = new ArrayList<>();
        this.controller.connect();
        this.controller.getSceneList(getSceneListResponse -> {
            if (getSceneListResponse.isSuccessful()) {
                scenes.addAll(getSceneListResponse.getScenes());
            }
        });
        this.controller.disconnect();
        return scenes;
    }

}
