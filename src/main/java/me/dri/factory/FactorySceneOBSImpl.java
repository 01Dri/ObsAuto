package me.dri.factory;

import io.obswebsocket.community.client.OBSRemoteController;
import me.dri.consts.LoggerConsts;
import me.dri.exceptions.FailedCreateOBSScene;
import me.dri.models.ConfigurationSocket;

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
    public void createScene(String sceneName) {
        try {
            this.remoteController.createScene(sceneName, createSceneResponse -> {
                if (createSceneResponse.isSuccessful()) {
                    logger.info("SCENE CREATED");
                    this.remoteController.disconnect();
                }
            });
        } catch (Exception e) {
            throw new FailedCreateOBSScene(logger.getName() + e.getMessage());
        }
    }
}
