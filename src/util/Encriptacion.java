package util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class Encriptacion {
	
	

    public static String encriptar(String clave, String iv, String value) {
        try {
        	
        	if(errores(clave, iv, value).isEmpty()){
	        	clave = pw16Char(clave);
	            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	            SecretKeySpec sks = new SecretKeySpec(clave.getBytes("UTF-8"), "AES");
	            cipher.init(Cipher.ENCRYPT_MODE, sks, new IvParameterSpec(iv.getBytes()));
	
	            byte[] encriptado = cipher.doFinal(value.getBytes());
	            return DatatypeConverter.printBase64Binary(encriptado);
        	} else{
        		System.err.println(errores(clave, iv, value));
        	}
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

	public static String decriptar(String clave, String iv, String encriptado) {
        try {
        	if(errores(clave, iv, encriptado).isEmpty()){
        		clave = pw16Char(clave);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            SecretKeySpec sks = new SecretKeySpec(clave.getBytes("UTF-8"), "AES");
            cipher.init(Cipher.DECRYPT_MODE, sks, new IvParameterSpec(iv.getBytes()));

            byte[] dec = cipher.doFinal(DatatypeConverter.parseBase64Binary(encriptado));
            return new String(dec);
        	} else{
        		System.err.println(errores(clave, iv, encriptado));
        	}
        	
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }
    

    public static String errores(String clave, String iv, String mensaje) {
		
    	String error = "";
    	
    	if(clave.length() > 16){
    		error += "La clave debe ser menor o igual a 16 caracteres.\n";
    	} else if(clave.isEmpty()){
    		error += "La clave esta vacia.\n";
    	} 
    	
    	if(iv.length() != 16){
    		error += "El IV debe ser igual a 16 caracteres.\n";
    	} else if(iv.isEmpty()){
    		error += "El IV esta vacio.\n";
    	} 
    	
    	if(mensaje.isEmpty()){
    		error += "El mensaje esta vacio.\n";
    	} 
    	
    	return error;
    	
	}     
    
    public static String pw16Char(String pw){
		while (pw.length() < 16) {
			pw+="0";
		}
		
		return pw;		
	}

    
}