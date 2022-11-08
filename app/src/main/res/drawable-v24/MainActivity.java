package drawable

import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.app.DatePickerDialog
import androidx.annotation.RequiresApi
import android.os.Build
import android.annotation.SuppressLint
import android.os.Bundle
import android.app.DatePickerDialog.OnDateSetListener
import android.widget.DatePicker
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.view.View
import android.widget.Button
import java.util.*

class MainActivity(var picker: DatePickerDialog) : AppCompatActivity() {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //e_dob.setOnClickListener(View.OnClickListener { view: View? ->
            val calendar = Calendar.getInstance()
            val day = calendar[Calendar.DAY_OF_MONTH]
            val month = calendar[Calendar.MONTH]
            val year = calendar[Calendar.YEAR]
        var <> picker = DatePickerDialog(
            this@MainActivity,
            { view1: DatePicker?, year1: Int, month1: Int, dayOfMonth: Int ->
                val e_dob
                e_dob.setText(
                    dayOfMonth.toString() + "/" + (month1 + 1) + "/" + year1
                )
            },
            year,
            month,
            day
        )
        picker.datePicker.maxDate = Date().time
            picker.show()
        })
        val datePickerListener: OnDateSetListener
        datePickerListener = OnDateSetListener { datePicker, day, month, year ->
            val calendar = Calendar.getInstance()
            calendar[Calendar.DAY_OF_MONTH] = day
            calendar[Calendar.MONTH] = month
            calendar[Calendar.YEAR] = year
            val format = SimpleDateFormat("dd MM yyyy").format(calendar.time)
            e_dob.setText(format)
            age = getText(Integer.toString(calculateAge(calendar.timeInMillis))) as TextView?
        }
        val button = findViewById<View>(R.id.button) as Button
        button.setOnClickListener { view: View? ->
            val username = name.getText().toString()
            val usersurname = surname.getText().toString()
            val userage = age.getText().length
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra("keyname", username)
            intent.putExtra("keysurname", usersurname)
            intent.putExtra("keyage", userage)
            startActivity(intent)
        }
        var calculateAge: Int
        val date: Long = 0
        run {
            val dob = Calendar.getInstance()
            dob.timeInMillis = date
            val today = Calendar.getInstance()
            var age = today[Calendar.YEAR] - dob[Calendar.YEAR]
            if (today[Calendar.DAY_OF_MONTH] < dob[Calendar.DAY_OF_MONTH]) {
                age--
            }
            return
        }
    }

    private fun getText(toString: String): Any? {
        return null
    }

    private fun calculateAge(timeInMillis: Long): Int {
        return 0
    }
}