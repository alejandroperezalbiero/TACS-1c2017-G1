/**
 * 
 */
package com.UTNFRBATACS1c2017.app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author facundo91
 *
 */
public class TestGestionadorAdministrativo {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGestionadorAdministrativo() throws Exception{
		GestionadorAdministrativo gestionadorAdministrativo = new GestionadorAdministrativo();
		assertNotNull(gestionadorAdministrativo);
	}

}