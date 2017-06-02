/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalgoritmosjava;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author Gollo
 */
public class Archivo {
    
    private char SEPARATOR=',';
    private char QUOTE='"';
    
    public GeneroList cargarArchivo(String genero) throws IOException{
        
        CsvReader reader= new CsvReader(new FileReader("datos.csv"));
        reader.readHeaders();
        GeneroList g=new GeneroList();
        
        while(reader.readRecord()){
            String code=reader.get(0);
            String title=reader.get(1);
            String gender=reader.get(2);
            String total=reader.get(3);
            String subtitled=reader.get(4);
            String premier=reader.get(5);
            
            if(gender.equals(genero)){
                Pelicula p=new Pelicula(code, title, gender, total, subtitled, premier);
                g.agregarPelicula(p);
            }else if(genero.equals("all")){
                Pelicula p=new Pelicula(code, title, gender, total, subtitled, premier);
                g.agregarPelicula(p);
        }
            
        }
        
        reader.close();
        return g;
    }// cargarArchivo
    
    public void guardarArchivo (GeneroList g) throws IOException{
        CsvWriter writer=new CsvWriter("datos.csv");
        writer.writeRecord(new String[]{"code","title","gender","total","subtitled","premier"},true);
        if(g!=null){
            for(int i=0; i<g.size(); i++){
                writer.writeRecord(new String[]{g.get(i).getCode(),g.get(i).getTitle(),g.get(i).getGender(),g.get(i).getTotal(),g.get(i).getSubtitled(),g.get(i).getPremier()}, true);
            }
        }
        writer.close();
    }// guardarArchivo
    
}// Archivo 
