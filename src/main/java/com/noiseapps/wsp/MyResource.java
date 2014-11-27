package com.noiseapps.wsp;

import com.noiseapps.wsp.bean.Book;
import com.noiseapps.wsp.bean.BookStore;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Collection;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("books")
public class MyResource {

    private static BookStore bookStore = new BookStore();


    @GET
    @Produces({"application/xml", "application/json"})
    public Collection<Book> getAllBooks(){
        return bookStore.getAllBooks();
    }


    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Response getBookAsXmlOrJson(@PathParam("id")int id){
        Book book = bookStore.getOneBook(id);
        if(book != null) {
            return Response.ok(book).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Book with id: " + id + " not found").build();
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public Response addNewBook(@Context UriInfo uriInfo, Book book){
        if(bookStore.getOneBook(book.getId()) != null){
            return Response.status(Response.Status.NOT_MODIFIED).entity("A book already exists with id: " + book.getId()).build();
        }
        try{
            bookStore.addOrUpdate(book);
        }catch (NullPointerException npe) {
            return Response.status(Response.Status.NOT_MODIFIED).entity("Failed to add book with id: " + book.getId()).build();
        }
        return Response.created(uriInfo.getAbsolutePath()).build();
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public Response updateBook(Book book){
        if(bookStore.getOneBook(book.getId()) == null){
            return Response.status(Response.Status.NOT_FOUND).entity("No book found for id: " + book.getId()).build();
        }
        try{
            bookStore.addOrUpdate(book);
        }catch (NullPointerException npe) {
            return Response.status(Response.Status.NOT_MODIFIED).entity("Failed to modify book with id: " + book.getId()).build();
        }
        Book newBook = bookStore.getOneBook(book.getId());
        return Response.ok(newBook).build();
    }

    @DELETE
    @Path("{id}")
    public Response removeBook(@PathParam("id") int id){
        if(bookStore.getOneBook(id) == null){
            return Response.status(Response.Status.NOT_FOUND).entity("No book found for id: " + id).build();
        }
        Book deletedBook = bookStore.delete(id);
        if(deletedBook != null){
            return Response.ok(deletedBook).build();
        }
        return Response.status(Response.Status.NOT_MODIFIED).entity("Failed to remove book with id: " + id).build();
    }
}
