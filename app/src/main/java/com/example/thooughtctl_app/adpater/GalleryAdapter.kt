package com.example.thooughtctl_app.adpater

import android.content.Context
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thooughtctl_app.R
import com.example.thooughtctl_app.RequestResponse.Daum
import com.example.thooughtctl_app.utils.Constants
import com.squareup.picasso.Picasso

class GalleryAdapter(private val applicationContext: Context, private val data: List<Daum>, ) : RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.image_view_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val image = data[position].images?.get(0)?.link
        Picasso.get().load(image).into(holder.imageView)

        holder.imageTitle_text.text = data[position].title

        holder.imageDateTime_text.text = data[position].images?.get(0)?.datetime?.let {dateTime->
            Constants.setDateTime(
                dateTime
            )
        }

        if(data[position].images?.size != null){
            val imageCount = data[position].images?.size
            holder.imageCount_text.text ="Image count: "+imageCount
        }else{
            holder.imageCount_text.visibility = View.GONE
        }

    }

    public

    class GalleryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.id_imageView)
        val imageTitle_text: TextView = itemView.findViewById(R.id.id_image_tittle_txt)
        val imageDateTime_text: TextView = itemView.findViewById(R.id.id_image_datetime_txt)
        val imageCount_text: TextView = itemView.findViewById(R.id.id_image_count_txt)
    }
}