package me.dri;

import io.obswebsocket.community.client.model.Scene;
import me.dri.consts.DefaultConfigurationsSocket;
import me.dri.factory.FactorySceneOBS;
import me.dri.factory.FactorySceneOBSImpl;
import me.dri.models.ConfigurationSocket;

public class Main {
    public static void main(String[] args) {

        ConfigurationSocket configurationSocket = new ConfigurationSocket(DefaultConfigurationsSocket.LOCALHOST, DefaultConfigurationsSocket.DEFAULT_PORT);
        FactorySceneOBS factorySceneOBS = new FactorySceneOBSImpl(configurationSocket);
        Scene scene = factorySceneOBS.createScene("Teste");
        System.out.println(scene.getSceneIndex());


    }

}