package br.com.alura.screenmatch.domain.movie;

public record MovieUpdateData(Long id, String name, Integer duration, Integer year, String genre) {
}
