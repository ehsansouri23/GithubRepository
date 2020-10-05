package ir.souri.data.remote.search

import ir.souri.data.remote.api.Api
import ir.souri.data.remote.api.response
import ir.souri.data.remote.search.data.GithubResponse
import ir.souri.domain.resource.Resource
import kotlinx.coroutines.flow.Flow

class SearchRepoRemoteDataSourceImpl(
    private val api: Api
) : SearchRepoRemoteDataSource {

    override suspend fun search(
        query: String,
        page: Int
    ): Flow<Resource<GithubResponse>> =
        response {
            api.search(query, page)
        }

}