package com.migue.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import repository.FilmRepository

@InstallIn(ActivityComponent::class)
@Module
 abstract class DataModule {

    @Binds
    abstract fun bindFilmRepository(impl: FilmRepositoryImpl):FilmRepository
}