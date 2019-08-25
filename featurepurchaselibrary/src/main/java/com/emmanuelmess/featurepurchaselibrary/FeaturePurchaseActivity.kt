package com.emmanuelmess.featurepurchaselibrary


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity;
import com.emmanuelmess.featurepurchaselibrary.ArgumentConstants.ACTIVITY_CLASS_STRING
import com.emmanuelmess.featurepurchaselibrary.ArgumentConstants.ACTIVITY_NAME_STRING
import com.emmanuelmess.featurepurchaselibrary.ArgumentConstants.BUY_CLASS_NAME_STRING
import com.emmanuelmess.featurepurchaselibrary.ArgumentConstants.FEATURES_STRING_LIST
import com.emmanuelmess.featurepurchaselibrary.ArgumentConstants.BUY_METHOD_NAME_STRING
import com.emmanuelmess.featurepurchaselibrary.ArgumentConstants.PRICE_FLOAT

import kotlinx.android.synthetic.main.activity_feature_purchase.*
import kotlinx.android.synthetic.main.content_feature_purchase.*

class FeaturePurchaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_purchase)

        toolbar.title = getString(R.string.title_activity_feature_purchase, intent.getStringExtra(ACTIVITY_NAME_STRING))

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        priceTextView.text = getString(R.string.dollarPrice, intent.getFloatExtra(PRICE_FLOAT, -1f))

        val featureBuilder = StringBuilder()

        for (feature in intent.getStringArrayListExtra(FEATURES_STRING_LIST)!!) {
            featureBuilder.appendln("• $feature")
        }

        featureBuilder.appendln("+ Much more")

        featuresTextView.text = featureBuilder.toString()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) {
            startActivity(Intent(this, Class.forName(intent.getStringExtra(ACTIVITY_CLASS_STRING)!!)))
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun onClickBuy(view: View) {
        Class.forName(intent.getStringExtra(BUY_CLASS_NAME_STRING)!!)
            .getMethod(intent.getStringExtra(BUY_METHOD_NAME_STRING)!!, Context::class.java)
            .invoke(null, applicationContext)
    }

}
