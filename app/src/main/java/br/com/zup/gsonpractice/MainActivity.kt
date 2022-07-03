package br.com.zup.gsonpractice

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.gsonpractice.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.content.btnToJson.setOnClickListener {
            try {
                val director = Director(
                    name = binding.content.etNomeDiretor.text.toString(),
                    info = binding.content.etInfoDiretor.text.toString()
                )
                binding.content.etJsontxt.setText(
                    Gson().toJson(director)
                )
            }catch (e:Exception){
                Toast.makeText(this, "Deu ruim", Toast.LENGTH_SHORT).show()
            }
        }
        binding.content.btnFromJson.setOnClickListener {
            try {
                val director = Gson().fromJson(
                    binding.content.etJsontxt.text.toString(),
                    Director::class.java
                )
                binding.content.etNomeDiretor.setText(director.name)
                binding.content.etInfoDiretor.setText(director.info)
            }catch (e:Exception){
                Toast.makeText(this, "Deu ruim", Toast.LENGTH_SHORT).show()
            }
        }
    }
}