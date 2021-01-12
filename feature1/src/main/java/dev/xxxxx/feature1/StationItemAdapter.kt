package dev.xxxxx.feature1

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.xxxxx.domainfeature1.Station
import dev.xxxxx.feature1.databinding.StationListItemBinding
import dev.xxxxx.uiextensions.inflate

internal class StationItemAdapter(
    private val click: (Station) -> Unit
): ListAdapter<Station, StationItemAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object: DiffUtil.ItemCallback<Station>(){
            override fun areItemsTheSame(oldItem: Station, newItem: Station): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Station, newItem: Station): Boolean =
                oldItem.aGasPrice == newItem.aGasPrice
                        && oldItem.premiumGasPrice == newItem.premiumGasPrice
                        && oldItem.gas95E5Price == newItem.gas95E5Price
                        && oldItem.gas98E5Price == newItem.gas98E5Price
        }
    }

    internal inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding = StationListItemBinding.bind(itemView)

        fun bind(item: Station, click: (Station) -> Unit) = with(itemView) {
            with(binding){
                tvLabel.text = item.label
                tvAddress.text = item.address
                tv95Petrol.titleText = item.gas95E5Price
                tv98Petrol.titleText = item.gas98E5Price
                tvDiesel.titleText = item.aGasPrice
                tvDieselPremium.titleText = item.premiumGasPrice
            }
            setOnClickListener { click.invoke(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.inflate(R.layout.station_list_item))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), click)
    }
}
