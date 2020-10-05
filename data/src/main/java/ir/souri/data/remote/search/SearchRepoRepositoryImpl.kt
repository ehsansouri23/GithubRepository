package ir.souri.data.remote.search

import ir.souri.data.remote.search.data.toSearchRepoResult
import ir.souri.domain.resource.Resource
import ir.souri.domain.resource.mapData
import ir.souri.domain.search.SearchRepoRepository
import ir.souri.domain.search.SearchRepoResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SearchRepoRepositoryImpl(
    private val remoteDataSource: SearchRepoRemoteDataSource
) : SearchRepoRepository {

    override suspend fun search(
        query: String,
        page: Int
    ): Flow<Resource<SearchRepoResult>> {
        return remoteDataSource.search(query, page)
            .map {
                it.mapData { githubResponse ->
                    githubResponse.toSearchRepoResult()
                }
            }
    }
}