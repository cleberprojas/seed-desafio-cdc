package com.desafio.casadocodigo.autor;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface AutorRepository extends JpaRepository<Autor, Long> {

	public Optional<Autor> findByEmail(String email);
}