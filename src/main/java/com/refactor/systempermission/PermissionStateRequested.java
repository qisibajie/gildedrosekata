package com.refactor.systempermission;

public class PermissionStateRequested extends PermissionState {
    public PermissionStateRequested(String requested) {
        super("REQUESTED");
    }

    public void claimedBy(SystemAdmin admin, SystemPermission systemPermission) {
        systemPermission.willBeHandledBy(admin);
        systemPermission.setState(CLAIMED);
    }
}
