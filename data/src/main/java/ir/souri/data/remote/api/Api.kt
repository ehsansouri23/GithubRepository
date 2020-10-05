package ir.souri.data.remote.api

import ir.souri.data.remote.search.data.GithubResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("/search/repositories")
    fun search(
        @Query("q") searchQuery: String,
        @Query("page") page: Int,
        @Query("per_page") pageSize: Int = ApiFactory.PAGE_SIZE
    ): Flow<Response<GithubResponse>>
}