package betting.main.webapp;

import java.security.Principal;
import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import betting.main.auth.UserDetailsServiceImpl;
import betting.main.auth.WebUtils;
import betting.main.data.AppUserDTO;
import betting.main.data.TurnierStatisitkDTO;
import betting.main.exception.DbZugriffException;
import betting.main.exception.PasswordMissmatchException;
import betting.main.exception.UserAlreadyExistsException;

@RestController("main")
public class MainController {

	private static final Logger LOGGER = Logger.getLogger(MainController.class.getName());

	@Autowired
	private UserDetailsServiceImpl userService;

	@Autowired
	private SpielerTabelleService spielerTabelleService;


	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminPage( Principal principal) {
		ModelAndView model = new ModelAndView("adminPage");
		User loginedUser = (User) ((Authentication) principal).getPrincipal();

		String userInfo = WebUtils.toString(loginedUser);
		model.addObject("userInfo", userInfo);

		return model;
	}

	@RequestMapping(value = "/hauptansicht", method = RequestMethod.GET)
	public ModelAndView hauptansicht() {
		ModelAndView model = new ModelAndView("hauptansicht");

		return model;
	}

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView loginPage() {
		return new ModelAndView("loginPage");
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public ModelAndView signUpPage() {
		ModelAndView model = new ModelAndView("signUpPage");
		model.addObject("newAppUserDTO", new AppUserDTO());
		return model;
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public ModelAndView signUpNewUser(@Valid AppUserDTO newAppUserDTO, BindingResult bindingResult) {
		ModelAndView model = new ModelAndView("signUpPage");
		if (bindingResult.hasErrors()) {
			bindingResult.rejectValue(bindingResult.getFieldError().getField(),
					bindingResult.getFieldError().getCode());
			model.addObject("registrationForm", newAppUserDTO);
			return model;
		}
		try {
			userService.registerNewUser(newAppUserDTO);
		} catch (DbZugriffException e) {
			LOGGER.severe(e.getException() + " - Message: " + e.getExceptionMessage());
			bindingResult.rejectValue("newAppUserDTO", "newAppUserDTO",
					"Bei der Neuanlage ihres Users ist etwas schiefgelaufen. Bitte Wenden Sie sich an den Admin dieser Seite!");
			model.addObject("newAppUserDTO", newAppUserDTO);
			return model;
		} catch (PasswordMissmatchException e) {
			LOGGER.severe("PasswordMissmatchException - Message: " + e.getExceptionMessage());
			bindingResult.rejectValue("confirmPassword", "newAppUserDTO.confirmPassword", e.getExceptionMessage());
			model.addObject("newAppUserDTO", newAppUserDTO);
			return model;
		} catch (UserAlreadyExistsException e) {
			LOGGER.severe("UserAlreadyExistsException - Message: " + e.getExceptionMessage());
			bindingResult.rejectValue("userName", "newAppUserDTO.userName", e.getExceptionMessage());
			model.addObject("newAppUserDTO", newAppUserDTO);
			return model;
		}
		model.setViewName("loginPage");
		return model;
	}

	@RequestMapping(value = "/logoutPage", method = RequestMethod.GET)
	public ModelAndView logoutSuccessfulPage() {
		ModelAndView model = new ModelAndView("logoutPage");
		model.addObject("title", "Logout");
		return model;
	}

	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public ModelAndView userInfo(Principal principal) {
		ModelAndView model = new ModelAndView("userInfoPage");

		// (1) (en)
		// After user login successfully.
		// (vi)
		// Sau khi user login thanh cong se co principal
		String userName = principal.getName();

		System.out.println("User Name: " + userName);

		User loginedUser = (User) ((Authentication) principal).getPrincipal();

		String userInfo = WebUtils.toString(loginedUser);
		model.addObject("userInfo", userInfo);

		return model;
	}

	
	@RequestMapping(value = "/spielerTabelle", method = RequestMethod.GET)
	public ModelAndView spielerTabelle() {
		ModelAndView model = new ModelAndView("spielerTabelle");
		List<TurnierStatisitkDTO> turnierStats = spielerTabelleService.getTurnierStatistiken();
		model.addObject("turnierStats", turnierStats);

		return model;
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accessDenied(Principal principal) {
		ModelAndView model = new ModelAndView("403Page");

		if (principal != null) {
			User loginedUser = (User) ((Authentication) principal).getPrincipal();

			String userInfo = WebUtils.toString(loginedUser);

			model.addObject("userInfo", userInfo);

			String message = "Hi " + principal.getName() //
					+ "<br> You do not have permission to access this page!";
			model.addObject("message", message);

		}

		return model;
	}

}