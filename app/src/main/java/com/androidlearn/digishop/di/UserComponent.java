package com.androidlearn.digishop.di;


//import com.google.android.datatransport.runtime.dagger.Component;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {UserModule.class})
public interface UserComponent {

     User provideUser();
}
