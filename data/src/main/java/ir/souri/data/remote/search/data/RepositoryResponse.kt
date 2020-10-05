package ir.souri.data.remote.search.data

import com.google.gson.annotations.SerializedName
import ir.souri.domain.search.Owner
import ir.souri.domain.search.Repository
import ir.souri.domain.search.SearchRepoResult

data class GithubResponse(
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("incomplete_results") val incompleteResults: Boolean,
    @SerializedName("items") val repositories: List<RepositoryResponse> = emptyList()

)

data class RepositoryResponse(
    @SerializedName("owner") val owner: OwnerResponse,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("html_url") val url: String,
    @SerializedName("language") val language: String
)

data class OwnerResponse(
    @SerializedName("login") val loginName: String,
    @SerializedName("avatar_url") val avatarUrl: String
)

fun GithubResponse.toSearchRepoResult(): SearchRepoResult =
    SearchRepoResult(
        totalCount,
        incompleteResults,
        repositories.map { it.toDomainRepository() }
    )

fun RepositoryResponse.toDomainRepository(): Repository =
    Repository(owner.toDomainOwner(), name, description, url, language)

fun OwnerResponse.toDomainOwner(): Owner =
    Owner(loginName, avatarUrl)