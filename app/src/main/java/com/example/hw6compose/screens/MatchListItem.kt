package com.example.hw6compose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hw6compose.R
import com.example.hw6compose.data.MatchItem
import com.example.hw6compose.theme.LightBlue


@Composable
fun MatchListItem(matchItem: MatchItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp),
        backgroundColor = LightBlue,
        elevation = 1.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            ) {

            Image(

                painter = painterResource(id = getTeamsLogo(matchItem.homeTeam)),
                contentDescription = "logo_home_team",
                modifier = Modifier.size(40.dp).padding(start = 5.dp)
            )
            Text(
                modifier = Modifier.padding(start = 3.dp).fillMaxWidth(0.4f),
                text = matchItem.homeTeam,
                style = TextStyle(fontSize = 25.sp),
                color = Color.White,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1

            )
        }


        Row(modifier = Modifier.padding(top = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.Center
        ) {
            Text(
                text = matchItem.homeTeamScore,
                style = TextStyle(fontSize = 25.sp),
                color = Color.White,

            )
            Text(
                text = " : ",
                style = TextStyle(fontSize = 25.sp),
                color = Color.White
            )

            Text(
                text = matchItem.awayTeamScore,
                style = TextStyle(fontSize = 25.sp),
                color = Color.White
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.Right) {


            Text(
                modifier = Modifier.padding(end = 0.dp).fillMaxWidth(0.3f),
                text = matchItem.awayTeam,
                style = TextStyle(fontSize = 25.sp),
                color = Color.White,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            Image(
                painter = painterResource(id = getTeamsLogo(matchItem.awayTeam)),
                contentDescription = "logo_away_team",
                modifier = Modifier.size(40.dp).padding(end = 5.dp)
            )
        }


    }


}

fun getTeamsLogo(teamName: String): Int {
    val teamsLogo = mapOf(
        "arsenal" to R.drawable.arsenal,
        "aston villa" to R.drawable.aston_villa,
        "brentford" to R.drawable.brentford,
        "brighton" to R.drawable.brighton,
        "burnley" to R.drawable.burnley,
        "chelsea" to R.drawable.chelsea,
        "crystal palace" to R.drawable.crystal_palace,
        "everton" to R.drawable.everton,
        "leeds" to R.drawable.leeds,
        "leicester" to R.drawable.leicester,
        "liverpool" to R.drawable.liverpool,
        "man city" to R.drawable.mancity,
        "man utd" to R.drawable.manutd,
        "newcastle" to R.drawable.newcastle,
        "norwich" to R.drawable.norwich,
        "southampton" to R.drawable.southampton,
        "spurs" to R.drawable.spurs,
        "watford" to R.drawable.watford,
        "west ham" to R.drawable.west_ham,
        "wolves" to R.drawable.wolves
    )

    return teamsLogo.getOrDefault(teamName.lowercase(), R.drawable.ic_football)
}

