package com.example.formulariologin

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.formulariologin.databinding.ItemLayoutBinding

class CocheAdapter(private val context: Context, private val coches: List<Coche>) : RecyclerView.Adapter<CocheAdapter.CocheViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocheViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CocheViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CocheViewHolder, position: Int) {
        holder.bind(coches[position])
    }

    override fun getItemCount(): Int {
        return coches.size
    }

    class CocheViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Coche) {
            binding.modelo.text = data.modelo
            binding.serie.text = data.serie
            binding.cv.text = data.CV
            binding.foto.setImageResource(data.foto)

            Glide
                .with(binding.root.context)
                .load(data.foto)
                .placeholder(R.drawable.google)
                .override(500, 500)
                .into(binding.foto);

            if (data.fav) {
                binding.fabFav.setImageResource(R.drawable.fav_selected)
            } else {
                binding.fabFav.setImageResource(R.drawable.fav_unselected)
            }

            binding.fabFav.setOnClickListener {
                if (data.fav) {
                    binding.fabFav.setImageResource(R.drawable.fav_unselected)
                } else {
                    binding.fabFav.setImageResource(R.drawable.fav_selected)
                }
                data.fav = !data.fav
            }

        }
    }
}

