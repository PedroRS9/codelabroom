import androidx.room.Dao
import androidx.room.Query
import com.example.busschedule.data.BusSchedule

@Dao
interface BusScheduleDao {
    @Query("SELECT * FROM BusSchedule ORDER BY arrivalTimeInMillis")
    suspend fun getAll(): List<BusSchedule>

    @Query("SELECT * FROM BusSchedule WHERE stopName = :stopName")
    suspend fun getByStopName(stopName: String): BusSchedule?
}