package exceptions;

import jakarta.ws.rs.core.MediaType;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper 
		implements ExceptionMapper<BookNotFoundException> {
	
	public NotFoundExceptionMapper() {
		
	}
	
	@Override
	public Response toResponse(BookNotFoundException exception) {
		Response response = null;
		return response;
	}
}