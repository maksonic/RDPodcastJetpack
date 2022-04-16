package ru.maksonic.rdpodcast.feature.onboarding

import ru.maksonic.rdpodcast.core.base.UiAction
import ru.maksonic.rdpodcast.core.base.UiEffect
import ru.maksonic.rdpodcast.core.base.UiState
import ru.maksonic.rdpodcast.domain.onboarding.Onboarding
import javax.annotation.concurrent.Immutable

/**
 * @author maksonic on 14.04.2022
 */
object OnboardingFeature {

    @Immutable
    sealed class Action : UiAction {
        sealed class Ui: Action() {
            object OnSkipOnboarding : Ui()
            object OnShowAuthBottomSheet : Ui()
        }
        sealed class Internal: Action() {
            data class FetchOnboardingList(val onboardingList: List<Onboarding>): Internal()
        }
    }

    @Immutable
    data class State(val onboardingList: List<Onboarding>) : UiState {
        companion object {
            fun initial() = State(onboardingList = emptyList())
        }
    }

    sealed class Effect : UiEffect {
        object SkipOnboarding : Effect()
        object ShowAuthBottomSheet : Effect()
    }
}