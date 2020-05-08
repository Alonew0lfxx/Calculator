package com.example.again;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private Button but0;
    private Button but1;
    private Button but2;
    private Button but3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnArti;
    private Button btnEksi;
    private Button btnCarpi;
    private Button btnBolme;
    private Button btnAC;
    private RecyclerView recyclerView;
    private TextView textCevap;
    private ArrayList<DataSet> islemListesi;
    private LinearLayoutManager manager;
    private CustomRecyclerViewAdapter adapter;
    String TAG ="MainActivity";
    private Button btnSonuc;


    public void setViewIds() {
        recyclerView = findViewById(R.id.recyclerView);
        but0 = findViewById(R.id.btn0);
        but1 = findViewById(R.id.btn1);
        but2 = findViewById(R.id.btn2);
        but3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnArti = findViewById(R.id.btnToplama);
        btnEksi = findViewById(R.id.btnCikarma);
        btnCarpi = findViewById(R.id.btnCarp);
        btnBolme = findViewById(R.id.btnBol);
        btnAC = findViewById(R.id.btnAC);
        btnSonuc = findViewById(R.id.btnSonuc);
        textCevap = findViewById(R.id.tvAnswer);
        //OnClicks
        but0.setOnClickListener(this);
        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnArti.setOnClickListener(this);
        btnEksi.setOnClickListener(this);
        btnCarpi.setOnClickListener(this);
        btnBolme.setOnClickListener(this);
        btnAC.setOnClickListener(this);
        textCevap.setOnClickListener(this);
        btnSonuc.setOnClickListener(this);



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViewIds();
        //İşlem sırası veya listesi
        islemListesi = new ArrayList<>();
        islemListesi.add(new DataSet("0"));
        manager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        adapter = new CustomRecyclerViewAdapter(this,islemListesi);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

    }

    /**
     * @param v Dokunduğumuz herhangi bir obje
     */
    @Override
    public void onClick(View v) {

        try {

            //TODO Eğer ArrayList + - / * ile bitiyorsa...
            int sonIslemPosition = islemListesi.size() -1;
            DataSet sonIslem = islemListesi.get(sonIslemPosition);


            if ("+|-|/|*".contains(sonIslem.getIslem())) {
                Log.i(TAG, "onClick: +-/*");
                //Toplama cikarma islemleri
                //AC- Eşittir
                switch (v.getId()) {

                    case R.id.btnToplama:
                        break;

                    case R.id.btnCikarma:
                        break;

                    case R.id.btnBol:
                        break;

                    case R.id.btnCarp:
                        break;

                    case R.id.btnAC:
                        break;

                    case R.id.btnSonuc:
                        break;

                }

                //Rakamlar
                switch (v.getId()) {

                    case R.id.btn0:
                        islemListesi.add(new DataSet("0"));
                        break;

                    case R.id.btn1:
                        islemListesi.add(new DataSet("1"));
                        break;

                    case R.id.btn2:
                        islemListesi.add(new DataSet("2"));
                        break;

                    case R.id.btn3:
                        islemListesi.add(new DataSet("3"));
                        break;

                    case R.id.btn4:
                        islemListesi.add(new DataSet("4"));
                        break;

                    case R.id.btn5:
                        islemListesi.add(new DataSet("5"));

                        break;

                    case R.id.btn6:
                        islemListesi.add(new DataSet("6"));
                        break;

                    case R.id.btn7:
                        islemListesi.add(new DataSet("7"));
                        break;

                    case R.id.btn8:
                        islemListesi.add(new DataSet("8"));
                        break;

                    case R.id.btn9:
                        islemListesi.add(new DataSet("9"));
                        break;
                }

            } else {
                Log.i(TAG, "onClick: 0....9");
                //TODO Eğer Arraylist Bir sayı ile bitiyorsa

                //Toplama cikarma islemleri
                //AC- Eşittir
                switch (v.getId()) {

                    case R.id.btnToplama:
                        islemListesi.add(new DataSet("+"));
                        break;

                    case R.id.btnCikarma:
                        islemListesi.add(new DataSet("-"));
                        break;

                    case R.id.btnBol:
                        islemListesi.add(new DataSet("/"));
                        break;

                    case R.id.btnCarp:
                        islemListesi.add(new DataSet("*"));
                        break;

                    case R.id.btnAC:
                        islemListesi.clear();
                        islemListesi.add(new DataSet("0"));
                        textCevap.setText("= 0");
                        break;

                    case R.id.btnSonuc:
                        Log.w(TAG, "onClick: btnSonuc");
                        int answer = 0;
                        String lastValue= "";

                        for (int i = 0; i < islemListesi.size(); i++) {
                            String  okunanIslem = islemListesi.get(i).getIslem();
                            switch (lastValue) {
                                case "+":
                                    answer = answer + Integer.valueOf(okunanIslem);
                                    break;
                                case "-":
                                    answer = answer - Integer.valueOf(okunanIslem);
                                    break;
                                case "/":
                                    answer = answer / Integer.valueOf(okunanIslem);
                                    break;
                                case "*":
                                    answer = answer * Integer.valueOf(okunanIslem);
                                    break;

                                default:            //Rakam ise
                                    if (!"+|-|/|*".contains(okunanIslem)) {
                                        answer = Integer.valueOf(okunanIslem);
                                    }
                                    break;
                            }
                            lastValue = okunanIslem;
                        }
                        textCevap.setText("= "+ answer);
                        break;

                }

                //Rakamlar
                if (sonIslem.getIslem().equals("0")) {
                    sonIslem.setIslem("");
                }
                switch (v.getId()) {

                    case R.id.btn0:
                        if (!sonIslem.getIslem().equals("0")) {
                            sonIslem.setIslem(sonIslem.getIslem() + "0");
                        }
                        break;

                    case R.id.btn1:
                        sonIslem.setIslem(sonIslem.getIslem() + "1");
                        break;

                    case R.id.btn2:
                        sonIslem.setIslem(sonIslem.getIslem() + "2");
                        break;

                    case R.id.btn3:
                        sonIslem.setIslem(sonIslem.getIslem() + "3");
                        break;

                    case R.id.btn4:
                        sonIslem.setIslem(sonIslem.getIslem() + "4");
                        break;

                    case R.id.btn5:
                        sonIslem.setIslem(sonIslem.getIslem() + "5");
                        break;

                    case R.id.btn6:
                        sonIslem.setIslem(sonIslem.getIslem() + "6");
                        break;

                    case R.id.btn7:
                        sonIslem.setIslem(sonIslem.getIslem() + "7");
                        break;

                    case R.id.btn8:
                        sonIslem.setIslem(sonIslem.getIslem() + "8");
                        break;

                    case R.id.btn9:
                        sonIslem.setIslem(sonIslem.getIslem() + "9");
                        break;
                }
            }
            /**
             * Bütün işlemler yapıldıktan sonra recyclerView'a bir item veri değişti/eklendi
             * uyarısı gönder!
             */
            adapter.notifyDataSetChanged();
          /*  if (islemListesi.size() == sonIslemPosition +1) {
                Log.w(TAG, "onClick: notifyItemChanged!" );
                adapter.notifyItemChanged(sonIslemPosition);
            } else {
                Log.w(TAG, "onClick: notifyItemInserted!" );
                adapter.notifyItemInserted(islemListesi.size() +1);
            }*/


        } catch (Exception e) {
            /**
             * Eğer tuşlara dokunmada bir hata meydana gelirse
             * ErrorActivity Sınıfı açılacaktır ve bu activty kapanacaktır.
             */
            Intent intent = new Intent(MainActivity.this,ErrorActivity.class);
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            e.printStackTrace();
            intent.putExtra("errorCode",errors.getBuffer().toString());
            startActivity(intent);
            finish();

        }


    }


    public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.ViewHolder> {
        Context context;
        ArrayList<DataSet> dataSets;
        LayoutInflater layoutInflater;
        ViewHolder viewHolder;
        View view; //Listede görünen bir obje // ör. Textview olabilir!

        public CustomRecyclerViewAdapter(Context context, ArrayList<DataSet> dataSets) {
            this.context = context;
            this.dataSets = dataSets;
            layoutInflater = LayoutInflater.from(context);
        }

        @NonNull
        @Override
        public CustomRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            view = layoutInflater.inflate(R.layout.recyclerview_item, parent, false);
            viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull CustomRecyclerViewAdapter.ViewHolder holder, int position) {
            DataSet dataSet = dataSets.get(position);
            holder.setData(dataSet);
        }

        @Override
        public int getItemCount() {
            return dataSets.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            private final EditText editText;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                editText = itemView.findViewById(R.id.editTextt);
            }

            public void setData(DataSet data) {
                editText.setText(data.getIslem());
            }
        }
    }

    public class DataSet {

        /**
         * İslem Stringi '+'.'-','*','/', Gibi  değerleri  veya 0...9 rakamlarını alabilir
         * eğer burada sayı varsa son daki işlemi düzenleyeceğiz yoksa  yani bir işlem yapmamızı istiyorsa
         * 2 + ...
         */
        String islem;

        public DataSet(String islem) {
            this.islem = islem;
        }

        public String getIslem() {
            return islem;
        }

        public void setIslem(String islem) {
            this.islem = islem;
        }
    }



}