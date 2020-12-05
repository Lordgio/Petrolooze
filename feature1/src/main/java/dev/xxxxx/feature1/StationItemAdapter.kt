package dev.xxxxx.feature1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import dev.xxxxx.feature1.databinding.StationListItemBinding

class StationItemAdapter(
        private val items: List<Station>,
        private val listener: (Station) -> Unit
): RecyclerView.Adapter<StationItemAdapter.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(parent.inflate(R.layout.station_list_item))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding = StationListItemBinding.bind(itemView)

        fun bind(item: Station, listener: (Station) -> Unit) = with(itemView) {
            with(binding){
                tvLabel.text = item.label
                val addressText = "${item.address} - ${item.cityName} - ${item.provinceName}"
                tvAddress.text = addressText
                tv95Petrol.titleText = item.gas95E5Price
                tv98Petrol.titleText = item.gas98E5Price
                tvDiesel.titleText = item.aGasPrice
                tvDieselPremium.titleText = item.premiumGasPrice
            }
            setOnClickListener { listener(item) }
        }
    }
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View {
    return LayoutInflater.from(this.context).inflate(layoutRes, this, false)
}