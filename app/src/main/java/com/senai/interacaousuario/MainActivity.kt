package com.senai.interacaousuario

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.senai.interacaousuario.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toastButton = findViewById<Button>(R.id.toast)
        toastButton.setOnClickListener { mensagemToast() }

//        val alertButton = findViewById<Button>(R.id.alert)
//        alertButton.setOnClickListener { mensagemAlert() }
//
//        val snackButton = findViewById<Button>(R.id.snack)
//        snackButton.setOnClickListener { mensagemSnake(snackButton) }

        alert.setOnClickListener { mensagemAlert() }

        //a utilização do bindind é recomendada para otimização
        binding.snack.setOnClickListener { mensagemSnake(binding.snack) }

    }

    private fun mensagemToast() {
        Toast.makeText(this, "Teste de toast", Toast.LENGTH_SHORT).show()
    }

    private fun mensagemAlert() {
        AlertDialog
            .Builder(this)
            .setTitle("Atenção")
            .setMessage("Deseja sair do app?")
                //_, _, para não precisarmos definir os parâmetros da função
            .setPositiveButton("Sim") {_, _, -> finish() }
            .setNegativeButton("Cancelar") {_, _, -> }
            .show()

    }

    private fun mensagemSnake(snackButton: Button) {
       Snackbar
           .make(snackButton, "Teste mensagem snackBar", Snackbar.LENGTH_INDEFINITE)
           .setAction("Sair") { finish() }
           .show()
    }


}