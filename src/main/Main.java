package main;

import util.Encriptacion;

public class Main {
	public static void main(String[] args) {
		
		String clave = "user_password_2"; //Máximo 16 caracteres (12 bits)
		String iv = "4AyOtZ9ueZK1Fmad";	//16 caracteres
		String mensaje = "Texto de prueba";
		
		String encriptado = Encriptacion.encriptar(clave, iv, mensaje);
		String desencriptado = Encriptacion.decriptar(clave, iv, encriptado);
		
		System.out.println("Encriptado: " + encriptado);
		System.out.println("Desencriptado: " + desencriptado);
		
	}
	
	
	
}
