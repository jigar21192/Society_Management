package com.example.flattemp.Adaptor;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.flattemp.Model.View_Statement_Model;
import com.example.flattemp.R;

import java.util.List;

public class View_Statement_Adapter extends RecyclerView.Adapter<View_Statement_Adapter.NoticeViewHolder> {
    private Context mContext;
    private List<View_Statement_Model> mUploads;
    private OnItemClickListener mListener;
    public View_Statement_Adapter(Context mContext, List<View_Statement_Model> mUploads) {
        this.mContext = mContext;
        this.mUploads = mUploads;
    }

    @Override
    public NoticeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.view_statement_item, parent, false);
        return new NoticeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NoticeViewHolder holder, int position) {
        final View_Statement_Model model = mUploads.get(position);


        holder.date1.setText(model.getpay_date());
        holder.credit1.setText(model.getpay_fixed());

            holder.debit1.setText(model.getpay_deposit());

            holder.balance1.setText(model.getpay_remaining());






          }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class NoticeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener{
        public TextView  date1,credit1,debit1,balance1;
        public NoticeViewHolder(View itemView) {

            super(itemView);
            date1 = itemView.findViewById(R.id.date1);
            //pay_date=itemView.findViewById(R.id.paydate);
            //  mem_id=itemView.findViewById(R.id.memberid);
            //  mem_name=itemView.findViewById(R.id.membername);
            credit1=itemView.findViewById(R.id.fixed);
            //  mem_flat_type=itemView.findViewById(R.id.flattype);
            debit1=itemView.findViewById(R.id.de);
            balance1=itemView.findViewById(R.id.remaining);
             /*pay_deposit=itemView.findViewById(R.id.deposite);
            // pay_remaining=itemView.findViewById(R.id.remaining);
             pay_month=itemView.findViewById(R.id.month);
             pay_status=itemView.findViewById(R.id.status);
*/            itemView.setOnClickListener(this);
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