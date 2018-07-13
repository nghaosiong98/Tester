package com.example.haosiong.tester;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import crl.android.pdfwriter.PDFWriter;
import crl.android.pdfwriter.PaperSize;
import crl.android.pdfwriter.StandardFonts;

public class Report extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
    }

    public void generateReport(){
        PDFWriter writer = new PDFWriter(PaperSize.A4_WIDTH, PaperSize.A4_HEIGHT);
        writer.setFont(StandardFonts.SUBTYPE, StandardFonts.TIMES_BOLD, StandardFonts.WIN_ANSI_ENCODING);
        writer.addText(1,2,10,"Hello world");
        outputToFile("MyFirstReport.pdf", writer.asString(), "ISO-8859-1");
    }

    public void outputToFile(String fileName, String pdfContent, String encoding) {
        String state = Environment.getExternalStorageState();

        if(Environment.MEDIA_MOUNTED.equals(state)){
            File Root = Environment.getExternalStorageDirectory();
            File dir = new File(Root.getAbsolutePath()+ "/PDFdatabase");
            File newFile = new File(dir + "/" +  fileName);
            if(!newFile.exists()){
                newFile.mkdir();
            }


        }



//        try {
//            newFile.createNewFile();
//
//            try {
//                FileOutputStream pdfFile = new FileOutputStream(newFile);
//                pdfFile.write(pdfContent.getBytes(encoding));
//                pdfFile.close();
//                Toast.makeText(getApplicationContext(),"PDF created",Toast.LENGTH_LONG).show();
//            } catch(FileNotFoundException e) {
//                // ...
//            }
//
//        } catch(IOException e) {
//            // ...
//        }
    }
}
