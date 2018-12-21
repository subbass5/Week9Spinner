package com.computersoftware.week9.week9spinner;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spn_foods,spn_maket;
    Button btn_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn_foods = findViewById(R.id.spn_foods);
        spn_maket = findViewById(R.id.spn_maket);

        btn_order = findViewById(R.id.btn_order);

        final String [] arrFood = {"ส้าจิ้น","ลาบเหนียว","ใส้เพี้ยจี่","คอหมูย่าง"};
        String [] arrMaket = {"ป้ามา","ครัวจิ้นสด","หนานเนียง"};

        ArrayAdapter<String> arrayAdapter_food
                = new ArrayAdapter<String>(MainActivity.this,
                                            android.R.layout.simple_dropdown_item_1line,
                                            arrFood);
        ArrayAdapter<String> arrayAdapter_maket
                = new ArrayAdapter<String>(MainActivity.this,
                                            android.R.layout.simple_dropdown_item_1line,
                                            arrMaket);
        spn_foods.setAdapter(arrayAdapter_food);
        spn_maket.setAdapter(arrayAdapter_maket);

        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String food = spn_foods.getSelectedItem().toString();
                String maket = spn_maket.getSelectedItem().toString();

                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(maket);
                builder.setMessage("สั่งซื้ออาหาร :" +food+" เรียบร้อยแล้ว");
                builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,
                                "ขอบคุณที่อุดหนุน", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();



            }
        });


        spn_foods.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
//                Toast.makeText(MainActivity.this,
//                        "คุณเลือกอาหาร :"+arrFood[position],
//                        Toast.LENGTH_SHORT).show();

//                Toast.makeText(MainActivity.this,
//                        ""+spn_foods.getSelectedItem(),
//                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spn_maket.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
//                Toast.makeText(MainActivity.this,
//                        ""+spn_maket.getSelectedItemId()
//                        , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
//        spn_maket.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });


    }
}
