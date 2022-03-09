package ru.maksonic.rdpodcast.data.onboarding

import ru.maksonic.rdpodcast.data.R
import ru.maksonic.rdpodcast.domain.onboarding.Onboarding
import ru.maksonic.rdpodcast.domain.onboarding.OnboardingRepository
import javax.inject.Inject

/**
 * @Author: maksonic on 05.03.2022
 */
class BaseOnboardingRepository @Inject constructor() : OnboardingRepository {

    override fun onboardingList() = listOf(
        Onboarding(
            "Добро пожаловать!",
            "Заряжайся, совершенствуйся и вдохновляйся.\nСотни аудиоподкастов от Игоря Войтенко",
            R.drawable.slide_first
        ),
        Onboarding(
            "Слушай в любое время",
            "Полный доступ к аудиоподкастам\nбез интернета 24/7",
            R.drawable.slide_second
        ),
        Onboarding(
            "Минималистичный дизайн",
            "Добавляй в избранное, ставь лайки\nи делись подкастами с кем хочешь!\nТолько самые необходимые функции.",
            R.drawable.slide_third
        ),
        Onboarding(
            "Road to the Dream\nПодкасты",
            "Создано для людей\nкоторые не боятся мечтать\nи хотят сделать наш Мир лучше!",
            R.drawable.slide_fourth
        )
    )
}