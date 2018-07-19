package addcolour.co.za.loginkotlin

import addcolour.co.za.loginkotlin.databinding.ActivityLoginBinding
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager

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
            }

            R.id.textViewRegister -> {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
                this.finish()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        this.finish()
    }
}