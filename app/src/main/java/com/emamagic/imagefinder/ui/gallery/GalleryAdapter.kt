package com.emamagic.imagefinder.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.emamagic.imagefinder.R
import com.emamagic.imagefinder.databinding.ItemUnsplashPhotoBinding
import com.emamagic.imagefinder.model.UnSplashPhoto

class GalleryAdapter(private val listener: OnItemClickListener) :
    PagingDataAdapter<UnSplashPhoto, GalleryAdapter.PhotoViewHolder>(PHOTO_COMPARATOR) {

    companion object {
        private val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<UnSplashPhoto>() {
            override fun areItemsTheSame(oldItem: UnSplashPhoto, newItem: UnSplashPhoto) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: UnSplashPhoto, newItem: UnSplashPhoto) =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding =
            ItemUnsplashPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }


    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) holder.bind(currentItem)
    }


   inner class PhotoViewHolder(private val binding: ItemUnsplashPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION){
                    val item = getItem(position)
                    if (item != null) listener.onItemClick(item)
                }
            }
        }

        fun bind(photo: UnSplashPhoto) {
            binding.apply {
//                Picasso.get().load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQu_fpPmbK-bebEeX036y7frmW06amtCkG1ew&usqp=CAU").error(
//                    R.drawable.ic_error).into(imageView)
                textViewUserName.text = photo.user.username
            }


        }
    }

    interface OnItemClickListener{
        fun onItemClick(photo: UnSplashPhoto)
    }

}

