package com.example.thooughtctl_app.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class Constants {
    companion object{
        const val clientId = "c2396cadbdbd76d"
        const val BASEURL = "https://api.imgur.com/"


        fun setDateTime(timestamp: Long): String? {
            val dateFormat = SimpleDateFormat("dd/MM/yy hh:mm a", Locale.getDefault())
            val date = Date(timestamp)
            return dateFormat.format(date)
        }
    }




}