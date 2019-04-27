package uk.co.massimocarli.pagingtest.db

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.random.Random

class InsertItemData() : RoomDatabase.Callback() {

  override fun onCreate(db: SupportSQLiteDatabase) {
    super.onCreate(db)
    GlobalScope.launch {
      val statement =
        db.compileStatement(
          "INSERT INTO Item " +
              "(id, name, description, qta) " +
              "VALUES (?,?,?,?)"
        )
      db.beginTransaction()
      try {
        (1..1000).forEach {
          with(statement) {
            bindString(1, "$it")
            bindString(2, "Item #$it")
            bindString(3, "This is the Item number $it")
            // We calculate the positions based on the central position in Conf
            val randQta = Random.nextInt(0, 20)
            bindLong(4, randQta.toLong())
            statement.executeInsert()
          }
        }
        db.setTransactionSuccessful()
      } finally {
        db.endTransaction()
      }
    }
  }
}
