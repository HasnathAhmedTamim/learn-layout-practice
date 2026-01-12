package com.example.layoutpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.layoutpractice.ui.theme.LayoutPracticeTheme

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import java.net.URL

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutPracticeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Day1ModifierPractice()
                    Day2ColumnPractice()
                }
            }
        }
    }
}


@Composable
fun Day1ModifierPractice() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "DAY 1: Modifiers",
            style = MaterialTheme.typography.headlineMedium
        )

        // Exercise 1: Padding and Background
        Text(
            text = "Box with padding",
            modifier = Modifier
                .size(300.dp,300.dp).background(Color.Yellow)
                .padding(40.dp),
            color = Color.White
        )

        // Exercise 2: Size modifiers
        Text(
            text = "Fixed size box",
            modifier = Modifier
                .size(200.dp, 60.dp)
                .background(Color.Cyan),
            color = Color.White
        )

        // Exercise 3: Fill width
        Text(
            text = "Full width",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Magenta)
                .padding(16.dp),
            color = Color.White
        )
//         My custom text
        Text(
            text = "my custom text",
            modifier = Modifier.fillMaxSize()
                .background(Color(0xFFFF9800))
                .padding(16.dp),
            color = Color.White
        )
    }

}


//@Preview(showBackground = true)
//@Composable
//fun PreviewDay1() {
//    LayoutPracticeTheme {
//        Day1ModifierPractice()
//    }
//}

@Composable
fun Day2ColumnPractice() {
    // Example 1: Top arrangement
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp)
    ) {
        Text("DAY 2: Column Arrangements", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        // Practice: Items at Top
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.White),
            verticalArrangement = Arrangement.Top
        ) {
            Box(modifier = Modifier.size(50.dp).background(Color.Red))
            Box(modifier = Modifier.size(50.dp).background(Color.Green))
            Box(modifier = Modifier.size(50.dp).background(Color.Blue))
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Practice: Items Centered
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.White),
            verticalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier.size(50.dp).background(Color.Red))
            Box(modifier = Modifier.size(50.dp).background(Color.Green))
            Box(modifier = Modifier.size(50.dp).background(Color.Blue))
        }
        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.White),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text("First")
            Text("Middle")
            Text("Last")
        }

    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewDay2() {
//    LayoutPracticeTheme {
//        Day2ColumnPractice()
//    }
//}

@Composable
fun Day3RowAndAlignment() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("DAY 3: Row & Alignment", style = MaterialTheme.typography.headlineMedium)

        // Horizontal arrangement
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color(0xFFE3F2FD)),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.size(50.dp).background(Color.Red))
            Box(modifier = Modifier.size(50.dp).background(Color.Green))
            Box(modifier = Modifier.size(50.dp).background(Color.Blue))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("First Line")
        Text("Second Line")

        // Alignment practice
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color(0xFFFFF3E0)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top
        ) {
            Text("Top Aligned")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color(0xFFF3E5F5)),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Center Aligned")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color(0xFFE8F5E9)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            Text("Bottom Aligned")
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewDay3() {
//    LayoutPracticeTheme {
//        Day3RowAndAlignment()
//    }
//}

@Composable
fun Day4BoxAlignment() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("DAY 4: Box Alignments", style = MaterialTheme.typography.headlineMedium)

        // All 9 alignments
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Top Start
            AlignmentBox(Alignment.TopStart, "TS")
            AlignmentBox(Alignment.TopCenter, "TC")
            AlignmentBox(Alignment.TopEnd, "TE")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AlignmentBox(Alignment.CenterStart, "CS")
            AlignmentBox(Alignment.Center, "C")
            AlignmentBox(Alignment.CenterEnd, "CE")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AlignmentBox(Alignment.BottomStart, "BS")
            AlignmentBox(Alignment.BottomCenter, "BC")
            AlignmentBox(Alignment.BottomEnd, "BE")
        }
    }
}

@Composable
fun AlignmentBox(alignment: Alignment, label: String) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color(0xFFE0E0E0)),
        contentAlignment = alignment
    ) {
        Box(
            modifier = Modifier
                .size(30.dp)
                .background(Color.Blue)
        ) {
            Text(
                label,
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Composable
fun ProfileCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color(0xFF6200EE))
    ) {
        // Profile picture - Top Start
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.White)
                .align(Alignment.TopStart)
                .padding(16.dp)
        )

        // Name - Bottom Center
        Text(
            text = "John Doe",
            color = Color.White,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        )

        // Edit button - Top End
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.White)
                .align(Alignment.TopEnd)
                .padding(16.dp)
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewDay4() {
//    LayoutPracticeTheme {
////        Day4BoxAlignment()
//        ProfileCard()
//    }
//}

/*
* LazyRow — a horizontally scrolling list in Jetpack Compose that creates (composes) only visible items for performance.
contentPadding: PaddingValues — adds padding around the whole scrolling content (start/end/top/bottom).
items / item — builder functions inside LazyRow / LazyColumn that emit child composables lazily.
* Use items(count) or items(yourList); the lambda runs when the item becomes visible.
* */
@Composable
fun Day5ScrollingLists() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            "DAY 5: Scrolling Lists",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )

        // Horizontal scroll
        Text("Horizontal Scroll:", modifier = Modifier.padding( horizontal =  16.dp))
        LazyRow(
            contentPadding = PaddingValues(4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(10) { index ->
                Card(
                    modifier = Modifier
                        .size(120.dp, 160.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF2196F3)
                    )
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Item $index", color = Color.White)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Vertical scroll
        Text("Vertical Scroll:", modifier = Modifier.padding(horizontal = 16.dp))
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(20) { index ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .background(Color(0xFF4CAF50))
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text("List Item $index")
                    }
                }
            }
        }
    }
}
//data class Contact(val name: String, val phone: String)
suspend fun fetchContactsFromUrl(url: String): List<Contact> = withContext(Dispatchers.IO) {
    try {
        val json = URL(url).readText()
        val arr = JSONArray(json)
        val list = mutableListOf<Contact>()
        for (i in 0 until arr.length()) {
            val obj = arr.getJSONObject(i)
            val name = obj.optString("name")
            val phone = obj.optString("phone")
            if (name.isNotEmpty()) list.add(Contact(name, phone))
        }
        list
    } catch (e: Exception) {
        emptyList<Contact>()
    }
}

@Composable
fun ContactListFromNetwork(url: String = "https://jsonplaceholder.typicode.com/users") {
    val contacts by produceState(initialValue = emptyList<Contact>(), key1 = url) {
        value = fetchContactsFromUrl(url)
    }

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(contacts) { contact ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(contact.name, style = MaterialTheme.typography.titleMedium)
                    Text(contact.phone, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}
//@Composable
//fun ContactList() {
//    val contacts = listOf(
//        Contact("Alice", "123-456-7890"),
//        Contact("Bob", "234-567-8901"),
//        Contact("Charlie", "345-678-9012"),
//        Contact("Diana", "456-789-0123"),
//        Contact("Eve", "567-890-1234")
//    )
//
//    LazyColumn(
//        contentPadding = PaddingValues(16.dp),
//        verticalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        items(contacts) { contact ->
//            Card(modifier = Modifier.fillMaxWidth()) {
//                Column(modifier = Modifier.padding(16.dp)) {
//                    Text(contact.name, style = MaterialTheme.typography.titleMedium)
//                    Text(contact.phone, style = MaterialTheme.typography.bodyMedium)
//                }
//            }
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun PreviewDay5() {
    LayoutPracticeTheme {
//        Day5ScrollingLists()
//        ContactList()
        ContactListFromNetwork()
    }
}