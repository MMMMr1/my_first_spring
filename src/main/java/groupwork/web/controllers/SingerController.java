package groupwork.web.controllers;


import groupwork.core.dto.SingerDTO;
import groupwork.core.dto.SingerModelDTO;
import groupwork.service.api.ISingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/singer")
public class SingerController {

    private ISingerService singerService;
//     @Qualifier - можем указать какой конкретный бин брать для конструктора
//     если у нас несколько бинов

     public SingerController(ISingerService singerService) {
        this.singerService = singerService;
    }

    @RequestMapping(method = RequestMethod.GET)//    @AliasFor
    public List<SingerModelDTO> getList(){
        return singerService.get();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public SingerModelDTO card(@PathVariable("id") Long id){
        return null;
    }
//    @RequestMapping(path = "/{id}/version/{version}", method = RequestMethod.PUT)
//    public void doPut(@PathVariable("id") Long singerID,
////                         @PathVariable("version") Long version,
//                         @RequestBody SingerDTO singerDTO) {
    @RequestMapping(path = "/{id}/version/{version}", method = RequestMethod.PUT)
    public void doPut(@PathVariable("id") Long singerID,
                         @PathVariable("version") Long version,
                         @RequestBody SingerDTO singerDTO) {
// оптимистические блокировки
            singerService.update(singerID, singerDTO);

    }
//
    @RequestMapping(method = RequestMethod.POST)
    public void doPost(@RequestBody SingerDTO singer) {
            singerService.insert(singer);

    }

     @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void doDelete(@PathVariable("id") Long id) {

         singerService.delete(id);
     }
}