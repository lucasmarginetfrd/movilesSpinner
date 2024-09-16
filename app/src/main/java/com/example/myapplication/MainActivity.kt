package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    private lateinit var spinner: Spinner
    private lateinit var listView: ListView

    private lateinit var nacion: String
    private lateinit var equipo: String
    private lateinit var equiposAr: String //0
    private lateinit var equiposUr: String //1
    private lateinit var equiposBr: String //2

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.spinner)
        listView = findViewById(R.id.listView)

        val naciones = listOf("Argentina", "Uruguay", "Brazil")

        val equiposAr = listOf("River Plate", "Excursionistas", "Platense", "Temperley", "Chacarita", "Boca Juniors", "Tigre")
        val equiposUr = listOf("Rampla Juniors", "River Plate", "Defensor Sporting", "Danubio", "Liverpool", "Nacional", "Peñarol")
        val equiposBr = listOf("Flamengo", "Panaraense", "Sao Pablo", "Vasco de gama", "Fluminense", "Palmeiras", "Cruzeiro")
        val adapterViewAr = ArrayAdapter(this, android.R.layout.simple_list_item_1, equiposAr)
        val adapterViewUr = ArrayAdapter(this, android.R.layout.simple_list_item_1, equiposUr)
        val adapterViewBr = ArrayAdapter(this, android.R.layout.simple_list_item_1, equiposBr)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, naciones)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                nacion = naciones[p2]
                if (nacion == "Argentina") {
                    listView.adapter = adapterViewAr
                    listView.setOnItemClickListener { adapterViewAr, view, i, l ->
                        equipo = equiposAr[i]
                    }
                } else if (nacion == "Uruguay"){
                    listView.adapter = adapterViewUr
                    listView.setOnItemClickListener { adapterViewUr, view, i, l ->
                        equipo = equiposUr[i]
                    }
                } else if (nacion == "Brazil") {
                    listView.adapter = adapterViewBr
                    listView.setOnItemClickListener { adapterViewBr, view, i, l ->
                        equipo = equiposBr[i]
                    }
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

    }

}