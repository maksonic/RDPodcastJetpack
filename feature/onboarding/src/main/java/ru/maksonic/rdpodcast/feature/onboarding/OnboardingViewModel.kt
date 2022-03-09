package ru.maksonic.rdpodcast.feature.onboarding

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.maksonic.rdpodcast.domain.onboarding.OnboardingRepository
import javax.inject.Inject

/**
 * @Author: maksonic on 05.03.2022
 */
@HiltViewModel
class OnboardingViewModel @Inject constructor(repository: OnboardingRepository) : ViewModel() {
    val onboardingList = repository.onboardingList()
}