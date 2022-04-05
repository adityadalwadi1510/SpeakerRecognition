package com.example.speakerrecognition;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    Context context;
    ArrayList<String> user;
    List<String> list;
    Activity activity;

    public Adapter(Context context, ArrayList<String> user,Activity activity) {
        this.context = context;
        this.user = user;
        list=new ArrayList<>();
        list.add("At twilight on the twelfth day we'll have Chablis.");
        list.add("Catastrophic economic cutbacks neglect the poor.");
        list.add("Ambidextrous pickpockets accomplish more.");
        list.add("Her classical performance gained critical acclaim.");
        list.add("Even a simple vocabulary contains symbols.");
        list.add("The eastern coast is a place for pure pleasure and excitement.");
        list.add("Kindergarten children decorate their classrooms for all holidays.");
        list.add("Special task forces rescue hostages from kidnappers.");
        list.add("Call an ambulance for medical assistance. ");
        list.add("He stole a dime from a beggar.");
        this.activity=activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_list,
                parent,
                false);
        return new Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Dialog dialog=new Dialog(activity);



        holder.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=holder.spinner.getSelectedItem().toString();

                LayoutInflater inflater = activity.getLayoutInflater();
                dialog.setContentView(inflater.inflate(R.layout.dailog_interface, null));
                
                dialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return user.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        Button btnStart;
        Spinner spinner;
        String[] inputSentences;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            spinner = itemView.findViewById(R.id.spmSmaple);
            btnStart = itemView.findViewById(R.id.start_btn);
            inputSentences = new String[]{"1","2","3","4","5","6","7","8","9","10"};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, inputSentences);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);

        }


    }
}
