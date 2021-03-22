package com.mateuslima.mvpcats.di.component;

import android.content.Context;

import com.mateuslima.mvpcats.di.module.ApplicationModule;

import dagger.Component;

@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Context getContext();

}
