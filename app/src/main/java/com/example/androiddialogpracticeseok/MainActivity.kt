package com.example.androiddialogpracticeseok

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageButton: ImageButton = findViewById(R.id.image_button)
        imageButton.setOnClickListener { view ->
            Snackbar.make(
                view,
                "You have clicked image button.",
                Snackbar.LENGTH_LONG
            ).show()
        }

        val btnAlertDialog: Button = findViewById(R.id.btn_alert_dialog)
        btnAlertDialog.setOnClickListener {
            alertDialogFunction()
        }

        val btnCustomDialog : Button = findViewById(R.id.btn_custom_dialog)
        btnCustomDialog.setOnClickListener{
            customDialogFunction()
        }
    }


    private fun alertDialogFunction() {
        val builder = AlertDialog.Builder(this)

        builder.setTitle("다이얼로그 제목")
        builder.setMessage("이것은 알림용 다이얼로그입니다.")
        builder.setIcon(android.R.drawable.ic_dialog_alert)
        builder.setPositiveButton("예") { dialogInterface, which ->
            Toast.makeText(applicationContext, "예 선택", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }

        builder.setNeutralButton("취소") { dialogInterface, which ->
            Toast.makeText(applicationContext, "아니오 선택", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }

        val alertDialog: AlertDialog = builder.create()

        // 바탕 눌렀을 때 취소 가능하게 할 건지 여부
        alertDialog.setCancelable(false)
        alertDialog.show()
    }


    private fun customDialogFunction() {
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.dialog_custom)
        customDialog.findViewById<TextView>(R.id.tv_submit).setOnClickListener {
            Toast.makeText(applicationContext, "submit 눌렀다.", Toast.LENGTH_LONG).show()
            customDialog.dismiss()
        }

        customDialog.findViewById<TextView>(R.id.tv_cancel).setOnClickListener {
            Toast.makeText(applicationContext, "cancel 눌렀다.", Toast.LENGTH_LONG).show()
            customDialog.dismiss()
        }

        customDialog.show()
    }
}