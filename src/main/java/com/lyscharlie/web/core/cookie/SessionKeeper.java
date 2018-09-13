package com.lyscharlie.web.core.cookie;

public interface SessionKeeper {

	interface COOKIE {

		String USER_ID = "cookie1";

		String USER_NAME = "cookie2";

		String TOKEN_KEY = "_tk_";

	}

	interface SESSION {

		String USER_INFO = "userInfo";

	}

}
