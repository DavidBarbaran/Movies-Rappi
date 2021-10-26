package com.rappi.movies.data.movie.video

import com.google.gson.annotations.SerializedName

data class VideoResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("results") val results: List<VideoItemResponse>,
) {
    data class VideoItemResponse(
        @SerializedName("key") val key: String,
    )
}