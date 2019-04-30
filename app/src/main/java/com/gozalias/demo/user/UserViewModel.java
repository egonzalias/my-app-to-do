package com.gozalias.demo.user;


import com.gozalias.demo.dagger.DaggerGeneralComponent;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


public class UserViewModel extends ViewModel {

    private String userId;
    private LiveData<UserResponse> user;
    @Inject
    UserRepository userRepo;

    public UserViewModel(){
        DaggerGeneralComponent.builder().build().inject(this);
    }

    public void init(String userId) {

        if (this.user != null) {
            // ViewModel is created on a per-Fragment basis, so the userId
            // doesn't change.
            return;
        }
        user = userRepo.getUser(userId);
    }

    public LiveData<UserResponse> getUser() {
        return this.user;
    }
}
