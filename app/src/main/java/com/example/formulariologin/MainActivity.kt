package com.example.formulariologin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.formulariologin.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        val splashScreen = installSplashScreen();

        super.onCreate(savedInstanceState)

        // Habilitamos que la app se muestre incluso hasta la barra de notificaciones
        // eliminando el marco rosa superior


        // Indicamos el fichero del layout
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()
        // Funcion que ajusta la pantalla según el notch del teléfono, para no
        // mostrar contenido dentro de este
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Obtenemos los botones de inicio de sesion y registrarse
        // por su ID
        val botonLogin: Button = findViewById(R.id.botonLogin)

        // Obtengo el textfield de usuario y su parte de dentro por su ID
        val textInputLayout1 = findViewById<TextInputLayout>(R.id.userTextField)
        val textInputEditText1 = findViewById<TextInputEditText>(R.id.userTextField2)

        // Obtengo el textfield de contraseña y su parte de dentro por su ID
        val textInputLayout2 = findViewById<TextInputLayout>(R.id.passwordTextField)
        val textInputEditText2 = findViewById<TextInputEditText>(R.id.passwordTextField2)

        // Creamos un evento de click en el boton de inicio de sesion
        // y lanzamos un Toast
        botonLogin.setOnClickListener {
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

            // Si ambos campos son válidos, hacemos el intent al FavoritosActivity
            if (isValid) {
                val username = textInputEditText1.text.toString()
                val password = textInputEditText2.text.toString()

                val intent = Intent(this@MainActivity, FavoritosActivity::class.java)
                startActivity(intent)

            }
        }

        val botonRegistrarse: Button = findViewById(R.id.botonRegistrarse)

        // Creamos un evento de click en el boton de registrarse y
        // lanzamos un Toast
        botonRegistrarse.setOnClickListener {
            val intent = Intent(this@MainActivity, Registro::class.java)
            startActivity(intent)
        }

        val textContrasenaOlvidada: TextView = findViewById(R.id.textContrasenaOlvidada)

        // Configura el listener para el TextView
        textContrasenaOlvidada.setOnClickListener {
            // Crea un Intent para abrir un navegador con una URL
            val url = "https://customer.bmwgroup.com/oneid/#/login?client=bmwwebcom&country=ES&language=es&brand=bmw&scope=svds%20remote_services%20vehicle_data%20authenticate_user%20smacc%20fupo%20cesim%20perseus&response_type=code&redirect_uri=https%3A%2F%2Fwww.bmw.es%2Fstatic%2Flogin%2Ftoken-handler&state=eyJyZXR1cm5VUkwiOiJodHRwczovL3d3dy5ibXcuZXMvZXMvaG9tZS5odG1sP2ZseW91dD1vcGVuIiwiZGF0YSI6eyJsYW5ndWFnZSI6ImVzIiwiY291bnRyeSI6IkVTIiwiYnJhbmQiOiJibXcifX0=&acid=37422651757721751602619336888746728918&epaas_consenttoken=192b9e439f0af30b703743fa97e0000003f0ZXNfRVN8ZHMyfmJtdy1lcw" // Cambia esto por tu URL
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        // Obtengo el texto por el cual quiero que me redireccione a la pagina
        // de BMW
        val textPoweredBy: TextView = findViewById(R.id.textViewPoweredBy)

        // Hago un evento de click para que este me mande a la url declarada
        textPoweredBy.setOnClickListener {
            val url = "https://www.bmw.es"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        val btnFacebook: ImageButton = findViewById(R.id.btnFacebook)

        btnFacebook.setOnClickListener {

            val snackbar = Snackbar.make(it, "Se abrirá la pantalla de contacto.", Snackbar.LENGTH_INDEFINITE)

            // Primera acción (la acción principal del Snackbar)
            snackbar.setAction("Aceptar") {
                val intent = Intent(this@MainActivity, Contacto::class.java)
                startActivity(intent)
            }

            snackbar.show()

        }

        val btnGoogle: ImageButton = findViewById(R.id.btnGoogle)

        btnGoogle.setOnClickListener {

            val snackbar = Snackbar.make(it, "Se abrirá la pantalla de contacto.", Snackbar.LENGTH_INDEFINITE)

            // Primera acción (la acción principal del Snackbar)
            snackbar.setAction("Aceptar") {
                val intent = Intent(this@MainActivity, Contacto::class.java)
                startActivity(intent)
            }

            snackbar.show()

        }
    }

}

class MyUndoListener : View.OnClickListener {

    override fun onClick(v: View) {
        // Code to undo the user's last action.
    }
}
