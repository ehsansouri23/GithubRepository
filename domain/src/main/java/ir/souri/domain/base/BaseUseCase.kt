package ir.souri.domain.base

import ir.souri.domain.resource.Resource
import kotlinx.coroutines.flow.Flow


abstract class BaseUseCase<Input, Output> {

    abstract suspend fun execute(input: Input): Flow<Resource<Output>>
}