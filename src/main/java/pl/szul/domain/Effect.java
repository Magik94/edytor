/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.szul.domain;

import java.awt.image.BufferedImage;

/**
 *
 * @author dominiq
 */
public class Effect {
    
    BufferedImage img;
    
    public Effect(BufferedImage tmp){
        this.img = tmp;
    }
    
    public BufferedImage getImage(){
        return this.img;
    }
}
