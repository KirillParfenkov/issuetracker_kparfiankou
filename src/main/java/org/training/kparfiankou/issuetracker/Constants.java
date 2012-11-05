package org.training.kparfiankou.issuetracker;

/**
 *
 * @author parf
 *
 */
public final class Constants {

	/**
	 * constant key of user.
	 */
	public static final String KEY_USER = "user";

	/**
	 * constant key of email.
	 */
	public static final String KEY_INPUT_EMAIL = "emal";

	/**
	 * constant key of password.
	 */
	public static final String KEY_INPUT_PASSWORD = "password";

	/**
	 * constant key of error mesage.
	 */
	public static final String KEY_ERROR_MESAGE = "errorMesage";

	/**
	 * constant link to the controller LoginController.
	 */
	public static final String LOGIN_CONTROLLER = "LoginController";

	/**
	 * constant link to the controller LogoutController.
	 */
	public static final String LOGOUT_CONTROLLER = "LogoutController";

	/**
	 * constant link to the controller MainController.
	 */
	public static final String MAIN_CONTROLLER = "/";

	/**
	 * constant link to the main page.
	 */
	public static final String MAIN_PAGE = "main.jsp";

	/**
	 * constant link to the main page.
	 */
	public static final String HEADER_PAGE = "header.jsp";

	/**
	 * constant date pattern.
	 */
	public static final String  DATE_PATTERN = "dd.MM.yyyy";

	/**
	 * constant MDC key for log.
	 */
	public static final String KEY_SETVER_CONTEXT = "server.context";

	private Constants() {
		 // Prevent instantiation
	}
}