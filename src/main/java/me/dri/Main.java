package me.dri;

import io.obswebsocket.community.client.model.Scene;
import me.dri.consts.DefaultConfigurationsSocket;
import me.dri.factory.controller.FactoryControllerOBSWebSocket;
import me.dri.factory.controller.FactoryControllerOBSWebSocketImpl;
import me.dri.factory.inputs.FactoryInputOBSImpl;
import me.dri.factory.scene.FactoryInputOBS;
import me.dri.factory.scene.FactorySceneOBS;
import me.dri.factory.scene.FactorySceneOBSImpl;
import me.dri.input.InputKinds;
import me.dri.models.ConfigurationSocket;
import me.dri.models.OBSInputConfiguration;

public class Main {
    public static void main(String[] args) {

        ConfigurationSocket configurationSocket = new ConfigurationSocket(DefaultConfigurationsSocket.LOCALHOST, DefaultConfigurationsSocket.DEFAULT_PORT); // Configuration connect websocket
        FactoryControllerOBSWebSocket factoryControllerOBSWebSocket = new FactoryControllerOBSWebSocketImpl(); // Controller to use in other factories
        FactorySceneOBS factorySceneOBS = new FactorySceneOBSImpl(configurationSocket, factoryControllerOBSWebSocket);
        Scene scene = factorySceneOBS.createScene("Teste");
        FactoryInputOBS factoryInputOBS = new FactoryInputOBSImpl();
        OBSInputConfiguration obsInputConfiguration = new OBSInputConfiguration(scene, "game", InputKinds.GAME_CAPTURE, null, true);
        factoryInputOBS.createInputToScene(obsInputConfiguration);

    }

}