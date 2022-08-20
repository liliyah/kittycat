package com.catslover.android.hilt

import android.content.Context
import com.catslover.android.repositories.CatsFeedRepository
import com.catslover.android.repositories.CatsRepository
import com.catslover.android.repositories.CatsSoundsInterface
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

internal abstract class DependenciesBindings {
    @Singleton
    @Binds
    abstract fun bindCatsInterface(catsRepository: CatsRepository): CatsSoundsInterface


}

@Module
@InstallIn(SingletonComponent::class)
class ViewModelDependency{

    @Singleton
    @Provides
    fun providesCatsFeedRepo(@ApplicationContext context: Context): CatsFeedRepository= CatsFeedRepository(context)

}