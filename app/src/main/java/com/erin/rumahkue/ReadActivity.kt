package com.erin.rumahkue

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.*
import java.lang.Exception
import java.lang.StringBuilder

class ReadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read)

        val fileName = findViewById<EditText>(R.id.editFile)
        val fileData = findViewById<EditText>(R.id.editData)

        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnView = findViewById<Button>(R.id.btnView)

        // memberikan klik listener pada button dengan id: btnSave
        // saat button diklik maka File Data yang kita tulis akan tersimpan di storage
        btnSave.setOnClickListener(View.OnClickListener {
            val file:String = fileName.text.toString()
            val data:String = fileData.text.toString()
            val fileOutputStream:FileOutputStream
            try {
                // Metode OpenFileOutput() digunakan untuk mengembalikan instance kelas FileOutputStream.
                fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
                // kita panggil metode fileOutputStream.write untuk menulis data ke dalam file
                fileOutputStream.write(data.toByteArray())

            }catch (e:FileNotFoundException){
                e.printStackTrace()
            }catch (e:NumberFormatException){
                e.printStackTrace()
            }catch (e:IOException){
                e.printStackTrace()
            }catch (e:Exception){
                e.printStackTrace()
            }
            Toast.makeText(applicationContext,"data save",Toast.LENGTH_LONG).show()
            fileName.text.clear()
            fileData.text.clear()
        })

        // memberikan klik listener pada button dengan id: btnView
        // saat button diklik akan menjalankan fungsi reading
        btnView.setOnClickListener(View.OnClickListener {
            val filename = fileName.text.toString()
            if(filename.toString()!=null&&filename.toString().trim()!=""){
                // Untuk membaca file dari penyimpanan internal perangkat,
                // metode openFileInput() digunakan untuk mengembalikan instance kelas FileInputStream
                var fileInputStream:FileInputStream? = null
                fileInputStream = openFileInput(filename)
                var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
                // Untuk membaca data dari file kita bisa panggil BufferedReader().readLine()
                val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
                val stringBuilder: StringBuilder = StringBuilder()
                var text: String? = null
                while ({text = bufferedReader.readLine();text}()!=null){
                    stringBuilder.append(text)
                }

                // ini digunakan untuk menampilkan data pada EditText
                fileData.setText(stringBuilder.toString()).toString()
            }else{
                Toast.makeText(applicationContext,"file name cannot be blank",Toast.LENGTH_LONG).show()
            }

        })
    }
}