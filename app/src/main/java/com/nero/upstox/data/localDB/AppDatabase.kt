package com.nero.upstox.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserHoldingModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userHoldingDao(): UserHoldingDao
}
