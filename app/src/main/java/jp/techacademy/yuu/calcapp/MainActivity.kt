package jp.techacademy.yuu.calcapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent

class MainActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)

    }

    override fun onClick(v:View){

        var answer:String = "0"
        var term1:Double = 0.0
        var term2:Double = 0.0

        try{
            term1 = editText1.text.toString().toDouble()
            term2 = editText2.text.toString().toDouble()

            when(v.id) {
                R.id.button1 -> answer = calcPlus(term1,term2).toString()
                R.id.button2 -> answer = calcMinus(term1,term2).toString()
                R.id.button3 -> answer = calcMultiply(term1,term2).toString()
                R.id.button4 -> answer = calcDivide(term1,term2).toString()
            }

            }catch(e: Exception){

                answer = "Error"

            }finally{

            }

        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra("VALUE",answer)

        startActivity(intent)
    }

    private fun calcPlus(term1:Double,term2:Double):Double {

        val answer = term1 + term2
        return answer

    }

    fun calcMinus(term1:Double,term2:Double):Double {

        var answer= term1 - term2
        return answer
    }

    fun calcMultiply(term1:Double,term2:Double):Double {

        var answer= term1 * term2
        return answer
    }

    fun calcDivide(term1:Double,term2:Double):Double {

        var answer= term1 / term2
        return answer
    }
}