package me.dri.factory.controller;

import io.obswebsocket.community.client.OBSRemoteController;
import io.obswebsocket.community.client.OBSRemoteControllerBuilder;
import me.dri.consts.DefaultConfigurationsSocket;

public class FactoryControllerOBSWebSocketImpl implements FactoryControllerOBSWebSocket {

    @Override
    public OBSRemoteController createController() {
        return new OBSRemoteControllerBuilder().host(DefaultConfigurationsSocket.LOCALHOST).port(DefaultConfigurationsSocket.DEFAULT_PORT).build();
    }
}
