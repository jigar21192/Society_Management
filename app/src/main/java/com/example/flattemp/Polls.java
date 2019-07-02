package com.example.flattemp;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.flattemp.Adaptor.ReciptAdapter;
import com.example.flattemp.Model.Recipt;
import com.example.flattemp.Model.UrlsList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class  Polls extends AppCompatActivity {


Button pre,next;
    ViewPager mViewPager;
    private int currentPage = 0;
    String question,ans1,ans2,ans3,ans4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polls);



        pre=findViewById(R.id.pre);
        next=findViewById(R.id.next);

        getdata();

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mViewPager.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;
            }
        });


        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                pre.setVisibility(View.VISIBLE);
                if(currentPage==mViewPager.getAdapter().getCount()-1){

                    next.setVisibility(View.GONE);
                }
                currentPage++;
              //  que++;
              //  available_q.setText(String.valueOf(que));

                mViewPager.setCurrentItem(getItem(+1));

              /*  currentPage++;
                que++;
                available_q.setText(String.valueOf(que));
                mViewPager.setCurrentItem(getItem(+1)); //getItem(-1) for previous*/
            }
        });

        pre.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                next.setVisibility(View.VISIBLE);
                if(currentPage==1){

                    pre.setVisibility(View.GONE);
                }
                currentPage--;
           //     que--;
             //   available_q.setText(String.valueOf(que));

                mViewPager.setCurrentItem(getItem(-1));

                /*currentPage--;
                que--;
                available_q.setText(String.valueOf(que));
                mViewPager.setCurrentItem(getItem(-1)); //getItem(-1) for previous*/
            }
        });

    }

    private int getItem(int i) {



        return mViewPager.getCurrentItem() + i;
    }

    private void getdata(){
        StringRequest request = new StringRequest(Request.Method.POST, "", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray array=new JSONArray(response);

                    for (int i=0;i<array.length();i++){
                        JSONObject object=array.getJSONObject(i);
/*
                        question=object.getString("question");
                        answer=object.getString("answer");
                        ans1=object.getString("ans1");
                        ans2=object.getString("ans2");
                        ans3=object.getString("ans3");
                        ans4=object.getString("ans4");

                        Model model=new Model();
                        model.setQuestion(question);
                        model.setAns(answer);
                        model.setAns1(ans1);
                        model.setAns2(ans2);
                        model.setAns3(ans3);
                        model.setAns4(ans4);

                        list.add(model);*/

                        // Base_Adapter1 base_adapter=new Base_Adapter1(Final_quiz.this,list);
                        // listView.setAdapter(base_adapter);


                    }
/*

                    adapterView = new ImageAdapter(Final_quiz.this,list);

                    mViewPager.setAdapter(adapterView);

                    que_total=String.valueOf(mViewPager.getAdapter().getCount());
                    total_que.setText(que_total);


                    Toast.makeText(Final_quiz.this, String.valueOf(adapterView.sc), Toast.LENGTH_SHORT).show();
                    //    Toast.makeText(Final_quiz.this, String.valueOf(mViewPager.getAdapter().getCount()-1), Toast.LENGTH_SHORT).show();


*/

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
              //  pd.dismiss();
              //  Toast.makeText(Final_quiz.this, error.toString(), Toast.LENGTH_SHORT).show();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>param=new HashMap<>();
              //  param.put("name",sub);


                return param;
            }
        };

        RequestQueue queue= Volley.newRequestQueue(Polls.this);
        queue.add(request);
    }
}
