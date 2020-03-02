package com.emergya.rest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.emergya.bean.Features;
import com.emergya.bean.RequestFechas;
import com.emergya.bean.RequestMagnitudes;
import com.emergya.bean.Response;
import com.emergya.bean.RespuestaCliente;
import com.emergya.model.entitys.Sismo;
import com.emergya.model.service.ISismoService;
import com.google.gson.Gson;


@RestController
@RequestMapping (value="sismos")
public class ToDoList {
	
	
	@Autowired
	private ISismoService sismoService;
	
	
		@PostMapping(value = "/fechas", consumes = "application/json", produces = "application/json")
		public String buscarFechas(@RequestBody RequestFechas respfechas) {
		
			Sismo sismo = new Sismo();
			
			RestTemplate plantilla = new RestTemplate();
		    Response resultado = plantilla.getForObject("https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime="+respfechas.getStarttime()+"&endtime="+respfechas.getEndtime(), Response.class);
		    Date date = new Date();

		    RespuestaCliente cliente = new RespuestaCliente();
		    ArrayList<RespuestaCliente> listresp = new ArrayList<RespuestaCliente>();
		    
		    for(Features resp : resultado.getFeatures()){
		    	cliente = new RespuestaCliente();
		    	cliente.setPlace(resp.getProperties().getPlace());
		    	cliente.setMagnitud(resp.getProperties().getMag());
		    	date = new Date((long) (resp.getProperties().getTime()));
			    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			    cliente.setFecha(format.format(date));
			    
			    sismo = new Sismo();
			    sismo.setMagnitud(cliente.getMagnitud());
			    sismo.setFechaSismo(cliente.getFecha());
			    sismo.setPlace(cliente.getPlace());
			    sismoService.addSismo(sismo);
			    
			    listresp.add(cliente);
	 
	        }
		    
		    String gson = new Gson().toJson(listresp);
		    
		    
		    return gson;
		}
		
		@PostMapping(value = "/magnitudes", consumes = "application/json", produces = "application/json")
		public String BuscarMagnitud(@RequestBody RequestMagnitudes respmagnitud) {
		
			Sismo sismo = new Sismo();
			
			RestTemplate plantilla = new RestTemplate();
		    Response resultado = plantilla.getForObject("https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&minmagnitude="+respmagnitud.getMinMagnitude()+"&maxmagnitude="+respmagnitud.getMaxMagnitude(), Response.class);
		    Date date = new Date();
		    
		    RespuestaCliente cliente = new RespuestaCliente();
		    ArrayList<RespuestaCliente> listresp = new ArrayList<RespuestaCliente>();
		    
		    for(Features resp : resultado.getFeatures()){
		    	cliente = new RespuestaCliente();
		    	cliente.setPlace(resp.getProperties().getPlace());
		    	cliente.setMagnitud(resp.getProperties().getMag());
		    	date = new Date((long) (resp.getProperties().getTime()));
			    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			    cliente.setFecha(format.format(date));
			    
			    sismo = new Sismo();
			    sismo.setMagnitud(cliente.getMagnitud());
			    sismo.setFechaSismo(cliente.getFecha());
			    sismo.setPlace(cliente.getPlace());
			    sismoService.addSismo(sismo);
			    
			    listresp.add(cliente);
	 
	        }
		    
		    String gson = new Gson().toJson(listresp);
		    
		    
		    return gson;

		}
	
	
		@GetMapping(value="consultados")
		public List<Sismo> getSismos() {
			return sismoService.getSismo();
		}
		
		
}
