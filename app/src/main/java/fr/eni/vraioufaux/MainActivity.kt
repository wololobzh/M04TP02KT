package fr.eni.vraioufaux

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import fr.eni.vraioufaux.databinding.ActivityMainBinding
import fr.eni.vraioufaux.model.QuestionReponse

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var index:Int = 0;
    private var points:Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val liste = mutableListOf<QuestionReponse>()
        liste.add(QuestionReponse("Est ce que cette application est chouette ?",true))
        liste.add(QuestionReponse("Est ce que le soleil se lève tous les matins ?",true))
        liste.add(QuestionReponse("Est ce que le temps est le même pour tout le monde ?",true))
        liste.add(QuestionReponse("Est ce que Android est un langage ?",false))
        liste.add(QuestionReponse("Est ce que la musique est un ensemble de vibration ?",true))
        liste.add(QuestionReponse("Est ce qu'il y a une différence entre une vache ?",false))

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        Log.i("ACOS","Info ===========> " + liste.get(index))

        binding.questionReponse = liste.get(index)
        binding.points = 0.toString()

        binding.btnVrai.setOnClickListener{
            if(liste.get(index).reponse)
            {
                points++
                binding.points = points.toString()
            }
            if(index < liste.size-1) {
                index++
                binding.questionReponse = liste.get(index)
            }
        }
        binding.btnFaux.setOnClickListener{
            if(!liste.get(index).reponse)
            {
                points++
                binding.points = points.toString()
            }
            if(index < liste.size-1) {
                index++
                binding.questionReponse = liste.get(index)
            }
        }
    }
}