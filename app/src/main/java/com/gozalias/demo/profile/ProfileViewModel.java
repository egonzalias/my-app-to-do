package com.gozalias.demo.profile;

import androidx.lifecycle.ViewModel;

public class ProfileViewModel extends ViewModel {

    private String userId;
    private Profile userProfile;

    public void init(String userId) {
        this.userId = userId;
    }
    public Profile getUserProfile() {
        return userProfile;
    }
}
