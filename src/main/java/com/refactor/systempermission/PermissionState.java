package com.refactor.systempermission;

public class PermissionState {
    public static final PermissionState REQUESTED = new PermissionState();
    public static final PermissionState CLAIMED = new PermissionState();
    public static final PermissionState UNIX_CLAIMED = new PermissionState();
    public static final PermissionState DENIED = new PermissionState();
    public static final PermissionState UNIX_REQUESTED = new PermissionState();
    public static final PermissionState GRANTED = new PermissionState();
}
