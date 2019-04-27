package uk.co.massimocarli.pagingtest.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import uk.co.massimocarli.pagingtest.db.Repository
import uk.co.massimocarli.pagingtest.model.Item

class MainViewModel(val repository: Repository) : ViewModel() {

  companion object {
    const val PAGE_SIZE = 10
  }

  val liveData: LiveData<PagedList<Item>>

  init {
    val factory = repository.findAll()
    val pagedListConfig = PagedList.Config.Builder()
      .setPageSize(PAGE_SIZE)
      .setEnablePlaceholders(true)
      .build()
    liveData = LivePagedListBuilder(factory, pagedListConfig).build()
  }
}

class RepositoryModelFactory(val repository: Repository) : ViewModelProvider.Factory {
  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    return modelClass.getConstructor(Repository::class.java)
      .newInstance(repository)
  }
}
