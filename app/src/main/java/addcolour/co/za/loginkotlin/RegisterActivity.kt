package addcolour.co.za.loginkotlin

import addcolour.co.za.loginkotlin.databinding.ActivityRegisterBinding
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager

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
            }

            R.id.textViewLogin -> {
                val intent  = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                this.finish()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        val intent  = Intent(this, MainActivity::class.java)
        startActivity(intent)
        this.finish()
    }
}