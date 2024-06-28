package home.pokeman.authentication.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AuthUser::class], version = 1)
abstract class AuthDatabase : RoomDatabase() {
    abstract fun authUserDao(): AuthUserDao
}
