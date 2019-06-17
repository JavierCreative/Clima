package com.creative.clima.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.creative.clima.R

class ViewPagerAdapterMain(context: Context) : RecyclerView.Adapter<ViewPagerAdapterMain.ViewHolder>()
{
    private var mContext : Context?

    init {
        this.mContext = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerAdapterMain.ViewHolder
    {
        TODO( "Agregar vistas")
    }

    override fun getItemCount(): Int
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewPagerAdapterMain.ViewHolder, position: Int)
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {

    }

}