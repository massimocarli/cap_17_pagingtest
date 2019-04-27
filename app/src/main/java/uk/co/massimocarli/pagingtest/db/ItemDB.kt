package uk.co.massimocarli.pagingtest.db

import androidx.room.Database
import androidx.room.RoomDatabase
import uk.co.massimocarli.pagingtest.model.Item

@Database(entities = arrayOf(Item::class), version = 1)
abstract class ItemDB : RoomDatabase() {

    abstract fun getItemDao(): ItemDAO
}
