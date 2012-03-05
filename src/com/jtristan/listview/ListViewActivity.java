package com.jtristan.listview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jtristan.listview.usuario.Usuario;

public class ListViewActivity extends Activity implements View.OnClickListener{
	
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        Button btOptimizacion = (Button)this.findViewById(R.id.btOptimizacionListView);
        Button btOptimizacionConCheck = (Button)this.findViewById(R.id.btOptimizacionListViewConCheck);
        Button btListViewConScroll = (Button)this.findViewById(R.id.btListViewConScroll);
        Button btSimpleCursorAdapter = (Button)this.findViewById(R.id.btSimpleCursorAdapter);
        Button btListViewPersonalizado = (Button)this.findViewById(R.id.btListViewPersonalizado);
        
        btOptimizacionConCheck.setOnClickListener(this);
        btOptimizacion.setOnClickListener(this);
        btListViewConScroll.setOnClickListener(this);               
        btSimpleCursorAdapter.setOnClickListener(this);
        btListViewPersonalizado.setOnClickListener(this);
        
    }

	@Override
	public void onClick(View view) {
		Intent intent = null;
		switch (view.getId()){
			case R.id.btOptimizacionListView:
				intent = new Intent(this,OptimizacionListViewActivity.class);
				break;
			case R.id.btOptimizacionListViewConCheck:
				break;
			case R.id.btListViewConScroll:
				intent = new Intent(this,ListViewConScrollActivity.class);
				break;		
			case R.id.btSimpleCursorAdapter:
				intent = new Intent(this,SimpleCursorAdapterActivity.class);
				break;	
			case R.id.btListViewPersonalizado:
				intent = new Intent(this,ListViewPersonalizadoSinOptimizarActivity.class);
				break;	
		}
		if (intent!=null)
			this.startActivity(intent);
		
	}

	    
          
}