package com.example.bai30rom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bai30rom.emtity.User

class CustomAdapter:RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    lateinit var clickItem:((User)->Unit)
    private var emtyList= emptyList<User>()
    fun setUaer(list:List<User>){
        this.emtyList=list
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.dong_thongtin,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return emtyList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.itemView.apply {
           val tdtId=findViewById<TextView>(R.id.txtid)
           val tdtFistName=findViewById<TextView>(R.id.txFistName)
           val tdtLastNmae=findViewById<TextView>(R.id.txtLastName)
           val tdtAge=findViewById<TextView>(R.id.txtAge)
           tdtId.text=emtyList[position].id.toString()
           tdtFistName.text=emtyList[position].fistName
           tdtLastNmae.text=emtyList[position].lastName
           tdtAge.text=emtyList[position].age

           holder.itemView.setOnClickListener {
               clickItem.invoke(emtyList[position])
           }
       }
    }
}