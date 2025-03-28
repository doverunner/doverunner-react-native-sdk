package com.pallycon.multidrm.models

import com.google.gson.Gson
import java.util.HashMap
import com.facebook.react.bridge.WritableMap
import com.facebook.react.bridge.Arguments

data class ProgressMessage(
    val url: String,
    val percent: Float,
    val downloadedBytes: Long
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }

    fun toMap(): MutableMap<String, Any> {
        val event: MutableMap<String, Any> = HashMap()
        event["url"] = url
        event["percent"] = percent
        event["downloadedBytes"] = downloadedBytes

        return event
    }

    fun toReactMap(): WritableMap {
        val map = Arguments.createMap()
        map.putString("url", url)
        map.putDouble("percent", percent.toDouble())
        map.putInt("downloadedBytes", downloadedBytes.toInt())
        return map
    }
}
