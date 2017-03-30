package pSystem.business.command;

import pSystem.util.BusinessException;

public interface Command<T> {

	T execute() throws BusinessException;

}