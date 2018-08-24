package com.example.android.miwok;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class NumbersClickListener implements View.OnClickListener {
    Context theContext;

    @Override
    public void onClick(View view)
    {
        Toast.makeText(view.getContext(), "Open the list of numbers", Toast.LENGTH_SHORT).show();
        if(theContext != null) {
            Intent intent = new Intent(theContext, NumbersActivity.class);
            theContext.startActivity(intent);
        }
    }

    public void setContext(Context context){
        theContext = context;
    }

}
