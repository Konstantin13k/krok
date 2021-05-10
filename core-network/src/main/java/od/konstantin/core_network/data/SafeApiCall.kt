package od.konstantin.core_network.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import od.konstantin.core_network.domain.GenericError
import od.konstantin.core_network.domain.NetworkError
import od.konstantin.core_network.domain.ResultWrapper
import od.konstantin.core_network.domain.Success
import java.io.IOException

suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T
): ResultWrapper<T> {
    return withContext(dispatcher) {
        try {
            Success(apiCall())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> NetworkError
                else -> GenericError(throwable)
            }
        }
    }
}