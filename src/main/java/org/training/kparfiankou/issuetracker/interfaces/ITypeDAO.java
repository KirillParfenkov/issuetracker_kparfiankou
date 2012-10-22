package org.training.kparfiankou.issuetracker.interfaces;

import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Type;

/**
 * @author theparf
 *
 */
public interface ITypeDAO {
	/**
	 *
	 * @return List of types.
	 */
	List<Type> getListType();
	/**
	 *
	 * @param id Unique object identifier.
	 * @return Object of class Type.
	 */
	Type getType(int id);
}