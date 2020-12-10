package com.example.shade;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shade.Shade;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Shade}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyShadeRecyclerViewAdapter extends RecyclerView.Adapter<MyShadeRecyclerViewAdapter.ViewHolder> {

    private final List<Shade> mValues;
    private Context context;

    public MyShadeRecyclerViewAdapter(List<Shade> mValues, Context context) {
        this.mValues = mValues;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_shade_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mShade = mValues.get(position);
        holder.mShadeTextView.setText(holder.mShade.getName());
        holder.mShadeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
                    Intent intent = new Intent(context, InformationActivity.class);
                    intent.putExtra("shade_detail", holder.mShade.getDetail());
                    intent.putExtra("shade_color", holder.mShade.getColor());
                    context.startActivity(intent);
                }
                else{
                    TextView shadeDetailTV = ((MainActivity)context).findViewById(R.id.shade_detail_TV);
                    shadeDetailTV.setText(holder.mShade.getDetail());
                    holder.mShadeTextView.setBackgroundColor(Color.parseColor(String.valueOf(holder.mShade.getColor())));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mShadeTextView;
        public Shade mShade;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mShadeTextView = (TextView) view.findViewById(R.id.shade_nameTV);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mShadeTextView.getText() + "'";
        }
    }
}