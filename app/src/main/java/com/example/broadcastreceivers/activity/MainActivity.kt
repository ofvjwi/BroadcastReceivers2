package com.example.broadcastreceivers.activity

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.broadcastreceivers.R
import com.example.broadcastreceivers.receivers.NetworkBroadcastReceiver

class MainActivity : AppCompatActivity() {

    private lateinit var receivers: NetworkBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        receivers = NetworkBroadcastReceiver()
    }

    override fun onStart() {
        super.onStart()
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(receivers, filter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receivers)
    }
}


