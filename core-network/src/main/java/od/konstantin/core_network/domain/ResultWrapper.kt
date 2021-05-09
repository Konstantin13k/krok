package od.konstantin.core_network.domain

sealed class ResultWrapper<out T>

class Success<out T>(val data: T) : ResultWrapper<T>()

class GenericError(val throwable: Throwable) : ResultWrapper<Nothing>()

object NetworkError : ResultWrapper<Nothing>()
