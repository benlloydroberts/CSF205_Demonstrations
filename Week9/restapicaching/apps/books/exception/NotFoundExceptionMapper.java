package apps.books.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper
		implements ExceptionMapper<BookNotFoundException> {

	public NotFoundExceptionMapper() {
		
	}

	@Override
	public Response toResponse(BookNotFoundException exception) {
		return Response.status(Response.Status.NOT_FOUND)
				.entity(exception.getMessage())
				.type("text/plain").build();
	}

}
