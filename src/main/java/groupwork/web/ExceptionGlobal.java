package groupwork.web;

import groupwork.core.dto.genre.GenreDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionGlobal {
    @ExceptionHandler(value = {NullPointerException.class, ArrayIndexOutOfBoundsException.class})
    public ResponseEntity<GenreDTO> handlerNPE( ){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GenreDTO("error"));
    }
    @ExceptionHandler
    public ResponseEntity<GenreDTO> handlerNPE(Throwable e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GenreDTO(e.getMessage()));
    }
}
