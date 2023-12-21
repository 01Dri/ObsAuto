package me.dri.factory.inputs;

import io.obswebsocket.community.client.OBSRemoteController;
import me.dri.consts.LoggerConsts;
import me.dri.exceptions.FailedCreateInputOBS;
import me.dri.factory.controller.FactoryControllerOBSWebSocket;
import me.dri.factory.controller.FactoryControllerOBSWebSocketImpl;
import me.dri.factory.scene.FactoryInputOBS;
import me.dri.models.OBSInputConfiguration;

import java.util.logging.Logger;

public class FactoryInputOBSImpl implements FactoryInputOBS {

    FactoryControllerOBSWebSocket factoryControlller;


    OBSRemoteController controller;

    Logger logger = Logger.getLogger(LoggerConsts.LOGGER_NAME);

    public FactoryInputOBSImpl() {
        factoryControlller = new FactoryControllerOBSWebSocketImpl();
        controller = factoryControlller.createController();

    }

    @Override
    public void createInputToScene(OBSInputConfiguration configuration) {

        controller.connect();

        try {
            controller.createInput(configuration.getScene().getSceneName(),
                    configuration.getInputName(),
                    configuration.getInputKind().getValue(),
                    configuration.getSettings(), configuration.getItemEnable(), response -> {
                        if (response.isSuccessful()) {
                            logger.info("INPUT CREATED");
                        }
            });
        } catch (Exception e) {
            throw new FailedCreateInputOBS(e.getMessage());
        }
    }
}
