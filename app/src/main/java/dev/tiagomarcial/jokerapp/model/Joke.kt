package dev.tiagomarcial.jokerapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serial

data class Joke(
    @SerializedName("value") val text: String,
    @SerializedName ("icon_url") val iconUrl: String
)