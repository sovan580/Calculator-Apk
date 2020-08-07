package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        one.setOnClickListener{appendOnExpression("1",true)}
        two.setOnClickListener{appendOnExpression("2",true)}
        three.setOnClickListener{appendOnExpression("3",true)}
        four.setOnClickListener{appendOnExpression("4",true)}
        five.setOnClickListener{appendOnExpression("5",true)}
        six.setOnClickListener{appendOnExpression("6",true)}
        seven.setOnClickListener{appendOnExpression("7",true)}
        eight.setOnClickListener{appendOnExpression("8",true)}
        nine.setOnClickListener{appendOnExpression("9",true)}
        zero.setOnClickListener{appendOnExpression("0",true)}
        multiply.setOnClickListener{appendOnExpression("*",false)}
        divide.setOnClickListener{appendOnExpression("/",false)}
        minus.setOnClickListener{appendOnExpression("-",false)}
        add.setOnClickListener{appendOnExpression("+",false)}
        decimal.setOnClickListener{appendOnExpression(".",false)}
        openBracket.setOnClickListener{appendOnExpression("(",false)}
        closeBracket.setOnClickListener{appendOnExpression(")",false)}
        clear.setOnClickListener{
            tvExpression.text=""
            tvResult.text=""
        }
        backspace.setOnClickListener{
            val string=tvExpression.text.toString()
            if(string.isNotEmpty()){
                tvExpression.text=string.substring(0,string.length-1)
            }
            tvResult.text=""
        }
        equals.setOnClickListener{
            try{
                val expression= ExpressionBuilder(tvExpression.text.toString()).build()
                val result=expression.evaluate()
                val longResult=result.toLong()
                if(result==longResult.toDouble()){
                    tvResult.text=longResult.toString()
                }
                else{
                    tvResult.text=result.toString()
                }
            }
            catch (e:Exception){
                Log.d("Exception","message : "+e.message)
            }
        }

    }
    fun appendOnExpression( string:String, canClear:Boolean){
        if(tvResult.text.isNotEmpty()){
            tvExpression.text=""
        }
        if(canClear){
            tvResult.text
            tvExpression.append(string)
        }
        else{
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
        }
    }
}
