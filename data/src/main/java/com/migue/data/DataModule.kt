package com.migue.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import repository.FilmRepository
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
 abstract class DataModule {

    @Binds
    abstract fun bindFilmRepository(impl: FilmRepositoryImpl):FilmRepository
}