package com.gozalias.demo.dagger;

import com.gozalias.demo.user.UserRepository;
import com.gozalias.demo.user.UserViewModel;


import dagger.Component;

@Component(modules = {UserRepository.class})
public interface GeneralComponent {
    void inject(UserViewModel userViewModel);
}
