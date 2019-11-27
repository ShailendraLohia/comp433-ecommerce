package com.example.ecommerce.service.link;

import com.example.ecommerce.model.link.Link;

import javax.xml.bind.annotation.XmlElement;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractRepresentation {
    @XmlElement(name="link", namespace="")
    protected List<Link> links;

    public List<Link> getLinks() {

        return links;
    }

    public void setLinks(Link...links) {

        this.links = Arrays.asList(links);
    }
}
