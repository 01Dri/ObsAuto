package me.dri.input;

public enum InputKinds {

    IMAGE_SOURCE("image_source"),
    COLOR_SOURCE("color_source"),
    SLIDESHOW("slideshow"),
    BROWSER_SOURCE("browser_source"),
    FFMPEG_SOURCE("ffmpeg_source"),
    TEXT_GDIPLUS("text_gdiplus"),
    TEXT_FT2_SOURCE("text_ft2_source"),
    PROGRESS_BAR("progress_bar"),
    MONITOR_CAPTURE("monitor_capture"),
    WINDOWS_CAPTURE("window_capture"),
    GAME_CAPTURE ("game_capture"),
    DSHOW_INPUT ("dshow_input"),
    WASAPI_INPUT_CAPTURE ("wasapi_input_capture"),
    WASAPI_OUTPUT_CAPTURE ("wasapi_output_capture"),
    WASAPI_PROCESS_OUTPUT_CAPTURE ("wasapi_process_output_capture");

    private final String value;

    InputKinds(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}



