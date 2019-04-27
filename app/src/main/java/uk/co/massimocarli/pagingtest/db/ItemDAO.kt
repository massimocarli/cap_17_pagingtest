package uk.co.massimocarli.pagingtest.db

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import uk.co.massimocarli.pagingtest.model.Item

@Dao
interface ItemDAO {

  @Query("SELECT * FROM item ORDER BY id ASC")
  fun findAll(): DataSource.Factory<Int, Item>
}