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

public class ListViewPersonalizadoSinOptimizarActivity extends ListActivity {
	
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);       
        
        Usuario usuario = new Usuario();
        usuario.setNombre("usuario_1");
        usuario.setApellido("Bommm");
        usuario.setDireccion("C. los perales");
        usuarios.add(usuario);
        usuario = new Usuario();
        usuario.setNombre("usuario_2");
        usuario.setApellido("Pin");
        usuario.setDireccion("C. los manzanos");
        usuarios.add(usuario);
        usuario = new Usuario();
        usuario.setNombre("usuario_3");
        usuario.setApellido("Trun");
        usuario.setDireccion("C. los melocotones");
        usuarios.add(usuario);
        usuario = new Usuario();
        usuario.setNombre("usuario_4");
        usuario.setApellido("Pan");
        usuario.setDireccion("C. los fresones");
        usuarios.add(usuario);
        usuario = new Usuario();
        usuario.setNombre("usuario_5");
        usuario.setApellido("Brin");
        usuario.setDireccion("C. las naranjas");
        usuarios.add(usuario);
        usuario = new Usuario();
        usuario.setNombre("usuario_6");
        usuario.setApellido("Zomm");
        usuario.setDireccion("C. las mandarinas");
        usuarios.add(usuario);
        
        UsuarioAdapter adapter = new UsuarioAdapter(this);
        this.setListAdapter(adapter);
                   
    }
    
    
    
    
    
                   
    private class UsuarioAdapter extends ArrayAdapter<Usuario>{
    	
    	Activity context;    	
    			
		public UsuarioAdapter(Activity context) {
			super(context, R.layout.usuariolayout,usuarios);			
			this.context =  context;
		}		
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
						
			Usuario usuario;
			usuario = usuarios.get(position);
			View view = null;
						
			LayoutInflater inflate = context.getLayoutInflater();				
			view = inflate.inflate(R.layout.usuariolayout, null);						
			TextView tvNombre = (TextView)view.findViewById(R.id.tvNombre);				
			TextView tvApellido = (TextView)view.findViewById(R.id.tvApellido);
			TextView tvDireccion = (TextView)view.findViewById(R.id.tvDireccion);
							
			tvNombre.setText(usuario.getNombre());
			tvApellido.setText(usuario.getApellido());
			tvDireccion.setText(usuario.getDireccion());					
			
			return view;
		}
		
		
    }

}
