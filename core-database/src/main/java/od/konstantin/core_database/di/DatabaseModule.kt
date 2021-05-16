package od.konstantin.core_database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import od.konstantin.core_database.data.KrokDatabase
import od.konstantin.core_database.data.booklets.dao.BookletsInfoDao
import javax.inject.Singleton

private const val DATABASE_NAME = "krok_database"

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideKrokDatabase(context: Context): KrokDatabase {
        return Room
            .databaseBuilder(context, KrokDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideBookletsInfoDao(database: KrokDatabase): BookletsInfoDao =
        database.bookletsInfoDao
}