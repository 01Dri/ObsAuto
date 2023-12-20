package me.dri.factory;

import io.obswebsocket.community.client.OBSRemoteController;
import io.obswebsocket.community.client.model.Scene;
import me.dri.consts.LoggerConsts;
import me.dri.exceptions.FailedCreateOBSScene;
import me.dri.models.ConfigurationSocket;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class FactorySceneOBSImpl implements FactorySceneOBS
{

    private final OBSRemoteController remoteController;

    private final ConfigurationSocket configurationSocket;
    Logger logger = Logger.getLogger(LoggerConsts.LOGGER_NAME);
    public FactorySceneOBSImpl(ConfigurationSocket configurationSocket) {
        this.configurationSocket = configurationSocket;
        this.remoteController = OBSRemoteController.builder().host(configurationSocket.getHost()).port(configurationSocket.getPort()).build(); // Obs builder
        this.remoteController.connect();
    }

    @Override
    public Scene createScene(String name) {
        try {
            this.remoteController.createScene(name, createSceneResponse -> {
                if (createSceneResponse.isSuccessful()) {
                    logger.info("SCENE CREATED");
                    this.remoteController.disconnect();
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
        this.remoteController.connect();
        this.remoteController.getSceneList(getSceneListResponse -> {
            if (getSceneListResponse.isSuccessful()) {
                scenes.addAll(getSceneListResponse.getScenes());
            }
        });
        this.remoteController.disconnect();
        return scenes;
    }

}
