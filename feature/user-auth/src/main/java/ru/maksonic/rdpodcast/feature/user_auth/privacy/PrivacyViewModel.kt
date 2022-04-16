package ru.maksonic.rdpodcast.feature.user_auth.privacy

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.maksonic.rdpodcast.domain.privacy.PrivacyRepository
import javax.inject.Inject

/**
 * @author maksonic on 14.04.2022
 */
data class PrivacyScreenState(
    val title: String,
    val content: String,
)

@HiltViewModel
class PrivacyViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    privacyRepository: PrivacyRepository
    ): ViewModel() {

    var state = mutableStateOf(PrivacyScreenState("", ""))
        private set

    private val privacyId: String =
        savedStateHandle.get<String>(privacyRepository.passedDataKey) ?: ""

    init {
       viewModelScope.launch {
           privacyRepository.privacyPolicyData(privacyId).collect {
               state.value = state.value.copy(
                   title = it.title,
                   content = it.content
               )
           }
       }
    }
}