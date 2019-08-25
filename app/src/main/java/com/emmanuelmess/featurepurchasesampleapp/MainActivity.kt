package com.emmanuelmess.featurepurchasesampleapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.emmanuelmess.featurepurchaselibrary.ArgumentConstants
import com.emmanuelmess.featurepurchaselibrary.FeaturePurchaseActivity
import com.emmanuelmess.featurepurchasesampleapp.MainActivity.Companion.onClickBuy

class MainActivity : AppCompatActivity() {
    companion object {
        @JvmStatic
        fun onClickBuy(context: Context) {
            Toast.makeText(context, "Bought!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickOpen(view: View) {
        startActivity(Intent(this, FeaturePurchaseActivity::class.java).apply {
            putExtra(ArgumentConstants.ACTIVITY_CLASS_STRING, MainActivity::class.java.name)
            putExtra(ArgumentConstants.ACTIVITY_NAME_STRING, "Sample")
            putExtra(ArgumentConstants.BUY_CLASS_NAME_STRING, MainActivity::class.java.name)
            putExtra(ArgumentConstants.BUY_METHOD_NAME_STRING, (MainActivity)::onClickBuy.name)
            putExtra(ArgumentConstants.PRICE_FLOAT, 0.35f)
            putExtra(ArgumentConstants.FEATURES_STRING_LIST, arrayListOf("Move files", "Priority support"))
        })
    }

}
