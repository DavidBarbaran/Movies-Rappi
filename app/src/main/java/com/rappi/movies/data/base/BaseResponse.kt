package com.rappi.movies.data.base

import com.google.gson.annotations.SerializedName

open class BaseResponse<T> (
    @SerializedName("page")
    val page: Int?,
    @SerializedName("total_results")
    val totalResults: Int?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("results")
    val results: List<T>?
)