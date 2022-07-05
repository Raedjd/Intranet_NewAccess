package com.nwa.intraservice.service;

import com.flickr4java.flickr.FlickrException;

import java.io.InputStream;

public interface IFlickrService {

    String savePic(InputStream photo , String title) throws FlickrException;
}
