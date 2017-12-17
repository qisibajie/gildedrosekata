package com.refactor.systempermission;

public class PermissionStateUnixRequested extends PermissionState {
    public PermissionStateUnixRequested(String unix_requested) {
        super("UNIX_REQUESTED");
    }

    public void claimedBy(SystemAdmin admin, SystemPermission systemPermission) {
        systemPermission.willBeHandledBy(admin);
        systemPermission.setState(UNIX_CLAIMED);
    }
}
