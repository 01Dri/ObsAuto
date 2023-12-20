package me.dri.exceptions;

public class FailedCreateOBSScene extends RuntimeException {
    public FailedCreateOBSScene(String error) {
        super(error);
    }
}
