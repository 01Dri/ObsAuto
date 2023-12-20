package me.dri;

import io.obswebsocket.community.client.model.Scene;
import me.dri.consts.DefaultConfigurationsSocket;
import me.dri.factory.controller.FactoryControllerOBSWebSocket;
import me.dri.factory.controller.FactoryControllerOBSWebSocketImpl;
import me.dri.factory.scene.FactorySceneOBS;
import me.dri.factory.scene.FactorySceneOBSImpl;
import me.dri.models.ConfigurationSocket;

public class Main {
    public static void main(String[] args) {

        ConfigurationSocket configurationSocket = new ConfigurationSocket(DefaultConfigurationsSocket.LOCALHOST, DefaultConfigurationsSocket.DEFAULT_PORT); // Configuration connect websocket
        FactoryControllerOBSWebSocket factoryControllerOBSWebSocket = new FactoryControllerOBSWebSocketImpl(); // Controller to use in other factories
        FactorySceneOBS factorySceneOBS = new FactorySceneOBSImpl(configurationSocket, factoryControllerOBSWebSocket);
        Scene scene = factorySceneOBS.createScene("Teste");
        System.out.println(scene.getSceneName());
        System.out.println(scene.getSceneIndex());

    }

}