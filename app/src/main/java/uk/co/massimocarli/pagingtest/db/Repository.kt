package uk.co.massimocarli.pagingtest.db

import androidx.paging.DataSource
import uk.co.massimocarli.pagingtest.model.Item

/**
 * Repository pattern implementation
 */
interface Repository {

  fun findAll(): DataSource.Factory<Int, Item>
}