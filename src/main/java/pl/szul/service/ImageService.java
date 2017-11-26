package pl.szul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szul.domain.*;
import pl.szul.entity.ImageEntity;
import pl.szul.repository.ImageRepository;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    private ImageEntity imageEntity;

    public byte[] convert(byte[] byteImage, Action action,String name) {

        BufferedImage img = toBufferedImage(byteImage);

        switch(action){
            case SEPIA:
                    Sepia s = new Sepia(img);
                    s.setSepia();
                    return toByteArray(s.getImage(),action,name);

            case BINARYZACJA:
                    Thresholding t = new Thresholding(img);
                    t.setThresholding();
                    return toByteArray(t.getImage(),action,name);

            case SKALA_SZAROSCI:
                    GrayScale gs = new GrayScale(img);
                    gs.setGrayScale();
                    return toByteArray(gs.getImage(),action,name);

            case LUSTRO:
                    Mirror m = new Mirror(img);
                    m.setMirror();
                    return toByteArray(m.getImage(),action,name);

            case NEGATYW:
                    Negative n = new Negative(img);
                    n.setNegative();
                    return toByteArray(img,action,name);

            default:
                throw new RuntimeException("Brak opreacji!!!");
        }
    }


    private BufferedImage toBufferedImage(byte[] imageByte) {
        try {
            InputStream in = new ByteArrayInputStream(imageByte);
            return ImageIO.read(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private byte[] toByteArray(BufferedImage img,Action action,String name) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", baos);

            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            baos.close();
            imageRepository.insert(new ImageEntity(imageInByte,action,name));
            return imageInByte;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String parsestring ()
    {
        String s = imageEntity.getName();
        System.out.println(s+"12");
        String[] tokens = s.split("\\.");
        System.out.println("fick"+ tokens[1]);
        return "tokens[1]";
    }


}
