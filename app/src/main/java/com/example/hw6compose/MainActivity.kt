package com.example.hw6compose

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.hw6compose.data.MatchItem
import com.example.hw6compose.screens.MatchListItem
import com.example.hw6compose.screens.ScreenWithButtons
import com.example.hw6compose.theme.HW6ComposeTheme


import org.json.JSONArray

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            HW6ComposeTheme{
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "welcome_screen") {
                    composable("welcome_screen") { WelcomeScreen(navController) }
                    composable("main_screen") { MainScreen(context = this@MainActivity) }
                }

            }
        }
    }
}




@Composable
fun MainScreen(context: Context) {
        


    val matchesList = remember {
        mutableStateOf(listOf<MatchItem>())
    }

    getData(matchesList, context = context)

    LazyColumn(modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(
            matchesList.value
        ) {
                _, item ->
            MatchListItem(item)
        }
    }
}


@Composable
fun WelcomeScreen(navController: NavHostController) {
    ScreenWithButtons(navController)



}


private fun getData(matchesList: MutableState<List<MatchItem>>, context: Context) {
    val url: String = "https://fixturedownload.com/feed/json/epl-2021"

    val queue = Volley.newRequestQueue(context)
    val sRequest = StringRequest(
        Request.Method.GET,
        url,
        {
                response ->
            parseJson(response)
            val list = parseJson(response)
            matchesList.value = list
        },
        {
            Log.d("MyLog", "Volley.error $it")
        }
    )
    queue.add(sRequest)

}

fun parseJson(response: String): List<MatchItem> {

    if (response.isEmpty()) return listOf()
    val list = ArrayList<MatchItem>()
    val mainObject = JSONArray(response)
    for (i in 0 until mainObject.length()) {
        val matchNumber = mainObject.getJSONObject(i).getString("MatchNumber").toString()
        val roundNumber: String = mainObject.getJSONObject(i).getString("RoundNumber").toString()
        val dateUtc: String = mainObject.getJSONObject(i).getString("DateUtc").toString()
        val location: String = mainObject.getJSONObject(i).getString("Location").toString()
        val homeTeam: String = mainObject.getJSONObject(i).getString("HomeTeam").toString()
        val awayTeam: String = mainObject.getJSONObject(i).getString("AwayTeam").toString()
        val group: String = mainObject.getJSONObject(i).getString("Group").toString()
        val homeTeamScore: String = mainObject.getJSONObject(i).getString("HomeTeamScore").toString()
        val awayTeamScore: String = mainObject.getJSONObject(i).getString("AwayTeamScore").toString()
        list.add(MatchItem(matchNumber, roundNumber, dateUtc, location, homeTeam, awayTeam, group, homeTeamScore, awayTeamScore))

    }
    return list

}





