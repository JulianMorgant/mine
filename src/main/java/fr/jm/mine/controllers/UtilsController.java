package fr.jm.mine.controllers;

import fr.jm.mine.enums.SearchModeEnum;
import fr.jm.mine.resources.entities.MessageBodyResource;
import fr.jm.mine.resources.entities.MessageFullResource;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

/**
 * @author Julian MORGANT
 * @contact julian.morgant@gmail.com
 * <p>
 * Created 22/08/2019
 */

@RequestMapping("/utils")
public interface UtilsController {

    @GetMapping("/getSearchModeEnum")
    Set<SearchModeEnum> getSearchModeEnum();

}
