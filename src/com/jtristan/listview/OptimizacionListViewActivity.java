package com.jtristan.listview;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;

import com.jtristan.listview.usuario.Usuario;

public class OptimizacionListViewActivity extends ListActivity {
	
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
        
        UsuarioAdapter adapter = new UsuarioAdapter(this, usuarios);
        this.setListAdapter(adapter);
        
    }
    
    
    
}
