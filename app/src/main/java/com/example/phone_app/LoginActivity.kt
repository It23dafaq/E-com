package com.example.phone_app

import android.app.VoiceInteractor
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        goRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        login_btn.setOnClickListener {
           // Person.email = emailLogin.text.toString()
            val intent = Intent(this, MainViewActivity::class.java)
            intent.putExtra("email", emailLogin.text)
            startActivity(intent)

            val loginUrl="https://rectifiable-merchan.000webhostapp.com/e_com/login_app_user.php?email="+emailLogin.text.toString()+
                    "&password="+passLogin.text.toString()

            val requestQ = Volley.newRequestQueue(this@LoginActivity)
            val stringRequest = StringRequest(Request.Method.GET,loginUrl, Response.Listener {
                    response ->
                if(response.equals("The user does exist")){
                    Toast.makeText(this@LoginActivity,response,Toast.LENGTH_SHORT)
                }else{
                    createDialog(response)
                }

            },Response.ErrorListener { error->

            })
            requestQ.add(stringRequest)
        }
    }
    private fun createDialog(message: String ) {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle("Message")
        dialogBuilder.setMessage(message)
        dialogBuilder.create().show()
    }
}
