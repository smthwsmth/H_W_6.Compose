package com.example.hw6compose.data

data class MatchItem(
    val matchNumber: String,
    val roundNumber: String,
    val dateUtc: String,
    val location: String,
    val homeTeam: String,
    val awayTeam: String,
    val group: String,
    val homeTeamScore: String,
    val awayTeamScore: String
)