package com.example.busschedule.data

import android.content.Context
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = [BusSchedule::class], version = 1, exportSchema = false)
abstract class BusDatabase : RoomDatabase() {
    abstract fun busScheduleDao(): BusScheduleDao
    companion object{
        @Volatile private var Instance: BusDatabase? = null
        fun getDatabase(context: Context): BusDatabase{
            return Instance ?: synchronized(this){
                Room.databaseBuilder(context, BusDatabase::class.java, "bus_database")
                    .createFromAsset("database/bus_schedule.db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also{ Instance = it}
            }
        }
    }
}