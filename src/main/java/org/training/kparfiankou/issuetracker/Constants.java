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
	 * constant key of error message.
	 */
	public static final String KEY_ERROR_MESAGE = "errorMessage";

	/**
	 * constant key of summary or issue.
	 */
	public static final String KEY_SUMMARY = "summary";

	/**
	 * constants key of description.
	 */
	public static final String KEY_DESCRIPTION = "description";

	/**
	 * constants key of status.
	 */
	public static final String KEY_STATUS = "status";

	/**
	 * constants key of type.
	 */
	public static final String KEY_TYPE = "type";

	/**
	 * constants key of priority.
	 */
	public static final String KEY_PRIORITY = "priority";

	/**
	 * constants key of project.
	 */
	public static final String KEY_PROJECT = "project";

	/**
	 * constants key of build.
	 */
	public static final String KEY_BUILD = "build";

	/**
	 * constants key of assignee.
	 */
	public static final String KEY_ASSIGNEE = "assignee";

	/**
	 * constant key of issue id.
	 */
	public static final String KEY_ISSUE_ID = "issueId";

	/**
	 * constant key of issue.
	 */
	public static final String KEY_ISSUE = "issue";

	/**
	 * constant key of issue.
	 */
	public static final String KEY_RESOLUTION = "resolution";

	/**
	 * constants key of statuses.
	 */
	public static final String STATUSES = "statuses";
	/**
	 * constants key of types.
	 */
	public static final String TYPES = "types";
	/**
	 * constants key of prioritys.
	 */
	public static final String PRIORITYS = "prioritys";

	/**
	 * constants key of projects.
	 */
	public static final String PROJECTS = "projects";

	/**
	 * constants key of projects.
	 */
	public static final String RESOLUTIONS = "resolutions";

	/**
	 * constants key of users.
	 */
	public static final String USERS = "users";

	/**
	 * constant link to the controller LoginController.
	 */
	public static final String LOGIN_CONTROLLER = "/LoginController";

	/**
	 * constant link to the controller LogoutController.
	 */
	public static final String LOGOUT_CONTROLLER = "/LogoutController";

	/**
	 * constant link to the controller MainController.
	 */
	public static final String MAIN_CONTROLLER = "/MainController";

	/**
	 * constant link to the controller SubmitIssueController.
	 */
	public static final String SUBMIT_ISSUE_CONTROLLER = "/SubmitInsertController";

	/**
	 * constant link to the controller SubmitCreateController.
	 */
	public static final String SUBMIT_CREATE_CONTROLLER = "/SubmitCreateController";

	/**
	 * constant link to the controller CreateUpdateIssueController.
	 */
	public static final String CREATE_UPDATE_ISSUE_CONTROLLER = "/CreateUpdateIssueController";

	/**
	 * constant link to the controller InsertUpdateIssueController.
	 */
	public static final String INSERT_UPDATE_ISSUE_CONTROLLER = "/InsertUpdateIssueController";

	/**
	 * constant link to the administration page.
	 */
	public static final String CREATE_ADMINISTRATION_PAGE_CONTROLLER = "/CreateAdministrationPageController";

	/**
	 * constant link to the search page.
	 */
	public static final String CREATE_SEARCH_PAGE_CONTROLLER = "/CreateSearchPageController";

	/**
	 * constant link to the profile page.
	 */
	public static final String CREATE_PROFILE_PAGE_CONTROLLER = "/CreateProfilePageController";

	/**
	 * constant link to the main page.
	 */
	public static final String MAIN_PAGE = "/main.jsp";

	/**
	 * constant link to the header page.
	 */
	public static final String HEADER_PAGE = "/header.jsp";

	/**
	 * constant link to the administration page.
	 */
	public static final String ADMINISTRATION_PAGE = "/administration.jsp";

	/**
	 * constant link to the search page.
	 */
	public static final String SEARCH_PAGE = "/search.jsp";

	/**
	 * constant link to the profile page.
	 */
	public static final String PROFILE_PAGE = "/profile.jsp";

	/**
	 * constant link to the submit issue page.
	 */
	public static final String SUBMIT_ISSUE_PAGE = "/submit_issue.jsp";

	/**
	 * constant link to the update page.
	 */
	public static final String UPDATE_ISSUE_PAGE = "/update_issue.jsp";

	/**
	 * constant date pattern.
	 */
	public static final String DATE_PATTERN = "dd.MM.yyyy";

	/**
	 * constant MDC key for log.
	 */
	public static final String KEY_SETVER_CONTEXT = "server.context";

	private Constants() {
		 // Prevent instantiation
	}
}