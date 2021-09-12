package com.androidlearn.digishop.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class UserModule {

    @Provides
    @Singleton
    public Contact provideContact() {
        return new Contact();
    }

    @Provides
    @Singleton
    public User provideUser() {
        return new User(new Contact());
    }

}
