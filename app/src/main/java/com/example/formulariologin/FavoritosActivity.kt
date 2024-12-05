package com.example.formulariologin

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.formulariologin.databinding.ActivityFavoritosBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FavoritosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoritosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityFavoritosBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.favoritosMain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        GlobalScope.launch(Dispatchers.Main) {
            espera()
        }

        // Datos de prueba (tres elementos)
        val peliculaList = listOf(
            Coche("BMW M3", "E46", "500 CV", R.drawable.bmw_e46, false),
            Coche("BMW M4", "F32", "510 CV", R.drawable.bmw_f32, false),
            Coche("BMW M8", "F92", "625 CV", R.drawable.bmw_f92, false)
        )

        // Referencia al RecyclerView en el layout
        val recyclerView: RecyclerView = findViewById(R.id.rv)

        // Configuración del RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CocheAdapter(this, peliculaList)
    }

    private suspend fun espera(): String{

        binding.rv.visibility = View.INVISIBLE
        binding.progressBar!!.visibility = ProgressBar.VISIBLE

        for(i in 0..100){
            delay(30)
            binding.progressBar!!.progress = i
        }
        binding.progressBar!!.visibility = ProgressBar.GONE
        binding.rv.visibility = View.VISIBLE

        return "Carga completa"
    }

}