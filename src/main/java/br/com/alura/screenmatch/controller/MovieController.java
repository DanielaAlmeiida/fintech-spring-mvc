package br.com.alura.screenmatch.controller;

import br.com.alura.screenmatch.domain.movie.Movie;
import br.com.alura.screenmatch.domain.movie.MovieUpdateData;
import br.com.alura.screenmatch.domain.movie.MovieRegisterData;
import br.com.alura.screenmatch.domain.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired //Instanciação do repository
    private MovieRepository repository;

    @GetMapping("/form")
    public String loadFormPage(Long id, Model model) {
        if(id != null) {
            var movie = repository.getReferenceById(id);
            model.addAttribute("movie", movie);
        }
        return "movies/form";
    }

    @GetMapping
    public String loadListPage(Model model) {
        model.addAttribute("list", repository.findAll());
        return "movies/list";
    }

    @PostMapping
    @Transactional
    public String registerMovie(MovieRegisterData data) {
        var movie = new Movie(data);
        repository.save(movie); //Insert into table

        return "redirect:/movies";
    }

    @PutMapping
    @Transactional //Transaction with database
    public String updateMovie(MovieUpdateData data) {
        var movie = repository.getReferenceById(data.id());
        movie.updateMovie(data);

        return "redirect:/movies";
    }

    @DeleteMapping
    @Transactional
    public String deleteMovie(Long id) {
        repository.deleteById(id);

        return "redirect:/movies";
    }
}
