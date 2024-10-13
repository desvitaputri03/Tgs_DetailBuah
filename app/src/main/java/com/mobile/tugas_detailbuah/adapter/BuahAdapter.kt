package com.mobile.tugas_detailbuah.adapter

import ModelBuah
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobile.tugas_detailbuah.DetailBuahActivity
import com.mobile.tugas_detailbuah.R
import com.mobile.tugas_detailbuah.RecycleBuahActivity


class BuahAdapter (
    val itemList: ArrayList<ModelBuah>,
    val getActivity: RecycleBuahActivity
) :
    RecyclerView.Adapter<BuahAdapter.MyViewHolder>() {

    class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage : ImageView
        var itemName : TextView

        init {
            itemImage = itemView.findViewById(R.id.gambar) as ImageView
            itemName = itemView.findViewById(R.id.nama) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuahAdapter.MyViewHolder {
        // manggil layout
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card_buah, parent, false)

        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: BuahAdapter.MyViewHolder, position: Int) {
        // set data ke widget
        holder.itemImage.setImageResource(itemList[position].image)
        holder.itemName.setText(itemList[position].nama)

        holder.itemView.setOnClickListener(){
            val intent = Intent(getActivity, DetailBuahActivity::class.java)
            intent.putExtra( "image", itemList[position].image)
            intent.putExtra( "nama", itemList[position].nama)
            intent.putExtra( "nama", itemList[position].nama)
            intent.putExtra( "lokasi", itemList[position].lokasi)
            intent.putExtra( "deskripsi", itemList[position].deskripsi.toString())


            getActivity.startActivity(intent)
        }
    }


}