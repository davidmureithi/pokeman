package home.pokeman.authentication.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface AuthUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: AuthUser)

    @Update
    suspend fun updateUser(user: AuthUser)

    @Delete
    suspend fun deleteUser(user: AuthUser)

    @Query("SELECT * FROM user")
    fun fetchAllUsers(): Flow<List<AuthUser>>
}
