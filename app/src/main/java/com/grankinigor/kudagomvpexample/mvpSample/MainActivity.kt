package com.grankinigor.kudagomvpexample.mvpSample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.grankinigor.kudagomvpexample.R

class MainActivity : AppCompatActivity(), SampleInterface.View {

    private lateinit var mPresenter:SampleInterface.Presenter
    private lateinit var mButton: Button
    private lateinit var mTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter = SamplePresenter(this)
        mButton = findViewById(R.id.sample_btn_load)
        mTextView = findViewById(R.id.textView)

        mButton.setOnClickListener {
            mPresenter.onButtonWasClicked()
        }
    }

    override fun showLastNews(string: String) {
        mTextView.text = string
    }
}
