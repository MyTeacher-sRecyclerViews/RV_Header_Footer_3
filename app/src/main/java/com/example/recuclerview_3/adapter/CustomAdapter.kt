package com.example.recuclerview_3.adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recuclerview_3.R
import com.example.recuclerview_3.model.Member

class CustomAdapter(var context: Context, val members: ArrayList<Member>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TYPE_ITEM_HEADER = 0
    private val TYPE_ITEM_YES_VIEW = 1
    private val TYPE_ITEM_NO_VIEW = 2
    private val TYPE_ITEM_FOOTER = 3

    override fun getItemViewType(position: Int): Int {
        if (isHeader(position)) return TYPE_ITEM_HEADER
        if (isFooter(position)) return TYPE_ITEM_FOOTER

        val member = members[position]

        return if (member.available) TYPE_ITEM_YES_VIEW else TYPE_ITEM_NO_VIEW

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            TYPE_ITEM_HEADER -> {
                val header =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false)
                return CustomViewHeaderHolder(header)
            }
            TYPE_ITEM_YES_VIEW -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
                return CustomViewYesHolder(view)
            }
            TYPE_ITEM_NO_VIEW -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_list_no, parent, false)
                return CustomViewNoHolder(view)
            }
        }
        val footer =
            LayoutInflater.from(parent.context).inflate(R.layout.item_footer, parent, false)
        return CustomViewFooterHolder(footer)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members[position]

        if (holder is CustomViewYesHolder) {
            holder.firstName.text = member.firstName
            holder.lastName.text = member.lastName
        }
        if (holder is CustomViewNoHolder) {
            holder.firstName.setText(R.string.this_first)
            holder.lastName.setText(R.string.this_last)
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }

    private fun isHeader(position: Int): Boolean {
        return position == 0
    }

    private fun isFooter(position: Int): Boolean {
        return position == members.size - 1
    }

    class CustomViewHeaderHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    class CustomViewYesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val firstName: TextView = itemView.findViewById(R.id.text_name)
        val lastName: TextView = itemView.findViewById(R.id.text_lastname)
    }

    class CustomViewNoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val firstName: TextView = itemView.findViewById(R.id.text_name)
        val lastName: TextView = itemView.findViewById(R.id.text_lastname)
    }

    class CustomViewFooterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}