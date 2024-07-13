package com.kenant42.kotlincardviewrecyclerviewstudy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class RVAdapter(private val mContext: Context, private val countries: List<Country>) :
    RecyclerView.Adapter<RVAdapter.CardViewObjectHolder>() {

    inner class CardViewObjectHolder(view: View) : RecyclerView.ViewHolder(view) {
        var rowCardView: CardView
        var rowTextView: TextView
        var imageView: ImageView

        init {
            rowCardView = view.findViewById(R.id.rowCardView)
            rowTextView = view.findViewById(R.id.rowTextView)
            imageView = view.findViewById(R.id.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewObjectHolder {
        val design = LayoutInflater.from(mContext).inflate(R.layout.card_design, parent, false)
        return CardViewObjectHolder(design)
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onBindViewHolder(holder: CardViewObjectHolder, position: Int) {
        val country = countries[position]
        holder.rowTextView.text = country.countryName

        holder.rowCardView.setOnClickListener {
            Toast.makeText(
                mContext,
                "SELECTED COUNTRY IS ${country.countryName}",
                Toast.LENGTH_LONG
            ).show()
        }

        holder.imageView.setOnClickListener {
            val popup = PopupMenu(mContext, holder.imageView)
            popup.menuInflater.inflate(R.menu.popup_menu, popup.menu)
            popup.show()

            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.action_edit -> {
                        Toast.makeText(mContext, "EDIT CLICKED ", Toast.LENGTH_LONG).show()
                        true
                    }

                    R.id.action_detail -> {
                        Toast.makeText(mContext, "DETAIL CLICKED ", Toast.LENGTH_LONG)
                            .show()
                        true
                    }

                    else -> false
                }
            }
        }
    }


}