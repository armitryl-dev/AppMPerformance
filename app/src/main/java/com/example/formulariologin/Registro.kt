package com.example.formulariologin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.formulariologin.databinding.ActivityRegistroBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class Registro : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val botonRegistrarse: Button = binding.botonSingUp

        val textInputLayout1 = binding.userNameTextField
        val textInputEditText1 = binding.userNameEditText

        // Obtengo el textfield de contraseña y su parte de dentro por su ID
        val textInputLayout2 = binding.emailTextField
        val textInputEditText2 = binding.emailEditText

        val textInputLayout3 = binding.setPasswordTextField
        val textInputEditText3 = binding.setPasswordEditText

        val textInputLayout4 = binding.repeatPasswordTextField
        val textInputEditText4 = binding.repeatPasswordEditText

        botonRegistrarse.setOnClickListener {

            var isValid = true

            // Validación para el primer campo
            if (textInputEditText1.text.isNullOrEmpty()) {
                textInputLayout1.error = "Este campo no puede estar vacío"
                isValid = false
            } else {
                textInputLayout1.error = null // Quitar error si está lleno
            }

            // Validación para el segundo campo
            if (textInputEditText2.text.isNullOrEmpty()) {
                textInputLayout2.error = "Este campo no puede estar vacío"
                isValid = false
            } else {
                textInputLayout2.error = null // Quitar error si está lleno
            }

            if (textInputEditText3.text.isNullOrEmpty()) {
                textInputLayout3.error = "Este campo no puede estar vacío"
                isValid = false
            } else {
                textInputLayout3.error = null // Quitar error si está lleno
            }

            if (textInputEditText4.text.isNullOrEmpty()) {
                textInputLayout4.error = "Este campo no puede estar vacío"
                isValid = false
            } else {
                textInputLayout4.error = null // Quitar error si está lleno
            }

            // Si ambos campos son válidos, hacemos el intent al FavoritosActivity
            if (isValid) {
                val username = textInputEditText1.text.toString()
                val password = textInputEditText2.text.toString()

                val intent = Intent(this@Registro, FavoritosActivity::class.java)
                startActivity(intent)

            }

        }

        val btnFacebook: ImageButton = binding.btnFacebook

        btnFacebook.setOnClickListener {

            val snackbar = Snackbar.make(it, "Se abrirá la pantalla de registro con Facebook.", Snackbar.LENGTH_INDEFINITE)

            // Primera acción (la acción principal del Snackbar)
            snackbar.setAction("Aceptar") {
                val url = "https://www.facebook.com/r.php"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            }

            snackbar.show()

        }

        val btnGoogle: ImageButton = binding.btnGoogle

        btnGoogle.setOnClickListener {

            val snackbar = Snackbar.make(it, "Se abrirá la pantalla de registro con Google.", Snackbar.LENGTH_INDEFINITE)

            // Primera acción (la acción principal del Snackbar)
            snackbar.setAction("Aceptar") {
                val url = "https://accounts.google.com/signup"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            }

            snackbar.show()

        }

        Glide
            .with(binding.root.context)
            .load(R.drawable.profile)
            .placeholder(R.drawable.google)
            .into(binding.imageViewRegistro);

    }
}