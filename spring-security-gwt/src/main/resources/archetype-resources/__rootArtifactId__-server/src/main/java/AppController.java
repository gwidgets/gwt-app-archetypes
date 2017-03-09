package ${package};

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AppController {
	@RequestMapping("/user")
	  public ResponseEntity<String> user(@AuthenticationPrincipal User user) {
		
	    return new ResponseEntity<String>(user.getUsername(), HttpStatus.OK);
	  }
}
