package addcolour.co.za.loginkotlin

import addcolour.co.za.loginkotlin.databinding.ActivityMainBinding
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.WindowManager

class MainActivity : AppCompatActivity(), OnClickListener {

    private var mBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        initialize()
    }

    private fun initialize() {

        mBinding?.btnLogin?.setOnClickListener(this)
        mBinding?.btnRegister?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.btnLogin -> {
                val intent  = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                this.finish()
            }

            R.id.btnRegister -> {
                val intent  = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
                this.finish()
            }
        }
    }
}