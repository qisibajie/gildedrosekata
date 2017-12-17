package com.refactor.systempermission;

public class PermissionStateUnixClaimed extends PermissionState {
    public PermissionStateUnixClaimed(String unix_claimed) {
        super("UNIX_CLAIMED");
    }

    public void deniedBy(SystemAdmin admin, SystemPermission systemPermission) {
        if (!systemPermission.getAdmin().equals(admin))
            return;
        systemPermission.setGranted(false);
        systemPermission.setState(DENIED);
        systemPermission.notifyUserOfPermissionRequestResult();
    }

    public void grantedBy(SystemAdmin admin, SystemPermission systemPermission) {
        if (!systemPermission.getAdmin().equals(admin))
            return;

        if (systemPermission.getProfile().isUnixPermissionRequired())
            systemPermission.setUnixPermissionGranted(true);
        else if (systemPermission.getProfile().isUnixPermissionRequired() && !systemPermission.getProfile().isUnixPermissionGranted()) {
            systemPermission.setState(UNIX_REQUESTED);
            systemPermission.notifyUnixAdminsOfPermissionRequest();
            return;
        }
        systemPermission.setState(GRANTED);
        systemPermission.setGranted(true);
        systemPermission.notifyUserOfPermissionRequestResult();
    }
}
