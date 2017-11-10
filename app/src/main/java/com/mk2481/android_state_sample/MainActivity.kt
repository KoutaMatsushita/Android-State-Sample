package com.mk2481.android_state_sample

import android.databinding.ObservableArrayList
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.evernote.android.state.State
import com.evernote.android.state.StateSaver

class MainActivity : AppCompatActivity() {

    @State
    var todoList = ObservableArrayList<Todo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            // initialize
            todoList.add(Todo(1, "Test1"))
            todoList.add(Todo(2, "Test2"))
        } else {
            StateSaver.restoreInstanceState(this, savedInstanceState)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        StateSaver.saveInstanceState(this, outState)
    }
}
