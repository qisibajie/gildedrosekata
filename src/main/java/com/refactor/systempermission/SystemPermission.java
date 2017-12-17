package com.refactor.systempermission;

public class SystemPermission {
    private SystemProfile profile;
    private SystemAdmin admin;
    private boolean granted;
    private boolean isUnixPermissionGranted;
    public final static String REQUESTED = "REQUESTED";
    public final static String CLAIMED = "CLAIMED";
    public final static String GRANTED = "GRANTED";
    public final static String DENIED = "DENIED";
    public static final String UNIX_REQUESTED = "UNIX_REQUESTED";
    public static final String UNIX_CLAIMED = "UNIX_CLAIMED";
    private PermissionState permissionState;

    public SystemPermission(SystemProfile profile) {
        this.profile = profile;
        setState(PermissionState.REQUESTED);
        granted = false;
        notifyAdminOfPermissionRequest();
    }

    private void notifyAdminOfPermissionRequest() {

    }

    public void claimedBy(SystemAdmin admin) {
        if (!getState().equals(PermissionState.REQUESTED) && !getState().equals(PermissionState.UNIX_REQUESTED))
            return;
        willBeHandledBy(admin);
        if (getState().equals(PermissionState.REQUESTED)) {
            setState(PermissionState.CLAIMED);
        } else if (getState().equals(PermissionState.UNIX_REQUESTED)) {
            setState(PermissionState.UNIX_CLAIMED);
        }
    }

    private void willBeHandledBy(SystemAdmin admin) {
        this.admin = admin;
    }

    public void deniedBy(SystemAdmin admin) {
        if (!getState().equals(PermissionState.CLAIMED) && !getState().equals(PermissionState.UNIX_CLAIMED))
            return;
        if (!this.admin.equals(admin))
            return;
        granted = false;
        setState(PermissionState.DENIED);
        notifyUserOfPermissionRequestResult();
    }

    private void notifyUserOfPermissionRequestResult() {

    }

    public void grantedBy(SystemAdmin admin) {
        if (!getState().equals(PermissionState.CLAIMED) && !getState().equals(PermissionState.UNIX_CLAIMED))
            return;
        if (!this.admin.equals(admin))
            return;

        if (profile.isUnixPermissionRequired() && getState().equals(PermissionState.UNIX_CLAIMED))
            isUnixPermissionGranted = true;
        else if (profile.isUnixPermissionRequired() && !profile.isUnixPermissionGranted()) {
            setState(PermissionState.UNIX_REQUESTED);
            notifyUnixAdminsOfPermissionRequest();
            return;
        }
        setState(PermissionState.GRANTED);
        granted = true;
        notifyUserOfPermissionRequestResult();
    }

    private void notifyUnixAdminsOfPermissionRequest() {

    }

    public boolean isGranted() {
        return this.granted;
    }

    public PermissionState getState() {
        return permissionState;
    }

    private void setState(PermissionState permissionState) {
        this.permissionState = permissionState;
    }

}
