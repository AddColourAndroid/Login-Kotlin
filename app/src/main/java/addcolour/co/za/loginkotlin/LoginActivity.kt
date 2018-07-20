package addcolour.co.za.loginkotlin

import addcolour.co.za.loginkotlin.databinding.ActivityLoginBinding
import addcolour.co.za.loginkotlin.helper.PreferencesHelper
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import android.widget.Toast

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private var mBinding: ActivityLoginBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        initialize()
    }

    private fun initialize() {

        mBinding?.btnLogin?.setOnClickListener(this)
        mBinding?.textViewRegister?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnLogin -> {
                submitForm()
            }

            R.id.textViewRegister -> {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
                this.finish()
            }
        }
    }

    private fun submitForm() {

        val username = mBinding?.inputUsername?.text?.trim().toString()
        if (username.isEmpty()) {
            Toast.makeText(this, "Enter username!!!", Toast.LENGTH_LONG).show()
            return
        }

        val password = mBinding?.inputPassword?.text?.trim().toString()
        if (password.isEmpty()) {
            Toast.makeText(this, "Enter Password!!!", Toast.LENGTH_LONG).show()
            return
        }

        if (username != PreferencesHelper.getUsername(this)) {
            Toast.makeText(this, "Invalid Username!!!", Toast.LENGTH_LONG).show()
            return
        }

        if (password != PreferencesHelper.getPassword(this)) {
            Toast.makeText(this, "Invalid Password!!!", Toast.LENGTH_LONG).show()
            return
        }

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        this.finish()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
    }
}