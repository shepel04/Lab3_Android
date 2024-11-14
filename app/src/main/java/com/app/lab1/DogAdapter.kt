package com.app.lab1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.lab1.databinding.DogItemBinding

class DogAdapter: RecyclerView.Adapter<DogAdapter.DogHolder>() {
    val dogList = ArrayList<Dog>()
    class DogHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = DogItemBinding.bind(item)
        fun bind(dog: Dog) = with(binding){
            im.setImageResource(dog.imageId)
            tvTitle.text = dog.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dog_item, parent, false)
        return DogHolder(view)
    }

    override fun onBindViewHolder(holder: DogHolder, position: Int) {
        holder.bind(dogList[position])
    }

    override fun getItemCount(): Int {
        return dogList.size
    }

    fun addDog(plant: Dog){
        dogList.add(plant)
        notifyDataSetChanged()
    }

}