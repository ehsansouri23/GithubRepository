package ir.souri.domain.resource

open class Resource<T>(
    val status: Status,
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T? = null) : Resource<T>(Status.SUCCESS, data)
    class Loading<T>(data: T? = null) : Resource<T>(Status.LOADING, data)
    class Error<T>(message: String = "", data: T? = null) : Resource<T>(Status.ERROR, data, message)
}

fun <I, O> Resource<I>.mapData(transformMethod: (I?) -> O): Resource<O> {
    return Resource(status, transformMethod(data), message)
}