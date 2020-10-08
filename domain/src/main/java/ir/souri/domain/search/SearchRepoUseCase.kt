package ir.souri.domain.search

import ir.souri.domain.base.BaseUseCase
import ir.souri.domain.resource.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class SearchRepoUseCase(private val repository: SearchRepoRepository) :
    BaseUseCase<SearchRepoUseCase.Input, SearchRepoResult>() {

    override suspend fun execute(
        input: Input
    ): Flow<Resource<SearchRepoResult>> =
        withContext(Dispatchers.IO) {
            repository.search(input.query, input.page)
        }

    class Input(
        val query: String,
        val page: Int
    )
}