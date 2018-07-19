package addcolour.co.za.loginkotlin

import addcolour.co.za.loginkotlin.databinding.ActivityMainBinding
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener

class MainActivity : AppCompatActivity(), OnClickListener {

    private var mBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initialize()
    }

    private fun initialize() {
        mBinding?.contentToolBar?.title = getString(R.string.git_repo_title)
    }

    override fun onClick(v: View?) {
    }
}