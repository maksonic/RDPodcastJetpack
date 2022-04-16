package ru.maksonic.rdpodcast.feature.onboarding

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import ru.maksonic.rdpodcast.core.base.BaseViewModel
import ru.maksonic.rdpodcast.domain.onboarding.OnboardingRepository
import javax.inject.Inject

/**
 * @Author: maksonic on 05.03.2022
 */
@HiltViewModel
class OnboardingViewModel @Inject constructor(
    repository: OnboardingRepository
) : BaseViewModel<OnboardingFeature.State, OnboardingFeature.Action, OnboardingFeature.Effect>(
    OnboardingFeature.State.initial()
) {
    init {
        viewModelScope.launch {
            val data = repository.onboardingList()
            runAction(OnboardingFeature.Action.Internal.FetchOnboardingList(data))
        }
    }
    override fun reduce(oldState: OnboardingFeature.State, action: OnboardingFeature.Action) {
        when (action) {
            is OnboardingFeature.Action.Ui.OnShowAuthBottomSheet -> {
                sendEffect { OnboardingFeature.Effect.ShowAuthBottomSheet }
            }
            is OnboardingFeature.Action.Ui.OnSkipOnboarding -> {
                sendEffect { OnboardingFeature.Effect.SkipOnboarding }
            }
            is OnboardingFeature.Action.Internal.FetchOnboardingList -> {
                setState(OnboardingFeature.State(action.onboardingList))
            }
        }
    }

    override val effects: Flow<OnboardingFeature.Effect>
        get() = effect

    fun skipOnboarding() = runAction(OnboardingFeature.Action.Ui.OnSkipOnboarding)

    fun showAuthBottomSheet() = runAction(OnboardingFeature.Action.Ui.OnShowAuthBottomSheet)
}