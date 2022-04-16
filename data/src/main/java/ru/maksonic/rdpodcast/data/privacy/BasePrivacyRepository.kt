package ru.maksonic.rdpodcast.data.privacy

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.maksonic.rdpodcast.core.di.IoDispatcher
import ru.maksonic.rdpodcast.core.provider.ResourceProvider
import ru.maksonic.rdpodcast.data.R
import ru.maksonic.rdpodcast.domain.privacy.PrivacyPolicy
import ru.maksonic.rdpodcast.domain.privacy.PrivacyRepository

/**
 * @author maksonic on 16.04.2022
 */
class BasePrivacyRepository(
    private val rp: ResourceProvider,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : PrivacyRepository {

    override val privacyKey = "privacy_policy_scr_data_key"
    override val termsOfUseKey = "terms_of_use_scr_data_key"
    override val passedDataKey = "passed_privacy_or_terms_key"

    override fun privacyPolicyData(id: String): Flow<PrivacyPolicy> = flow {
        when (id) {
            termsOfUseKey -> {
                val title = rp.getString(R.string.scr_title_teams_of_use)
                val content = rp.getString(R.string.content_teams_of_use)
                emit(PrivacyPolicy(title, content))
            }
            privacyKey -> {
                val title = rp.getString(R.string.scr_title_privacy_policy)
                val content = rp.getString(R.string.content_privacy_policy)
                emit(PrivacyPolicy(title, content))
            }
        }
    }.flowOn(dispatcher)
}
