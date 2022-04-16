package ru.maksonic.rdpodcast.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import ru.maksonic.rdpodcast.core.di.IoDispatcher
import ru.maksonic.rdpodcast.core.provider.ResourceProvider
import ru.maksonic.rdpodcast.data.onboarding.BaseOnboardingRepository
import ru.maksonic.rdpodcast.data.privacy.BasePrivacyRepository
import ru.maksonic.rdpodcast.domain.onboarding.OnboardingRepository
import ru.maksonic.rdpodcast.domain.privacy.PrivacyRepository
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

    @Singleton
    @Provides
    fun providePrivacyRepository(rp: ResourceProvider, @IoDispatcher dp: CoroutineDispatcher
    ): PrivacyRepository = BasePrivacyRepository(rp, dp)
}