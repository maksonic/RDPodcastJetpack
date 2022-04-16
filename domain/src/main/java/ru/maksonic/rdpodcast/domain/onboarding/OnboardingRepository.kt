package ru.maksonic.rdpodcast.domain.onboarding

/**
 * @Author: maksonic on 05.03.2022
 */
interface OnboardingRepository {
    fun onboardingList(): List<Onboarding>
}