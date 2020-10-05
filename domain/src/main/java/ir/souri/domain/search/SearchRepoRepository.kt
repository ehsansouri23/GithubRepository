package ir.souri.domain.search

import ir.souri.domain.resource.Resource
import kotlinx.coroutines.flow.Flow

interface SearchRepoRepository {

    suspend fun search(query: String, page: Int): Flow<Resource<SearchRepoResult>>
}