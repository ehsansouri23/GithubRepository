package ir.souri.data.remote.search

import ir.souri.data.remote.search.data.GithubResponse
import ir.souri.domain.resource.Resource
import kotlinx.coroutines.flow.Flow

interface SearchRepoRemoteDataSource {

    suspend fun search(query: String, page: Int): Flow<Resource<GithubResponse>>
}