package com.rappi.movies.domain.movie.video

import com.rappi.movies.presentation.feature.video.VideoModel

class VideoModelMapper {
    fun parse(input: Video) = VideoModel(input.key)
}