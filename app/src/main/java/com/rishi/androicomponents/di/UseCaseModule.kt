package com.rishi.androicomponents.di

import com.rishi.androicomponents.data.repository.StudentRepository
import com.rishi.androicomponents.domain.StudentDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


//@Module
//@InstallIn(SingletonComponent::class)
//object UseCaseModule {
//
//    @Singleton
//    @Provides
//    fun provideStudentDataUseCase(repository: StudentRepository) = StudentDataUseCase(repository)
//
//}

@Module
@InstallIn(ActivityRetainedComponent::class)
object UseCaseModule {

    @ActivityRetainedScoped
    @Provides
    fun provideStudentDataUseCase(repository: StudentRepository) = StudentDataUseCase(repository)
}