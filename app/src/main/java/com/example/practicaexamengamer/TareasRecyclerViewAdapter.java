package com.example.practicaexamengamer;



import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TareasRecyclerViewAdapter extends
        RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<String> items;
    Typeface fontBold;
    Context mContext;
    private final int ITEM = 0, TITLE = 1;

    public TareasRecyclerViewAdapter(Context context, ArrayList<String> items) {
        this.mContext = context;
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TITLE;
        } else {
            return ITEM;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        switch (viewType) {
            case ITEM:
                View v1 = inflater.inflate(R.layout.recycler_item, viewGroup, false);
                viewHolder = new ViewHolderItem(v1);
                break;
            case TITLE:
                View v2 = inflater.inflate(R.layout.recycler_title, viewGroup, false);
                viewHolder = new ViewHolderTitulo(v2);
                break;
            default:
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case ITEM:
                ViewHolderItem vh1 = (ViewHolderItem) viewHolder;
                configureViewHolderTitulo(vh1, i);
                break;
            case TITLE:
                ViewHolderTitulo vh2 = (ViewHolderTitulo) viewHolder;
                configureViewHolderItem(vh2, i);
                break;
        }
    }

    private void configureViewHolderTitulo(ViewHolderItem vh1, int position) {
        String task = items.get(position);
        if (task != null) {
            switch (task){
                case "Juego 1":
                    vh1.getTaskName().setText("Skyrim");
                    vh1.getTextStatus().setText(task);
                    vh1.ImageViewGamer.setImageResource(R.drawable.juego1);
                break;
                case "Juego 2":
                    vh1.getTaskName().setText("Assassin's Creed");
                    vh1.getTextStatus().setText(task);
                    vh1.ImageViewGamer.setImageResource(R.drawable.juego2);
                    break;
                case "Juego 3":
                    vh1.getTaskName().setText("Just Cause 1");
                    vh1.getTextStatus().setText(task);
                    vh1.ImageViewGamer.setImageResource(R.drawable.juego3);
                    break;
                case "Juego 4":
                    vh1.getTaskName().setText("The Witcher 3");
                    vh1.getTextStatus().setText(task);
                    vh1.ImageViewGamer.setImageResource(R.drawable.juego4);

                    break;
                case "Juego 5":
                    vh1.getTaskName().setText("Metal Gear Solid V");
                    vh1.getTextStatus().setText(task);
                    vh1.ImageViewGamer.setImageResource(R.drawable.juego5);

                    break;
                case "Juego 6":
                    vh1.getTaskName().setText("Sid Meier's Civilization V");
                    vh1.getTextStatus().setText(task);
                    vh1.ImageViewGamer.setImageResource(R.drawable.juego6);

                    break;
                case "Juego 7":
                    vh1.getTaskName().setText("Middle-earth: Shadow of Mordor");
                    vh1.getTextStatus().setText(task);
                    vh1.ImageViewGamer.setImageResource(R.drawable.juego7);

                    break;
                case "Juego 8":
                    vh1.getTaskName().setText("Dishonored");
                    vh1.getTextStatus().setText(task);
                   // vh1.ImageViewGamer.setImageResource(R.drawable.juego8);
                    break;
                case "Juego 9":
                    vh1.getTaskName().setText("Fallout New Vegas");
                    vh1.getTextStatus().setText(task);
                    vh1.ImageViewGamer.setImageResource(R.drawable.juego9);

                    break;
                case "Juego 10":
                    vh1.getTaskName().setText("Mass Effect");
                    vh1.getTextStatus().setText(task);
                    vh1.ImageViewGamer.setImageResource(R.drawable.juego10);
                    break;

            }
        }
    }

    private void configureViewHolderItem(ViewHolderTitulo vh2, int position) {
        String separatorString = items.get(position);
        vh2.getTextViewSeparator().setText(separatorString);
        vh2.getTextViewSeparator().setTypeface(fontBold);
    }

    public class ViewHolderItem extends RecyclerView.ViewHolder implements
            View.OnClickListener {
        private TextView TextViewNombreTarea, TextViewEstadoTarea;
        private ImageView ImageViewGamer;

        public ViewHolderItem(View v) {
            super(v);
            TextViewNombreTarea = (TextView) v.findViewById(R.id.textoR);
            TextViewEstadoTarea = (TextView) v.findViewById(R.id.textoR2);
            ImageViewGamer=v.findViewById(R.id.imagen1);
            v.setOnClickListener(this);
        }

        public TextView getTaskName() {
            return TextViewNombreTarea;
        }

        public void setTaskName(TextView label1) {
            this.TextViewNombreTarea = label1;
        }

        public TextView getTextStatus() {
            return TextViewEstadoTarea;
        }

        public void setTextStatus(TextView textView) {
            this.TextViewEstadoTarea = textView;
        }

        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
        }
    }

    public class ViewHolderTitulo extends RecyclerView.ViewHolder {
        private TextView TextViewTitulo;
        private ImageView getImageViewNombre;
        public ViewHolderTitulo(View v) {
            super(v);
            TextViewTitulo = v.findViewById(R.id.recycle2);
        }

        public TextView getTextViewSeparator() {
            return TextViewTitulo;
        }

        public void setTextViewSeparator(TextView separator) {
            this.TextViewTitulo = separator;
        }
    }
}


