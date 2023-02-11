package groupwork.web.controllers;

import groupwork.core.dto.GenreCardModelDTO;
import groupwork.core.dto.GenreDTO;
import groupwork.core.dto.GenreModelDTO;
import groupwork.service.api.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
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
        //оптимистические блокировки
//поменять genreDto на объект только с именем

      genreService.update(id,version,genreDTO);
    }

    @RequestMapping(method = RequestMethod.POST)
    protected void doPost(@RequestBody GenreDTO genreDTO) {
        //worked
        genreService.insert(genreDTO);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    protected void doDelete(@PathVariable("id") Long id) {
        //worked
        genreService.delete(id);
    }
}
