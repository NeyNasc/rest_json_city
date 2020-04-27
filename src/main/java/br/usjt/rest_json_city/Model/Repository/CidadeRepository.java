package br.usjt.rest_json_city.Model.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.rest_json_city.Model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	public List<Cidade> findByNameStartingWith(String nome);
	public List<Cidade> findByLatitudeAndLongitude(String lat, String longi);

}
