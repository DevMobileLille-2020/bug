package com.example.fighter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity: AppCompatActivity() {
    fun registerPlayer(registerRequest: RegisterRequest) {
        var registerResponseCall: Call<RegisterResponse> = ApiClient().getPlayer().registerPlayer(registerRequest)
        registerResponseCall.enqueue(object: Callback<RegisterResponse> {
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                if(response.isSuccessful()) {
                    var message: String = "Successful"
                    Toast.makeText(this@RegisterActivity, message, Toast.LENGTH_LONG).show()
                    startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                    finish()
                } else {
                    var message: String = "An error occurred please try again later ..."
                    Toast.makeText(this@RegisterActivity, message, Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<RegisterResponse>, t: Throwable?) {
                var message: String = "An error occurred please try again later ..."
                Toast.makeText(this@RegisterActivity, message, Toast.LENGTH_LONG).show()

            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnSignUp.setOnClickListener {
            if (TextUtils.isEmpty(et_pseudo.getText().toString()) || TextUtils.isEmpty(et_password.getText().toString())) {
                Toast.makeText(this@RegisterActivity, "All inputs required ..", Toast.LENGTH_LONG).show()
            } else {
                var registerRequest: RegisterRequest = RegisterRequest();
                registerRequest.setPseudo(et_pseudo.getText().toString())
                registerRequest.setPassword(et_password.getText().toString())
                registerPlayer(registerRequest)
            }
        }
    }
}