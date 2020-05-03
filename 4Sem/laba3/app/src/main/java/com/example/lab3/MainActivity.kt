package com.example.lab3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val ERROR_EMPTY_DATA = "Поля не должны быть пустыми!"
        private const val RANDOM_BOUND = 8
    }

    private val namesList =  listOf("Валентин", "Виктор", "Вениамин", "Волокордин", "Вейерштрасс", "Вольдемар", "Виссарион", "Владлен", "Венедикт")
    
    private val patronymicList = listOf("Валентинович", "Викторович", "Вениаминович", "Волокординович", "Вейерштрассович", "Вольдемарович", "Виссарионович", "Влаадленович", "Венедитович")

    private val surnameList = listOf("Валентинов", "Викторов", "Вениаминов", "Волокординов", "Вейерштрассов", "Вольдемаров", "Виссарионов", "Владленов", "Венедиктов")

    private val timeList = listOf("12:14", "13:21", "10:10", "15:15", "23:56", "14:32", "12:23", "14:21")

    private lateinit var dbHelper: DbHelper
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dbHelper = DbHelper(this)
        deleteData()
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        btnAdd.setOnClickListener {
            etSurname.visible()
            etName.visible()
            etPatronymic.visible()
            etTime.visible()
            etSurname.visible()
        }
        btnSave.setOnClickListener {
            if (etName.isTextEmpty() || etTime.isTextEmpty() || etSurname.isTextEmpty() || etPatronymic.isTextEmpty()) {
                Toast.makeText(this, ERROR_EMPTY_DATA, Toast.LENGTH_SHORT).show()
            } else {
                dbHelper.addData(etSurname.text.toString(), etName.text.toString(), etPatronymic.text.toString(), etTime.text.toString())
                etSurname.setEmptyAndGone()
                etName.setEmptyAndGone()
                etPatronymic.setEmptyAndGone()
                etTime.setEmptyAndGone()
            }
        }
        btnView.setOnClickListener {
            if (etSurname.isVisible() || etSurname.isVisible() || etPatronymic.isVisible() || etTime.isVisible() || btnSave.isVisible()) {
                etSurname.gone()
                etName.gone()
                etPatronymic.gone()
                etTime.gone()
                btnSave.gone()
            }
            startActivity(Intent(this@MainActivity, ListDataActivity::class.java))
        }
        btnReplace.setOnClickListener {
            if (etSurname.isVisible() || etName.isVisible() || etPatronymic.isVisible() || etTime.isVisible() || btnSave.isVisible()) {
                etSurname.gone()
                etName.gone()
                etPatronymic.gone()
                etTime.gone()
                btnSave.gone()
            }
            dbHelper.replace("Иванов", "Иван", "Иванович")
        }
    }

    private fun deleteData() {
        Random().apply {
            nextInt(RANDOM_BOUND).let { i -> dbHelper.deleteAndUpdate(0, surnameList[i], namesList[i], patronymicList[i], timeList[i]) }
            nextInt(RANDOM_BOUND).let { i -> dbHelper.deleteAndUpdate(1, surnameList[i], namesList[i], patronymicList[i], timeList[i]) }
            nextInt(RANDOM_BOUND).let { i -> dbHelper.deleteAndUpdate(1, surnameList[i], namesList[i], patronymicList[i], timeList[i]) }
            nextInt(RANDOM_BOUND).let { i -> dbHelper.deleteAndUpdate(1, surnameList[i], namesList[i], patronymicList[i], timeList[i]) }
            nextInt(RANDOM_BOUND).let { i -> dbHelper.deleteAndUpdate(1, surnameList[i], namesList[i], patronymicList[i], timeList[i]) }
        }
    }
}