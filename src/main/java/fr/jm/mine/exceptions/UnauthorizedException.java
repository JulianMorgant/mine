package fr.jm.mine.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Julian MORGANT
 * @contact julian.morgant@gmail.com
 * <p>
 * Created 22/08/2019
 */

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RuntimeException {

  public UnauthorizedException() {
    super();
  }

  public UnauthorizedException(String message) {
    super(message);
  }

}
