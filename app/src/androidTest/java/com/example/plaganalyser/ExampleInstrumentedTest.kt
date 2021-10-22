/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.plaganalyser

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


/**
 * This is not meant to be a full set of tests. For simplicity, most of your samples do not
 * include tests. However, when building the Room, it is helpful to make sure it works before
 * adding the UI.
 */

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.plaganalyser", appContext.packageName)
    }
}


@RunWith(AndroidJUnit4::class)
class WordDatabaseTest {

    private lateinit var textDao: TextDao
    private lateinit var hashDao: HashDao
    private lateinit var db: WordDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, WordDatabase::class.java)
                // Allowing main thread queries, just for testing.
                .allowMainThreadQueries()
                .build()
        textDao = db.textDao
        hashDao = db.hashDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetText(){
        val sampleString = "This is the first sample text i am sending for testing"
        val inText = TextTable(1, sampleString)
        textDao.insertText(inText)
        val outText = textDao.getText(1)[0]
        assertEquals(outText, sampleString)
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetHash(){
        val hashObject = HashTable(2, "get", 10)
        hashDao.insertHash(hashObject)

        val outFind = hashDao.findHashWord(2, "get")
        hashDao.incrementHashFrequency(2, "get")

        val outFrequecy = hashDao.getHashFrequency(2, "get")[0]

        assertEquals(outFind, 1)
        assertEquals(outFrequecy, 11)
    }

//    @Test
//    @Throws(Exception::class)
//    fun insertAndGetNight() {
//        val night = SleepNight()
//        sleepDao.insert(night)
//        val tonight = sleepDao.getTonight()
//        assertEquals(tonight?.sleepQuality, -1)
//    }
}