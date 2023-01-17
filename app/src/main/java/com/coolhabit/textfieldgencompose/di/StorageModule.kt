package com.coolhabit.textfieldgencompose.di

import android.content.Context
import com.coolhabit.textfieldgencompose.data.SharedPreferencesImpl
import com.coolhabit.textfieldgencompose.domain.api.ILocalStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class StorageModule {

    @Singleton
    @Provides
    fun provideSharedPrefStorage(@ApplicationContext context: Context): ILocalStorage {
        return SharedPreferencesImpl(context)
    }
}
