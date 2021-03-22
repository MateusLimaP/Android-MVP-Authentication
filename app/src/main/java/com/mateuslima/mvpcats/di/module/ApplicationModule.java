package com.mateuslima.mvpcats.di.module;

import android.content.Context;

import com.mateuslima.mvpcats.data.db.UserDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext(){
        return context;
    }
}
