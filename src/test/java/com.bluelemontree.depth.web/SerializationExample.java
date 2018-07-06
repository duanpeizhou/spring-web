package com.bluelemontree.depth.web;

/**
 * @author duanpeizhou on 2018/7/3 下午8:17.
 */

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SerializationExample {

    public static void main(String[] args) throws IOException, ParseException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateFormatter = LocalDateTime.now().format(formatter);
        System.out.println(dateFormatter);

        ObjectMapper mapper = new ObjectMapper();
        Album album = new Album("Kind Of Blue");
        album.setLinks(new String[]{"link1", "link2"});
        List songs = new ArrayList();
        songs.add("So What");
        songs.add("Flamenco Sketches");
        songs.add("Freddie Freeloader");
        album.setSongs(songs);
        Artist artist = new Artist();
        artist.name = "Miles Davis";
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        artist.birthDate = format.parse("26-05-1926");
        artist.addTime = LocalDateTime.now();
        album.setArtist(artist);
        album.addMusician("Miles Davis", "Trumpet, Band leader");
        album.addMusician("Julian Adderley", "Alto Saxophone");
        album.addMusician("Paul Chambers", "double bass");
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy");
        mapper.setDateFormat(outputFormat);

        JavaTimeModule javaTimeModule = new JavaTimeModule();
        LocalDateTimeSerializer serializer = new LocalDateTimeSerializer(formatter);
        javaTimeModule.addSerializer(LocalDateTime.class, serializer);
        mapper.registerModule(javaTimeModule);


        mapper.setPropertyNamingStrategy(new PropertyNamingStrategy() {
            @Override
            public String nameForField(MapperConfig<?> config, AnnotatedField field, String defaultName) {
                if (field.getFullName().equals("com.studytrails.json.jackson.Artist#name"))
                    return "Artist-Name";
                return super.nameForField(config, field, defaultName);
            }

            @Override
            public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
                if (method.getAnnotated().getDeclaringClass().equals(Album.class) && defaultName.equals("title"))
                    return "Album-Title";
                return super.nameForGetterMethod(config, method, defaultName);
            }
        });
        mapper.setSerializationInclusion(Include.NON_EMPTY);
        mapper.writeValue(System.out, album);
    }
}

class Album {
    private String title;
    private String[] links;
    private List songs = new ArrayList();
    private Artist artist;
    private Map musicians = new HashMap();

    public Album(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setLinks(String[] links) {
        this.links = links;
    }

    public String[] getLinks() {
        return links;
    }

    public void setSongs(List songs) {
        this.songs = songs;
    }

    public List getSongs() {
        return songs;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Artist getArtist() {
        return artist;
    }

    public Map getMusicians() {
        return Collections.unmodifiableMap(musicians);
    }

    public void addMusician(String key, String value) {
        musicians.put(key, value);
    }
}

class Artist {
    public String name;
    public Date birthDate;
    public LocalDateTime addTime;
    public int age;
    public String homeTown;
    public List awardsWon = new ArrayList();
}

