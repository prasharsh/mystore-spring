package com.app.mystore.dao;

import com.app.mystore.dto.ResetPassword;
import com.app.mystore.dto.User;

public interface ResetPasswordDao {

	int insertToken(ResetPassword rp);



}
