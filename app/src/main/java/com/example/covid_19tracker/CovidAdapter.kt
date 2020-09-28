package com.example.covid_19tracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

const val TYPE_ITEM = 0
const val TYPE_HEADER = 1


class CovidAdapter(val list : List<StatewiseItem>) : RecyclerView.Adapter<CovidAdapter.CovidItemViewHolder>() {


    class CovidItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: StatewiseItem) {
            with(itemView){
                stateTv.text = item.state
                confirmedTv.text = SpannableDelta(
                    "${item.confirmed}\n ↑${item.deltaconfirmed?:0} ",
                    "#E74C3C",
                    item.confirmed?.length?:0)
                deceasedTv.text =SpannableDelta(
                    "${item.deaths}\n ↑${item.deltadeaths?:0} ",
                    "#F1C40F",
                    item.deaths?.length?:0)
                recoveredTv.text =SpannableDelta(
                    "${item.recovered}\n ↑${item.deltarecovered?:0} ",
                    "#229954",
                    item.recovered?.length?:0)
                activeTv.text = SpannableDelta(
                    "${item.active}\n ↑${item.deltaactive?:0} ",
                    "#2980B9",
                    item.active?.length?:0)
            }

        }

    }
    class CovidHeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidItemViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_list , parent , false)
       return CovidItemViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: CovidItemViewHolder, position: Int) {
            holder.bind(list[position])
    }
}