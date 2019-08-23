package fr.jm.mine.controllers.impl;

import fr.jm.mine.controllers.UtilsController;
import fr.jm.mine.enums.SearchModeEnum;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Julian MORGANT
 * @contact julian.morgant@gmail.com
 * <p>
 * Created 23/08/2019
 */

@RestController
public class UtilsControllerImpl implements UtilsController {
    @Override
    public Set<SearchModeEnum> getSearchModeEnum() {
        Set getEnum = new HashSet<>();
        Collections.addAll(getEnum,SearchModeEnum.values());
        return getEnum;
    }
}
