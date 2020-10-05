package ir.souri.data.remote.api

import ir.souri.domain.resource.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import retrofit2.Response

inline fun <T> response(apiMethod: () -> Flow<Response<T>>): Flow<Resource<T>> =
    apiMethod().map {
        it.toResource()
    }


fun <T> Response<T>.toResource(): Resource<T> {
    return if (isSuccessful)
        Resource.Success(body())
    else Resource.Error()
}