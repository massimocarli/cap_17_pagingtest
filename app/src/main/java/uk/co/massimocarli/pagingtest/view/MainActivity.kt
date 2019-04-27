package uk.co.massimocarli.pagingtest.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import uk.co.massimocarli.pagingtest.R
import uk.co.massimocarli.pagingtest.databinding.ActivityMainBinding
import uk.co.massimocarli.pagingtest.db.DBRepositoryImpl


class MainActivity : AppCompatActivity() {

  lateinit var viewModel: MainViewModel
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(
      this,
      R.layout.activity_main
    )
    val repository = DBRepositoryImpl(this)
    val factory = RepositoryModelFactory(repository)
    viewModel = ViewModelProviders.of(this, factory)
      .get(MainViewModel::class.java)
    binding.setLifecycleOwner(this)
    binding.model = viewModel
    val linearLayoutManager = LinearLayoutManager(this)
    val dividerItemDecoration = DividerItemDecoration(
      this,
      linearLayoutManager.getOrientation()
    )
    recyclerView.run {
      adapter = ItemAdapter()
      layoutManager = linearLayoutManager
      addItemDecoration(dividerItemDecoration)
      hasFixedSize()
    }
  }
}
