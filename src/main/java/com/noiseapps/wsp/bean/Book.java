package com.noiseapps.wsp.bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by tomasz on 27.11.14.
 */

@XmlRootElement
public class Book {

    private Integer id;

    private String author;

    private String title;

    public Book() {}

    public Book(Integer id, String author, String title){
        this.id = id;
        this.author = author;
        this.title = title;
    }

    @XmlAttribute
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlElement
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @XmlElement
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
