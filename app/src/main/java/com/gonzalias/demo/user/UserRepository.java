package com.gonzalias.demo.user;

import com.gonzalias.demo.repository.extern.WebClient;
import com.gonzalias.demo.repository.extern.WebService;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Module
public class UserRepository {

    private UserRepository userRepository;

    @Inject
    public UserRepository(){

    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Provides
    public LiveData<UserResponse> getUser(String userId) {

        final MutableLiveData<UserResponse> data = new MutableLiveData<>();
        WebService apiInterface = WebClient.getClient().create(WebService.class);
        Call<UserResponse> call = apiInterface.getUser(userId);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                //setValue (si estás en el hilo de UI)
                //postValue (si estás en segundo plano)
                data.postValue(response.body());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                System.out.println("Error");
            }
        });

        return data;
    }
}
