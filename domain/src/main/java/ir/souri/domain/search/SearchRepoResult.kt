package ir.souri.domain.search

data class SearchRepoResult(
    val totalCount: Int,
    val incompleteResults: Boolean,
    val repositories: List<Repository> = emptyList()
)

data class Repository(
    val owner: Owner,
    val name: String,
    val description: String,
    val url: String,
    val language: String
)

data class Owner(
    val loginName: String,
    val avatarUrl: String
)

