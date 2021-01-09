package com.example.fighter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.et_password
import kotlinx.android.synthetic.main.activity_login.et_pseudo
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private fun openPage(page: Class<*>) {
        val intent = Intent(this, page)

        startActivity(intent)
    }

    fun loginPlayer(loginRequest: LoginRequest) {
        var loginResponseCall: Call<LoginResponse> = ApiClient().getPlayer().loginPlayer(loginRequest)

        loginResponseCall.enqueue(object: Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if(response.isSuccessful()) {
                    var loginResponse: LoginResponse? = response.body()
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                } else {
                    var message: String = "An error occurred please try again later ..."

                    Toast.makeText(this@LoginActivity, message, Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<LoginResponse>, t: Throwable?) {
                var message: String = t!!.localizedMessage

                Toast.makeText(this@LoginActivity, message, Toast.LENGTH_LONG).show()

            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin.setOnClickListener {
            if (TextUtils.isEmpty(et_pseudo.getText().toString()) || TextUtils.isEmpty(et_password.getText().toString())) {
                Toast.makeText(this@LoginActivity, "All inputs required ..", Toast.LENGTH_LONG).show()
            } else {
                var loginRequest: LoginRequest = LoginRequest();
                loginRequest.setPseudo(et_pseudo.getText().toString())
                loginRequest.setPassword(et_password.getText().toString())

                loginPlayer(loginRequest)
            }
        }
        createAccount.setOnClickListener {
            openPage(RegisterActivity::class.java)
        }
    }
}