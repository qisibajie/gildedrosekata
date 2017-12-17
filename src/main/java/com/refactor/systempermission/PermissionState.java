package com.refactor.systempermission;

public abstract class PermissionState {
    public static final PermissionState REQUESTED = new PermissionStateRequested("REQUESTED");
    public static final PermissionState CLAIMED = new PermissionStateClaimed("CLAIMED");
    public static final PermissionState UNIX_CLAIMED = new PermissionStateUnixClaimed("UNIX_CLAIMED");
    public static final PermissionState DENIED = new PermissionStateDenied("DENIED");
    public static final PermissionState UNIX_REQUESTED = new PermissionStateUnixRequested("UNIX_REQUESTED");
    public static final PermissionState GRANTED = new PermissionStateGranted("GRANTED");
    private final String name;

    public PermissionState(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public void claimedBy(SystemAdmin admin, SystemPermission systemPermission) {
    }

    public void deniedBy(SystemAdmin admin, SystemPermission systemPermission) {
    }

    public void grantedBy(SystemAdmin admin, SystemPermission systemPermission) {
    }
}
