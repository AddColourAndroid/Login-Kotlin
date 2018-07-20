package addcolour.co.za.loginkotlin

import addcolour.co.za.loginkotlin.databinding.ActivityRegisterBinding
import addcolour.co.za.loginkotlin.helper.PreferencesHelper
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import android.widget.Toast

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private var mBinding: ActivityRegisterBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        initialize()
    }

    private fun initialize() {

        mBinding?.btnRegister?.setOnClickListener(this)
        mBinding?.textViewLogin?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnRegister -> {
                submitForm()
            }

            R.id.textViewLogin -> {
                val intent = Intent(this, LoginActivity::class.java)
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

        val confirmPassword = mBinding?.inputConfirmPassword?.text?.trim().toString()
        if (confirmPassword.isEmpty()) {
            Toast.makeText(this, "Enter Confirm Password!!!", Toast.LENGTH_LONG).show()
            return
        }

        if (password != confirmPassword) {
            Toast.makeText(this, "Please Confirm Password!!!", Toast.LENGTH_LONG).show()
            return
        }

        PreferencesHelper.setUsername(this, username)
        PreferencesHelper.setPassword(this, password)

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        this.finish()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
    }
}