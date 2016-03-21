package com.scraft.jobrx.exceptions;

import java.sql.SQLException;

public class ScraftException extends SQLException {
	public ScraftException(){
		
	}
	public ScraftException(String message){
		super(message);

}
}
