package ru.maksonic.rdpodcast.feature.user_auth.auth_bottom_sheet

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.maksonic.rdpodcast.domain.privacy.PrivacyRepository
import javax.inject.Inject

/**
 * @author maksonic on 16.04.2022
 */
@HiltViewModel
class AuthBottomSheetViewModel @Inject constructor(
    privacyRepository: PrivacyRepository
): ViewModel() {

    val termsKey = privacyRepository.termsOfUseKey
    val privacyKey = privacyRepository.privacyKey
}