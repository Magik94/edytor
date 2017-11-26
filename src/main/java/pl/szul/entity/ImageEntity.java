package pl.szul.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.szul.domain.Action;

import java.io.Serializable;

/**
 * Created by Dawid on 29.05.2017.
 */
@Document
public class ImageEntity{
    @Id
    private String id;
    private byte[] image;
    private Action action;
    private String name;

    public ImageEntity() {
    }

    public ImageEntity(byte[] image, Action action, String name) {
        this.image = image;
        this.action = action;
        this.name = name;
    }

    public ImageEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
