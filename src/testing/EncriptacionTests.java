package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import util.Encriptacion;

public class EncriptacionTests {

	@Test
	public void testEncriptar() {
		assertEquals(Encriptacion.encriptar("user_password", "TEa57qObF1dxrimT", "Me van a encriptar"), "Rk2i/6rmbhyUqjXoXWxQnQnPtbGyKLbw78GRgUGchc8=");
		assertEquals(Encriptacion.encriptar("user_password_2", "4AyOtZ9ueZK1Fmad", "Texto de prueba"), "ntm78thAsHOjd0FbAEB2rg==");
		assertEquals(Encriptacion.encriptar("contrasena", "6O5SQUYfukYswBbq", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer maximus tellus eget lorem scelerisque pharetra. Quisque cursus sodales blandit."), "cOrSHc20DnSboxKk8iNOBNha4v3b2Sfo25CwFIHiWsMxqBrMrXhxyB+5Ch61Ww/Ju81Ka1nCWir663jpdujP7oyV7y9i5W8I8YvvYReTcTaW8qbABI3M51yCiRF3Zs6iWqqgF8NYHtdDBRW2/Iyo6tBMAVpbyjw43wzmTGkwBfDckmJb114uVllFMuAn0xL/p29kUdwA0pJE9z7I1GtgyA==");
	}

	@Test
	public void testDecriptar() {
		assertEquals(Encriptacion.decriptar("user_password", "TEa57qObF1dxrimT", "Rk2i/6rmbhyUqjXoXWxQnQnPtbGyKLbw78GRgUGchc8="), "Me van a encriptar");
		assertEquals(Encriptacion.decriptar("user_password_2", "4AyOtZ9ueZK1Fmad", "ntm78thAsHOjd0FbAEB2rg=="), "Texto de prueba");
		assertEquals(Encriptacion.decriptar("contrasena", "6O5SQUYfukYswBbq", "cOrSHc20DnSboxKk8iNOBNha4v3b2Sfo25CwFIHiWsMxqBrMrXhxyB+5Ch61Ww/Ju81Ka1nCWir663jpdujP7oyV7y9i5W8I8YvvYReTcTaW8qbABI3M51yCiRF3Zs6iWqqgF8NYHtdDBRW2/Iyo6tBMAVpbyjw43wzmTGkwBfDckmJb114uVllFMuAn0xL/p29kUdwA0pJE9z7I1GtgyA=="), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer maximus tellus eget lorem scelerisque pharetra. Quisque cursus sodales blandit.");
	}

	@Test
	public void testTodoOk() {
		assertTrue(Encriptacion.errores("user_password", "TEa57qObF1dxrimT", "Me van a encriptar").isEmpty());
		assertFalse(Encriptacion.errores("user_password_2", "4AyOtZ9ueZK1Fma", "Texto de prueba").isEmpty());
		assertFalse(Encriptacion.errores("contrasena123456789", "6O5SQUYfukYswBbq", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.").isEmpty());
		assertFalse(Encriptacion.errores("contrasena123456789", "6O5SQUYfukYswBbq4", "").isEmpty());
	}

	@Test
	public void testPw16Char() {
		assertEquals(Encriptacion.pw16Char("clave"), "clave00000000000");
		assertEquals(Encriptacion.pw16Char("contrasenalarga"), "contrasenalarga0");
		assertEquals(Encriptacion.pw16Char("c"), "c000000000000000");
			
		
	}

}
