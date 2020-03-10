package it.spootifyrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.spootifyrest.model.Album;
import it.spootifyrest.repository.AlbumRepository;

@Service
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	private AlbumRepository albumRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Album> listAll() {
		return (List<Album>) albumRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Album caricaSingolo(Long id) {
		return albumRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void aggiorna(Album o) {
		albumRepository.save(o);
	}

	@Override
	@Transactional
	public void inserisciNuovo(Album o) {
		albumRepository.save(o);
	}

	@Override
	@Transactional
	public void rimuovi(Album o) {
		albumRepository.delete(o);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Album> findByExample(Album example) {
		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING);
		return (List<Album>) albumRepository.findAll(Example.of(example, matcher));
	}

}
