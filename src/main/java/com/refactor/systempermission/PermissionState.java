package com.refactor.systempermission;

public class PermissionState {
    public static final PermissionState REQUESTED = new PermissionState("REQUESTED");
    public static final PermissionState CLAIMED = new PermissionState("CLAIMED");
    public static final PermissionState UNIX_CLAIMED = new PermissionState("UNIX_CLAIMED");
    public static final PermissionState DENIED = new PermissionState("DENIED");
    public static final PermissionState UNIX_REQUESTED = new PermissionState("UNIX_REQUESTED");
    public static final PermissionState GRANTED = new PermissionState("GRANTED");
    private final String name;

    public PermissionState(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
