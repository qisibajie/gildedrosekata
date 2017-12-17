package com.refactor.systempermission;

public class SystemPermission {
    private SystemProfile profile;
    private SystemAdmin admin;
    private boolean granted;
    private boolean isUnixPermissionGranted;
    private PermissionState permissionState;

    public SystemPermission(SystemProfile profile) {
        this.setProfile(profile);
        setState(PermissionState.REQUESTED);
        setGranted(false);
        notifyAdminOfPermissionRequest();
    }

    void notifyAdminOfPermissionRequest() {

    }

    public void claimedBy(SystemAdmin admin) {
        permissionState.claimedBy(admin, this);
    }

    void willBeHandledBy(SystemAdmin admin) {
        this.setAdmin(admin);
    }

    public void deniedBy(SystemAdmin admin) {
        permissionState.deniedBy(admin, this);
    }

    void notifyUserOfPermissionRequestResult() {

    }

    public void grantedBy(SystemAdmin admin) {
        permissionState.grantedBy(admin, this);
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

    public SystemAdmin getAdmin() {
        return admin;
    }

    public void setAdmin(SystemAdmin admin) {
        this.admin = admin;
    }

    public void setGranted(boolean granted) {
        this.granted = granted;
    }

    public SystemProfile getProfile() {
        return profile;
    }

    public void setProfile(SystemProfile profile) {
        this.profile = profile;
    }

    public void setUnixPermissionGranted(boolean unixPermissionGranted) {
        isUnixPermissionGranted = unixPermissionGranted;
    }
}
