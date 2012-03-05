package com.jtristan.listview;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.jtristan.listview.usuario.Usuario;

public class UsuarioAdapter extends ArrayAdapter<Usuario> {
		
    	Activity context;   
    	ArrayList<Usuario> usuarios=null;
    			
		public UsuarioAdapter(Activity context, ArrayList<Usuario> usuarios) {
			super(context, R.layout.usuariolayout,usuarios);			
			this.context =  context;
			this.usuarios = usuarios;
		}
		
		
		static class ViewHolder{
			protected TextView tvNombre;
			protected TextView tvApellido;
			protected TextView tvDireccion;
			protected CheckBox cbSeleccionado;
		}
		
	
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
						
			Usuario usuario;
			usuario = usuarios.get(position);
			View view = null;
			
			if (convertView==null){
				LayoutInflater inflate = context.getLayoutInflater();				
				view = inflate.inflate(R.layout.usuariolayout, null);			
				final ViewHolder viewHolder= new ViewHolder();
				viewHolder.tvNombre = (TextView)view.findViewById(R.id.tvNombre);				
				viewHolder.tvApellido = (TextView)view.findViewById(R.id.tvApellido);
				viewHolder.tvDireccion = (TextView)view.findViewById(R.id.tvDireccion);
				viewHolder.cbSeleccionado = (CheckBox)view.findViewById(R.id.cbSeleccionado);
				viewHolder.cbSeleccionado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
					
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						Usuario usuario = (Usuario)viewHolder.cbSeleccionado.getTag();
						usuario.setSeleccionado(isChecked);						
						
					}
				});
				
				view.setTag(viewHolder);				
				viewHolder.cbSeleccionado.setTag(usuarios.get(position));
			}else{
				view = convertView;							
				((ViewHolder) view.getTag()).cbSeleccionado.setTag(usuarios.get(position));
				
			}	
			ViewHolder viewHolder = (ViewHolder) view.getTag();
			viewHolder.tvNombre.setText(usuario.getNombre());
			viewHolder.tvApellido.setText(usuario.getApellido());
			viewHolder.tvDireccion.setText(usuario.getDireccion());
			viewHolder.cbSeleccionado.setChecked(usuario.isSeleccionado());			
			
			return view;
		}
		
		
    }


