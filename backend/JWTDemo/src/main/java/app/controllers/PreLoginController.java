package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.domain.Response;
import app.model.User;
import app.services.UserService;

@RestController
public class PreLoginController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/registration")
	public ResponseEntity<Response> registration(@RequestBody User user){
		User dbUser = userService.save(user);
		if(dbUser != null) {
			return new ResponseEntity<Response>(new Response("User is saved successfully"),HttpStatus.OK);
		}
		return null;
	}
}
