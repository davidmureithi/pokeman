package home.pokeman.authentication.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import home.pokeman.authentication.data.AuthDatabase
import home.pokeman.authentication.data.AuthUserDao
import home.pokeman.authentication.model.AuthRepository
import home.pokeman.authentication.model.AuthRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Singleton
    @Provides
    fun providesAuthDatabase(
        @ApplicationContext context: Context,
    ): AuthDatabase =
        Room.databaseBuilder(
            context,
            AuthDatabase::class.java,
            "auth_db",
        ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun providesAuthUserDao(authDatabase: AuthDatabase): AuthUserDao = authDatabase.authUserDao()

    @Singleton
    @Provides
    fun providesAuthRepository(authUserDao: AuthUserDao): AuthRepository = AuthRepositoryImpl(authUserDao)
    
    @Singleton
    @Provides
    fun providesContext(@ApplicationContext context: Context): Context {
        return context
    }
}