package com.project.homeLoan.generator;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class AccountNumberGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		Date date= new Date();
		SimpleDateFormat ft = new SimpleDateFormat("MMhhmmss");
		String strDate = ft.format(date);
		return Long.parseLong(strDate);
	}
}
