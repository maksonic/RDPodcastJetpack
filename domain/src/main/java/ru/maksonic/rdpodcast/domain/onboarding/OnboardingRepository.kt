package ru.maksonic.rdpodcast.domain.onboarding

interface OnboardingRepository {
    fun onboardingList(): List<Onboarding>
}
