package com.example.smsspamdetector

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SMSListAdapter (
    private var smsList: MutableList<SMSInfo>
) : RecyclerView.Adapter<SMSListAdapter.SMSViewHolder>() {
    class SMSViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SMSViewHolder {
        return SMSViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SMSViewHolder, position: Int) {
        val curSMS = smsList[position]
        holder.itemView.apply {
            findViewById<TextView>(R.id.senderSMS).text = curSMS.sender
            findViewById<TextView>(R.id.contentSMS).text = curSMS.content
            findViewById<TextView>(R.id.dateSMS).text = curSMS.dateSent
        }
    }

    override fun getItemCount(): Int {
        return smsList.size
    }
}