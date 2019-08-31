package com.example.flattemp.Adaptor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.flattemp.Model.UrlsList;
import com.example.flattemp.Model.View_Complain_Model;
import com.example.flattemp.Polls;
import com.example.flattemp.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class View_Complain_Adapter extends RecyclerView.Adapter<View_Complain_Adapter.ComplainViewHolder> {
    private Context mContext;
    private List<View_Complain_Model> mUploads;
    private OnItemClickListener mListener;
    public View_Complain_Adapter(Context mContext, List<View_Complain_Model> mUploads) {
        this.mContext = mContext;
        this.mUploads = mUploads;
    }

    @Override
    public ComplainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.complain_list_item, parent, false);
        return new ComplainViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ComplainViewHolder holder, int position) {
        final View_Complain_Model model = mUploads.get(position);

        holder.date.setText("Complain Date:"+model.getMem_complaint_date());
        holder.complain.setText("Complain is "+model.getMem_complaint());
        holder.admin_reply.setText("Admin Reply:"+model.getAdmin_reply());
        holder.dec.setText("Description :-"+model.getMem_complaint_desc());
      /*  holder.satisfy.setText("Satisfied"+model.getMem_user());
        holder.unsatisfy.setText("UnSatisfied"+model.getMem_user());*/
      String status=model.getStatus();
      final String c_id=model.getC_id();

      if (status.equals("1")){

          holder.unsatisfy.setVisibility(View.GONE);
      }else if (status.equals("2")){
          holder.satisfy.setVisibility(View.GONE);

      }
      holder.satisfy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest request = new StringRequest(Request.Method.POST, UrlsList.satisfy_complain,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if (response.trim().equals("success")){
                                    holder.unsatisfy.setVisibility(View.GONE);
                                }else {
                                    Toast.makeText(mContext, "Some Problem", Toast.LENGTH_SHORT).show();
                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error",">>>>>>"+error.getMessage());
                        Toast.makeText(mContext,error.toString(),Toast.LENGTH_SHORT).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params = new HashMap<>();
                        //Adding parameters to request
                        params.put("mem_user_id",c_id);
                        //returning parameter
                        return params;
                    }
                };
                RequestQueue queue = Volley.newRequestQueue(mContext);
                queue.add(request);

            }
        });



        holder.unsatisfy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringRequest request = new StringRequest(Request.Method.POST, UrlsList.unsatisfy_complain,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if (response.trim().equals("success")){
                                    holder.satisfy.setVisibility(View.GONE);
                                }else {
                                    Toast.makeText(mContext, "Some Problem", Toast.LENGTH_SHORT).show();
                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(mContext,error.toString(),Toast.LENGTH_SHORT).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params = new HashMap<>();
                        //Adding parameters to request
                        params.put("mem_user_id",c_id);
                        //returning parameter
                        return params;
                    }
                };
                RequestQueue queue = Volley.newRequestQueue(mContext);
                queue.add(request);

            }
        });

      /*  holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String img=uploadCurrent.getGallery_img();
                String  name=uploadCurrent.getGallery_img_name();
                Intent i= new Intent(mContext, Shoesingleimage.class);
                i.putExtra("img",imgurl);
                i.putExtra("name",name);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(i);
            }
        });*/
    }


    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ComplainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener{
        public TextView satisfy,unsatisfy,date,complain,admin_reply,dec;
        public ImageView vendor_img;
        public ComplainViewHolder(View itemView) {

            super(itemView);

            satisfy = itemView.findViewById(R.id.satisfy);
            dec = itemView.findViewById(R.id.dec);
            unsatisfy = itemView.findViewById(R.id.unsatisfy);
            date = itemView.findViewById(R.id.c_type);
            complain = itemView.findViewById(R.id.c_remarks);
            admin_reply = itemView.findViewById(R.id.c_reply);




            itemView.setOnClickListener(this);
            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (mListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {

                    switch (menuItem.getItemId()) {
                        case 1:
                            mListener.onWhatEverClick(position);
                            return true;
                        case 2:
                            mListener.onDeleteClick(position);
                            return true;
                    }
                }
            }
            return false;

        }


        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            contextMenu.setHeaderTitle("Select Action");
            MenuItem doWhatever = contextMenu.add(Menu.NONE, 1, 1, "Update");
            MenuItem delete = contextMenu.add(Menu.NONE, 2, 2, "Delete");

            doWhatever.setOnMenuItemClickListener(this);
            delete.setOnMenuItemClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(position);
                }
            }

        }
    }


    public interface OnItemClickListener {
        void onItemClick(int position);

        void onWhatEverClick(int position);

        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


}