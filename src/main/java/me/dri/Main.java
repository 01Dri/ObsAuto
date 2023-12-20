package me.dri;

import io.obswebsocket.community.client.OBSRemoteController;
import me.dri.input.InputKinds;

public class Main {
    public static void main(String[] args)  {
        System.out.println("Hello world!");

        OBSRemoteController controller = OBSRemoteController.builder()
                .host("localhost")
                .port(4455)
                .build();
        controller.connect();
        controller.createScene("Teste", createSceneResponse -> {
            if (createSceneResponse.isSuccessful()) {
                System.out.println("Created scene");
            }
        });


        controller.getInputKindList(true, getInputKindListResponse -> {
            if (getInputKindListResponse.isSuccessful()) {
                System.out.println(getInputKindListResponse.getInputKinds());
            }
        });

        controller.createInput("Teste", "tela", InputKinds.MONITOR_CAPTURE.getValue(), null, true, createInputResponse -> {
                    if (createInputResponse.isSuccessful()) {
                        System.out.println("Created input");
                    } else {
                        System.out.println("Error");
                    }
                });
        controller.disconnect();

    }

}