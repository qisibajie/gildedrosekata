package com.refactor.systempermission;

public class SystemPermission {
    private SystemProfile profile;
    private SystemAdmin admin;
    private boolean granted;
    private boolean isUnixPermissionGranted;
    private PermissionState permissionState;

    public SystemPermission(SystemProfile profile) {
        this.profile = profile;
        setState(PermissionState.REQUESTED);
        granted = false;
        notifyAdminOfPermissionRequest();
    }

    void notifyAdminOfPermissionRequest() {

    }

    public void claimedBy(SystemAdmin admin) {
        permissionState.claimedBy(admin, this);
    }

    void willBeHandledBy(SystemAdmin admin) {
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

    void notifyUserOfPermissionRequestResult() {

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

    void notifyUnixAdminsOfPermissionRequest() {

    }

    public boolean isGranted() {
        return this.granted;
    }

    public PermissionState getState() {
        return permissionState;
    }

    public void setState(PermissionState permissionState) {
        this.permissionState = permissionState;
    }

}
