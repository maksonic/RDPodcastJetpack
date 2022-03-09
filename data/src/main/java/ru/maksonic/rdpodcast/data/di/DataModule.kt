package ru.maksonic.rdpodcast.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.maksonic.rdpodcast.data.onboarding.BaseOnboardingRepository
import ru.maksonic.rdpodcast.domain.onboarding.OnboardingRepository
import javax.inject.Singleton

/**
 * @Author: maksonic on 05.03.2022
 */
@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideOnboardingRepository(): OnboardingRepository = BaseOnboardingRepository()
}