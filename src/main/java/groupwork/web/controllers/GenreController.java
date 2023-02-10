package groupwork.web.controllers;

import groupwork.core.dto.GenreDTO;
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
    public List<GenreDTO> getList(){
        return genreService.get();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public GenreDTO card(@PathVariable("id") Long id){
        return null;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    protected void doPut(@PathVariable("id") Long id,
//                         @PathVariable("version") Long version,
                         @RequestBody GenreDTO genreDTO) {
// оптимистические блокировки
//       поменять genreDto на объект только с именем
      genreService.update(id,genreDTO);
    }

    @RequestMapping(method = RequestMethod.POST)
    protected void doPost(@RequestBody GenreDTO genreDTO) {
        genreService.insert(genreDTO);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    protected void doDelete(@PathVariable("id") Long id) {
        genreService.delete(id);
    }
}
//    @Override
//    protected void doGet(HttpServletRequest req,
//                         HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset=UTF-8");
//
//        List<GenreDTO> genreEntities = genreService.get();
//
//        PrintWriter writer = resp.getWriter();
//
//        genreEntities.forEach(genreEntity -> writer.write("<p>" + genreEntity.getId() + " " + genreEntity.getName() + "</p>"));
//    }
//
//    @Override
//    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset=UTF-8");
//
//        PrintWriter writer = resp.getWriter();
//
//        Map<String, String[]> parameterMap = req.getParameterMap();
//        String[] genres = parameterMap.get(GENRE_PARAM_NAME);
//
//        try {
//            if (genres == null || genres.length > 1) {
//                throw new IllegalArgumentException("Entered one genre");
//            }
//
//            int genre = Integer.parseInt(genres[0]);
////            GenreDTO genreDTO = new GenreDTO();
////            genreDTO.setId(genre);
//            genreService.delete(genre);
//            writer.write("<p>Genre deleted successfully</p>");
//
//        } catch (RuntimeException e) {
//            if (e.getCause() != null) {
//                writer.write("<p>" + e.getMessage() + ": " + e.getCause() + "</p>");
//            } else {
//                writer.write("<p>" + e.getMessage() + "</p>");
//            }
//        }
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset=UTF-8");
//
//        PrintWriter writer = resp.getWriter();
//
//        Map<String, String[]> parameterMap = req.getParameterMap();
//        String[] genres = parameterMap.get(GENRE_PARAM_NAME);
//
//        try {
//            if (genres == null || genres.length > 1) {
//                throw new IllegalArgumentException("Enter one genre to create");
//            }
//
//            String genreName = genres[0];
//
//            genreService.insert(new GenreDTO(genreName));
//            writer.write("<p>Genre created successfully</p>");
//
//        } catch (RuntimeException e) {
//            if (e.getCause() != null) {
//                writer.write("<p>" + e.getMessage() + ": " + e.getCause() + "</p>");
//            } else {
//                writer.write("<p>" + e.getMessage() + "</p>");
//            }
//
//        }
//    }
//
//    @Override
//    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset=UTF-8");
//
//        PrintWriter writer = resp.getWriter();
//
//        Map<String, String[]> parameterMap = req.getParameterMap();
//        String[] genres = parameterMap.get(GENRE_PARAM_NAME);
//        String[] newGenres = parameterMap.get(NEW_GENRE_NAME_PARAM_NAME);
//
//        try {
//            if (genres == null || genres.length > 1 || newGenres == null || newGenres.length > 1) {
//                throw new IllegalArgumentException("Enter one genre to update");
//            }
//
//            int genreID = Integer.parseInt(genres[0]);
//            String newGenre = newGenres[0];
//
//            genreService.update(genreID, new GenreDTO(newGenre));
//            writer.write("<p>Genre updated successfully</p>");
//
//        } catch (RuntimeException e) {
//            if (e.getCause() != null) {
//                writer.write("<p>" + e.getMessage() + ": " + e.getCause() + "</p>");
//            } else {
//                writer.write("<p>" + e.getMessage() + "</p>");
//            }
//
//        }
//    }


//}
