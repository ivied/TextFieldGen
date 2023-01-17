package com.coolhabit.textfieldgencompose.di

import com.coolhabit.textfieldgencompose.app.navigation.TextFieldRouterImpl
import com.coolhabit.textfieldgencompose.textField.ITextFieldRouter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NavigationRouterModule {

    @Provides
    @Singleton
    fun provideTextFieldRouter(): ITextFieldRouter = TextFieldRouterImpl()
}
