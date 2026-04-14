package com.example.composetest.di

import com.example.composetest.navigation.Navigator
import com.example.composetest.navigation.NavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigationModule {
    @Binds
    @Singleton
    abstract fun bindNavigator(impl: NavigatorImpl): Navigator
}
