/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalgoritmosjava;

/**
 *
 * @author Gollo
 */
public class Pelicula {
    
    private String code;
    private String title; 
    private String gender;
    private String total;
    private String subtitled;
    private String premier;

    public Pelicula(String code, String title, String gender, String total, String subtitled, String premier) {
        this.code = code;
        this.title = title;
        this.gender = gender;
        this.total = total;
        this.subtitled = subtitled;
        this.premier = premier;
    }
    
    public Pelicula(){
        this.code = "";
        this.title = "";
        this.gender = "";
        this.total = "";
        this.subtitled = "";
        this.premier = "";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSubtitled() {
        return subtitled;
    }

    public void setSubtitled(String subtitled) {
        this.subtitled = subtitled;
    }

    public String getPremier() {
        return premier;
    }

    public void setPremier(String premier) {
        this.premier = premier;
    }
    
    
    
}// Pelicula
