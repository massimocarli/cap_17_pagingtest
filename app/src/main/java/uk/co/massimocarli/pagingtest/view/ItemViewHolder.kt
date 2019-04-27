package uk.co.massimocarli.pagingtest.view

import androidx.recyclerview.widget.RecyclerView
import uk.co.massimocarli.pagingtest.databinding.ItemLayoutBinding
import uk.co.massimocarli.pagingtest.model.Item

class ItemViewHolder(
  val binding: ItemLayoutBinding
) : RecyclerView.ViewHolder(binding.root) {

  fun bindModel(item: Item?) {
    binding.item = item
  }
}
