package groupwork.web.controllers;

import groupwork.core.dto.genre.GenreCardModelDTO;
import groupwork.core.dto.genre.GenreDTO;
import groupwork.core.dto.genre.GenreModelDTO;
import groupwork.service.api.IGenreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/genre")
public class GenreController {
    private IGenreService genreService;
    public GenreController(IGenreService genreService) {
        this.genreService = genreService;
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<GenreModelDTO> getList(){
            return genreService.get();
    }
//    @JsonView(View.UI.class)
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public  ResponseEntity<  GenreCardModelDTO > card(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(genreService.get(id));
    }
    @RequestMapping(path = "/{id}/version/{version}", method = RequestMethod.PUT)
    protected void doPut(@PathVariable("id") Long id,
                         @PathVariable("version") Long version,
                         @RequestBody GenreDTO genreDTO) {
      genreService.update(id,version,genreDTO);
    }
    @RequestMapping(method = RequestMethod.POST)
    protected ResponseEntity<?> doPost(@RequestBody GenreDTO genreDTO) {
        genreService.insert(genreDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @RequestMapping(path = "/{id}/version/{version}", method = RequestMethod.DELETE)
    protected void doDelete(@PathVariable("id") Long id,
                            @PathVariable("version") Long version) {
        genreService.delete(id,version);
    }
}
