package br.usjt.rest_json_city.Model.Resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.rest_json_city.Model.Cidade;
import br.usjt.rest_json_city.Model.Repository.CidadeRepository;

@RestController
@RequestMapping("/cidades")
public class CidadeResources {
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@GetMapping()
	public List<Cidade> getAll(@RequestParam("nome") Optional<String> name,
			@RequestParam("lat") Optional<String> lat,
			@RequestParam("longi") Optional<String> longi) {
		if (name.isPresent()) {
			return cidadeRepository.findByNameStartingWith(name.get());
		}
		if(lat.isPresent() && longi.isPresent()) {
			return cidadeRepository.findByLatitudeAndLongitude(lat.get(), longi.get());
		}
		
		return cidadeRepository.findAll();
	}
}