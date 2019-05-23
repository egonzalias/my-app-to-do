package com.gonzalias.demo.user;




import android.view.View;

import com.gonzalias.demo.dagger.DaggerGeneralComponent;

import javax.inject.Inject;

import androidx.annotation.NonNull;
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

    public void getUser(@NonNull final View v) {

        if (this.user != null) {
            // ViewModel is created on a per-Fragment basis, so the userId
            // doesn't change.
            return;
        }
        user = userRepo.getUser(userId);
    }

    public void clicktest(){
        System.out.println("XXXX:");
    }

    /*public LiveData<UserResponse> getUser() {
        return this.user;
    }*/
}
