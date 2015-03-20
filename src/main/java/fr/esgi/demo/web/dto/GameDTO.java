package fr.esgi.demo.web.dto;

/**
 * Created by Thibault on 19/03/15.
 */
public class GameDTO {

    private Long id;
    private String name;
    private Type type;

    public static enum Type {

        RPG, FPS;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public Type getType() {return type;}

    public void setType(Type type) {this.type = type;}



}
