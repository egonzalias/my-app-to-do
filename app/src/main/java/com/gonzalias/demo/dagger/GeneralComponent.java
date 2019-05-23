package com.gonzalias.demo.dagger;

import com.gonzalias.demo.user.UserRepository;
import com.gonzalias.demo.user.UserViewModel;


import dagger.Component;

@Component(modules = {UserRepository.class})
public interface GeneralComponent {
    void inject(UserViewModel userViewModel);
}
