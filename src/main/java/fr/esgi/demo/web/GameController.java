package fr.esgi.demo.web;

import fr.esgi.demo.web.dto.GameDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static fr.esgi.demo.web.dto.GameDTO.Type.FPS;

/**
 * Created by Thibault on 19/03/15.
 */
@RestController
@RequestMapping("/game")
public class GameController {

    @RequestMapping(method = RequestMethod.GET)
    public GameDTO getGames(){
        GameDTO gameDTO = new GameDTO();
        gameDTO.setId(1L);
        gameDTO.setName("Dying Light");
        gameDTO.setType(FPS);
        return gameDTO;


    }

}
