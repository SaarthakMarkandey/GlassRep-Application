package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class cartactivity extends AppCompatActivity {
    private ArrayList<Affirmation>affirmation;
    private RecyclerView mrecyclerView;
    private RecyclerViewAdapter madapter;
    private RecyclerView.LayoutManager mlayoutManager;
    private View view1,view2;
    private TextView totalItem,totalAmount;
    private int sum=0,item=0;
    private ImageView infobtn;
    private Button continueshopping;
    private Toolbar toolbar;
   private  ImageView backimg;
//    private Button buttonInsert;
//    private Button buttonRemove;
//    private EditText editTextInsert;
//    private EditText editTextRemove;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view1=getLayoutInflater().inflate(R.layout.activity_cartactivity,null);
        view2=getLayoutInflater().inflate(R.layout.empty_cartview,null);
        setContentView(view1);
        totalAmount=(TextView) findViewById(R.id.total_price);
        totalItem=(TextView) findViewById(R.id.total_item);
        backimg=(ImageView)findViewById(R.id.img_back_cart);
        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(cartactivity.this,MainActivity.class));
            }
        });
//        toolbar=(Toolbar)findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        createAffirmation();
        buildRecyclerView();
        infobtn=(ImageView)findViewById(R.id.info_btn);
        infobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mrecyclerView.smoothScrollToPosition(affirmation.size());
            }
        });


