package model.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.IAccountManagerVerdi;

@RestController
public class LoginController {
	
	
	@Autowired
	private IAccountManagerVerdi accountManager;
	
	
	
}
