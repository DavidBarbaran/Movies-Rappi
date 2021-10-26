package com.rappi.movies.data.movie.video

import com.rappi.movies.domain.movie.video.Video

class VideoMapper {

    fun parse(input: VideoResponse?) : Video {
        val firstVideoResponse = input?.results?.first()
        return Video(firstVideoResponse?.key ?: "")
    }
}