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
        if (!systemPermission.getState().equals(REQUESTED) && !systemPermission.getState().equals(UNIX_REQUESTED))
            return;
        systemPermission.willBeHandledBy(admin);
        if (systemPermission.getState().equals(REQUESTED)) {
            systemPermission.setState(CLAIMED);
        } else if (systemPermission.getState().equals(UNIX_REQUESTED)) {
            systemPermission.setState(UNIX_CLAIMED);
        }
    }


    public void deniedBy(SystemAdmin admin, SystemPermission systemPermission) {
        if (!systemPermission.getState().equals(CLAIMED) && !systemPermission.getState().equals(UNIX_CLAIMED))
            return;
        if (!systemPermission.getAdmin().equals(admin))
            return;
        systemPermission.setGranted(false);
        systemPermission.setState(DENIED);
        systemPermission.notifyUserOfPermissionRequestResult();
    }


    public void grantedBy(SystemAdmin admin, SystemPermission systemPermission) {
        if (!systemPermission.getState().equals(CLAIMED) && !systemPermission.getState().equals(UNIX_CLAIMED))
            return;
        if (!systemPermission.getAdmin().equals(admin))
            return;

        if (systemPermission.getProfile().isUnixPermissionRequired() && systemPermission.getState().equals(UNIX_CLAIMED))
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