//        buttonInsert=findViewById(R.id.button_insert);
//        buttonRemove=findViewById(R.id.button_remove);
//        editTextInsert=findViewById(R.id.edittext_insert);
//        editTextRemove=findViewById(R.id.edittext_remove);
//        buttonInsert.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position=Integer.parseInt(editTextInsert.getText().toString());
//                insertItem(position);
//            }
//        });
//        buttonRemove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position=Integer.parseInt(editTextRemove.getText().toString());
//                removeItem(position);
//            }
//        });


    }
    public void changeheartimg(int position){
        if(affirmation.get(position).getmWishimg()==R.drawable.ic_baseline_favorite_border_24){
            affirmation.get(position).changeWish(R.drawable.ic_baseline_favorite_24);
        }
        else {
            affirmation.get(position).changeWish(R.drawable.ic_baseline_favorite_border_24);
        }
        madapter.notifyItemChanged(position);
    }
    public void insertItem(int position){
        affirmation.add(position,new Affirmation(R.drawable.glass,"Sunglasses","#656545","wide","1500","Only 2 left.Order Now!!","1",R.drawable.ic_baseline_favorite_border_24));
        madapter.notifyItemInserted(position);
    }
    public void removeItem(int position){
        sum-=Integer.parseInt(affirmation.get(position).getprod_price())*Integer.parseInt(affirmation.get(position).getprod_quantity());
        item-=Integer.parseInt(affirmation.get(position).getprod_quantity());
        totalAmount.setText("₹"+Integer.toString(sum)+"/-");
        totalItem.setText("Total Amount("+Integer.toString(item)+" items ):");

        affirmation.remove(position);
        madapter.notifyItemRemoved(position);
        if(affirmation.size()==0){
            setContentView(view2);
            backimg=(ImageView)findViewById(R.id.img_back_cart);
            backimg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(cartactivity.this,MainActivity.class));
                }
            });
            continueshopping=(Button)findViewById(R.id.continueshopping_button);
            continueshopping.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(cartactivity.this,MainActivity.class));
                }
            });
        }
    }
    public void changeItem(int position,String text){
        affirmation.get(position).changeText1("Clicked");
        madapter.notifyItemChanged(position);
    }
    public void increaseItem(int position){
        sum+=Integer.parseInt(affirmation.get(position).getprod_price());
        item+=1;
        totalAmount.setText("₹"+Integer.toString(sum)+"/-");
        totalItem.setText("Total Amount("+Integer.toString(item)+" items ):");


        String text= Integer.toString(Integer.parseInt(affirmation.get(position).getprod_quantity())+1);
        affirmation.get(position).changeQuantity(text);
        madapter.notifyItemChanged(position);
    }
    public void decreaseItem(int position){
        if(Integer.parseInt(affirmation.get(position).getprod_quantity())-1>0){
            sum-=Integer.parseInt(affirmation.get(position).getprod_price());
            item-=1;
            totalAmount.setText("₹"+Integer.toString(sum)+"/-");
            totalItem.setText("Total Amount("+Integer.toString(item)+" items ):");


            String text= Integer.toString(Integer.parseInt(affirmation.get(position).getprod_quantity())-1);
            affirmation.get(position).changeQuantity(text);
            madapter.notifyItemChanged(position);
        }

    }

    private void createAffirmation() {
        affirmation=new ArrayList<>();
        affirmation.add(new Affirmation(R.drawable.glass,"Sunglasses","#656545","wide","1500","Only 2 left.Order Now!!","1",R.drawable.ic_baseline_favorite_border_24));
        affirmation.add(new Affirmation(R.drawable.glass,"Sunglasses","#656545","wide","1500","Only 2 left.Order Now!!","1",R.drawable.ic_baseline_favorite_border_24));
        affirmation.add(new Affirmation(R.drawable.glass,"Sunglasses","#656545","wide","1500","Only 2 left.Order Now!!","1",R.drawable.ic_baseline_favorite_border_24));
        affirmation.add(new Affirmation(R.drawable.glass,"Sunglasses","#656545","wide","1500","Only 2 left.Order Now!!","1",R.drawable.ic_baseline_favorite_border_24));
        affirmation.add(new Affirmation(R.drawable.glass,"Sunglasses","#656545","wide","1500","Only 2 left.Order Now!!","1",R.drawable.ic_baseline_favorite_border_24));
        affirmation.add(new Affirmation(R.drawable.glass,"Sunglasses","#656545","wide","1500","Only 2 left.Order Now!!","1",R.drawable.ic_baseline_favorite_border_24));
        affirmation.add(new Affirmation(R.drawable.glass,"Sunglasses","#656545","wide","1500","Only 2 left.Order Now!!","1",R.drawable.ic_baseline_favorite_24));

        for(int i=0;i<affirmation.size();i++){
            sum+=Integer.parseInt(affirmation.get(i).getprod_price())*Integer.parseInt(affirmation.get(i).getprod_quantity());
            item+=Integer.parseInt(affirmation.get(i).getprod_quantity());

        }

        totalAmount.setText("₹"+Integer.toString(sum)+"/-");
        totalItem.setText("Total Amount("+Integer.toString(item)+" items ):");


    }

    private void buildRecyclerView() {
        mrecyclerView=findViewById(R.id.recycler_cart);
        mrecyclerView.setHasFixedSize(true);
        mlayoutManager=new LinearLayoutManager(this);
        madapter=new RecyclerViewAdapter(affirmation);
        mrecyclerView.setLayoutManager(mlayoutManager);
        mrecyclerView.setAdapter(madapter);
        madapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                changeItem(position,"clicked");
            }

            @Override
            public void OnDeleteClick(int position) {
                removeItem(position);
            }

            @Override
            public void OnIncreaseClick(int position) {
                increaseItem(position);
            }

            @Override
            public void OnDecreaseClick(int position) {
                decreaseItem(position);
            }

            @Override
            public void OnWishClick(int position) {
                changeheartimg(position);
            }
        });
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater=getMenuInflater();
//        menuInflater.inflate(R.menu.main2,menu);
//        return true;
//    }
//
//
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id= item.getItemId();
//        if(id == R.id.action_search){
//            Toast.makeText(this,"selected",Toast.LENGTH_SHORT).show();
//            return true;
//        }
//        else if(id == R.id.action_notification){
//            Toast.makeText(this,"selected",Toast.LENGTH_SHORT).show();
//            return true;
//
//        }
//        else if(id == R.id.action_cart){
//            Toast.makeText(this,"selected",Toast.LENGTH_SHORT).show();
//
//
//            return true;
//
//        }
//        else
//            return super.onOptionsItemSelected(item);
//    }

}