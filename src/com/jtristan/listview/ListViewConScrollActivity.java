package com.jtristan.listview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;

public class ListViewConScrollActivity extends Activity{

	
	String[] paisesOrdenados = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.listview_con_scroll_layout);
				
		ListView lvConScroll = (ListView)this.findViewById(R.id.lvConScroll);
		
		paisesOrdenados = new String[]{
				  "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra",
				    "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina",
				    "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan",
				    "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium",
				    "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia",
				    "Bosnia and Herzegovina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory",
				    "British Virgin Islands", "Brunei", "Bulgaria", "Burkina Faso", "Burundi",
				    "Cote d'Ivoire", "Cambodia", "Cameroon", "Canada", "Cape Verde",
				    "Cayman Islands", "Central African Republic", "Chad", "Chile", "China",
				    "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo",
				    "Cook Islands", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic",
				    "Democratic Republic of the Congo", "Denmark", "Djibouti", "Dominica", "Dominican Republic",
				    "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea",
				    "Estonia", "Ethiopia", "Faeroe Islands", "Falkland Islands", "Fiji", "Finland",
				    "Former Yugoslav Republic of Macedonia", "France", "French Guiana", "French Polynesia",
				    "French Southern Territories", "Gabon", "Georgia", "Germany", "Ghana", "Gibraltar",
				    "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau",
				    "Guyana", "Haiti", "Heard Island and McDonald Islands", "Honduras", "Hong Kong", "Hungary",
				    "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica",
				    "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kuwait", "Kyrgyzstan", "Laos",
				    "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg",
				    "Macau", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands",
				    "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia", "Moldova",
				    "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia",
				    "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand",
				    "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "North Korea", "Northern Marianas",
				    "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru",
				    "Philippines", "Pitcairn Islands", "Poland", "Portugal", "Puerto Rico", "Qatar",
				    "Reunion", "Romania", "Russia", "Rwanda", "Sqo Tome and Principe", "Saint Helena",
				    "Saint Kitts and Nevis", "Saint Lucia", "Saint Pierre and Miquelon",
				    "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Saudi Arabia", "Senegal",
				    "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands",
				    "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "South Korea",
				    "Spain", "Sri Lanka", "Sudan", "Suriname", "Svalbard and Jan Mayen", "Swaziland", "Sweden",
				    "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "The Bahamas",
				    "The Gambia", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey",
				    "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Virgin Islands", "Uganda",
				    "Ukraine", "United Arab Emirates", "United Kingdom",
				    "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan",
				    "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Wallis and Futuna", "Western Sahara",
				    "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"
		};
		
								
		PaisesAdapter adapter = new PaisesAdapter(this);
						
		lvConScroll.setAdapter(adapter);
	}
	
	class PaisesAdapter extends ArrayAdapter<String> implements SectionIndexer{				
		
		Activity context = null;
		HashMap<String,Integer> indexadores;
		String[] secciones;
		
		public PaisesAdapter(Activity context){			
			super(context, android.R.layout.simple_list_item_1, paisesOrdenados);
			this.context = context;
			
			indexadores = new HashMap<String, Integer>();
			int tamaño = paisesOrdenados.length;
			
			String pais=null;
			for (int i=0;i<tamaño;i++){
				pais = paisesOrdenados[i];
				//Obtengo la primera letra del país
				String ch = pais.substring(0,1);
				//Convierto a mayúsculas.
				ch = ch.toUpperCase();
				//El hashmap me evita tener valores duplicados
				indexadores.put(ch, i);
			}
			
			Set<String> seccionParaLetras = indexadores.keySet();

			ArrayList<String> listSecciones = new  ArrayList<String>(seccionParaLetras);
			
			Collections.sort(listSecciones);
			
			secciones = new String[listSecciones.size()];
			
			listSecciones.toArray(secciones);
			
			
		}

		@Override
		public int getPositionForSection(int section) {
			return indexadores.get(secciones[section]);
		}

		@Override
		public int getSectionForPosition(int position) {			
			return 1;
		}

		@Override
		public Object[] getSections() {			
			return secciones;
		}
		
		
	
		
		
		
	}
	
	

}
