package groupwork.web.controllers;

import groupwork.core.dto.Genre.GenreCardModelDTO;
import groupwork.core.dto.Genre.GenreDTO;
import groupwork.core.dto.Genre.GenreModelDTO;
import groupwork.service.api.IGenreService;
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
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public GenreCardModelDTO card(@PathVariable("id") Long id){
        return genreService.get(id);
    }
    @RequestMapping(path = "/{id}/version/{version}", method = RequestMethod.PUT)
    protected void doPut(@PathVariable("id") Long id,
                         @PathVariable("version") Long version,
                         @RequestBody GenreDTO genreDTO) {
      genreService.update(id,version,genreDTO);
    }
    @RequestMapping(method = RequestMethod.POST)
    protected void doPost(@RequestBody GenreDTO genreDTO) {
        genreService.insert(genreDTO);
    }
    @RequestMapping(path = "/{id}/version/{version}", method = RequestMethod.DELETE)
    protected void doDelete(@PathVariable("id") Long id,
                            @PathVariable("version") Long version) {
        genreService.delete(id,version);
    }
}
