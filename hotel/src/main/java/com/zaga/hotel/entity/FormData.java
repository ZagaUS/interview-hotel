package com.zaga.hotel.entity;

import java.io.InputStream;

import javax.persistence.Entity;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormData {

    @FormParam("pdfFile")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    public InputStream pdfFile;
}
