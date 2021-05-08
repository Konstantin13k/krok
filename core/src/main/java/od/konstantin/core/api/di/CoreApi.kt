package od.konstantin.core.api.di

import android.content.Context
import kotlinx.coroutines.CoroutineDispatcher
import od.konstantin.core.api.di.qualifiers.DefaultDispatcher
import od.konstantin.core.api.di.qualifiers.IODispatcher
import od.konstantin.core.api.prefs.UserPrefs

interface CoreApi {

    fun context(): Context

    @IODispatcher
    fun ioDispatcher(): CoroutineDispatcher

    @DefaultDispatcher
    fun defaultDispatcher(): CoroutineDispatcher

    fun userPreferences(): UserPrefs
}