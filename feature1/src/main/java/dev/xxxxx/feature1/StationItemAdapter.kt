package dev.xxxxx.feature1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import dev.xxxxx.domainfeature1.Station
import dev.xxxxx.feature1.databinding.StationListItemBinding
import dev.xxxxx.uiextensions.basicDiffUtil

internal class StationItemAdapter: RecyclerView.Adapter<StationItemAdapter.ViewHolder>() {

    var items: List<Station> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old.id == new.id },
        areContentsTheSame = { old, new ->
            old.aGasPrice == new.aGasPrice
                    && old.premiumGasPrice == new.premiumGasPrice
                    && old.gas95E5Price == new.gas95E5Price
                    && old.gas98E5Price == new.gas98E5Price
        }
    )
    private var itemClickListener: ((Station) -> Unit)? = null

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(parent.inflate(R.layout.station_list_item))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setOnItemClickListener(itemClickListener: (Station) -> Unit){
        this.itemClickListener = itemClickListener
    }

    internal inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding = StationListItemBinding.bind(itemView)

        fun bind(item: Station) = with(itemView) {
            with(binding){
                tvLabel.text = item.label
                tvAddress.text = item.address
                tv95Petrol.titleText = item.gas95E5Price
                tv98Petrol.titleText = item.gas98E5Price
                tvDiesel.titleText = item.aGasPrice
                tvDieselPremium.titleText = item.premiumGasPrice
            }
            setOnClickListener { itemClickListener?.invoke(item) }
        }
    }
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View {
    return LayoutInflater.from(this.context).inflate(layoutRes, this, false)
}