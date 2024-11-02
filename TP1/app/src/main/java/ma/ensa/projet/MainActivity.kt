package ma.ensa.projet

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nom = findViewById<EditText>(R.id.txtNom)
        val email = findViewById<EditText>(R.id.txtEmail)
        val message = findViewById<EditText>(R.id.txtMessage)
        val envoyer = findViewById<Button>(R.id.buttonSubmit)
        val type = findViewById<Spinner>(R.id.complaintTypeSpinner)

        envoyer.setOnClickListener {

            val nomtxt = nom.text.toString().trim()
            val emailtxt = email.text.toString().trim()
            val messagetxt = message.text.toString().trim()
            val complaintType = type.selectedItem.toString()
            if (nomtxt.isNotEmpty() && emailtxt.isNotEmpty() && messagetxt.isNotEmpty()) {
                showAlertDialog("Reclamation de type :$complaintType envoyé avec succès!", "Nom: $nomtxt\nEmail: $emailtxt\nMessage: $messagetxt")

            } else {
                showAlertDialog("Erreur", "Veuillez remplir tous les champs")
            }
        }
    }

    private fun showAlertDialog(title: String, message: String) {
        val alertDialog = AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface, which: Int) {
                    dialog.dismiss()
                    if(title!="Erreur"){
                        val intent = Intent(this@MainActivity, SecondActivity::class.java)
                        intent.putExtra("data",message)
                        startActivity(intent)

                    }
                }
            })
            .create()
        alertDialog.show()
    }


}