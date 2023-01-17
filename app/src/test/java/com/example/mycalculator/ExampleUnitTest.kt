package com.example.mycalculator

import org.junit.Assert.*
import org.junit.Test
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun splitString() {
        val numbers = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
        val operators = listOf("-", "*", "+", "/")
        val prefix = ""

        val inputField = "8/2/3/5/7"
        val result = inputField.split("/")

        println(result)
    }

    @Test
    fun getTimeInMilliseconds() {
        val currentTime =  System.currentTimeMillis() //Long 1111233333

        val convertMillisecondsToTime = Date(currentTime).time

        val selectedDate = "Sat Jun 01 12:53:10 IST 2013"
        val birthDate = SimpleDateFormat("E MMM dd HH:mm:ss z yyyy", Locale.ENGLISH)
        val birthDateTime = birthDate.parse(selectedDate) as Date
        val birthDateResult = convertMillisecondsToTime.minus(birthDateTime.time)

        /*val date = Date(birthDateResult)
        val format = SimpleDateFormat("mm")*/

        println("$convertMillisecondsToTime and ${birthDateTime.time}")
    }

    @Test
    fun dateDiff(){
        val dateFormatter: DateTimeFormatter =  DateTimeFormatter.ofPattern("MM/dd/yyyy")

        val from = LocalDate.parse("09/25/1995", dateFormatter)
        val to = LocalDate.parse("01/17/2023", dateFormatter)

        val period = Period.between(from, to)
        val years = period.years
        val months = period.months
        val days = period.days
        println("Years is $years, months is $months, days is $days")
    }

    /*fun clickDatePicker(context: Context){

        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(context,
            DatePickerDialog.OnDateSetListener{ view, selectedYear, selectedMonth, selectedDayOfMonth ->
                Toast.makeText(context,
                    "Year was $selectedYear, month was ${selectedMonth +1}" +
                            " day of month was $selectedDayOfMonth", Toast.LENGTH_LONG).show()
                val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"

                tvSelectedDate?.text = selectedDate

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val theDte = sdf.parse(selectedDate)

                val selectedDateInMinutes = theDte.time /60_000

                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                val currentDateInMinutes = currentDate.time/60_000

                val differentInMinutes = currentDateInMinutes - selectedDateInMinutes

                val hours = SimpleDateFormat(":mm")


                tvAgeInMinutes?.text = hours.format(selectedDateInMinutes).toString()



            },
            year,
            month,
            day
        )
        dpd.datePicker.maxDate = System.currentTimeMillis() - 86_400_000
        dpd.show()

    }*/

}