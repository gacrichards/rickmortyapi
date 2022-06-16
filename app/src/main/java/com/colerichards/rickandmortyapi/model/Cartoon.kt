package com.switchboard.rickandmortyapi.model

data class Cartoon(
    val name: String,
    val image: String
)

data class ApiResult(val info: ApiMeta, val results: List<Cartoon>)
data class ApiMeta(val count: Int, val pages: Int, val next: String, val prev: String)
