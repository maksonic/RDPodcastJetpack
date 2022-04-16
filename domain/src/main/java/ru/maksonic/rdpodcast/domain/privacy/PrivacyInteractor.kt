package ru.maksonic.rdpodcast.domain.privacy

import kotlinx.coroutines.flow.Flow

/**
 * @author maksonic on 16.04.2022
 */
interface PrivacyRepository {
    fun privacyPolicyData(id: String): Flow<PrivacyPolicy>
    val privacyKey: String
    val termsOfUseKey: String
    val passedDataKey: String
}