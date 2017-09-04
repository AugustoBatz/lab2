/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labo2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AUGUSTO-BTZ
 */
public class detector {
    
    int ext(String dir)
    {
         byte jpg[]={74,70,73,70}; 
         byte png[]={80,78,71};
         byte exe[]={77,90};
         byte gif[]={71,73,70,56,57,97};
         byte zip[]={80,75};
         byte bmp[]={66,77};
         
        
         try
            {
            FileReader archivo = new FileReader(dir);
            int caracter = archivo.read();
            for(int x=0;x<10;x++)
            {
                if(x==0&&caracter==zip[0])
                    
                {
                    caracter = archivo.read();
                    if(caracter==zip[1])
                    {
                        return 4;
                    }
                }
                if(x==0&&caracter==bmp[0])
                    
                {
                    caracter = archivo.read();
                    if(caracter==bmp[1])
                    {
                        return 5;
                    }
                }
                if(x==0&&caracter==gif[0])
                {
                    caracter = archivo.read();
                    if(caracter==gif[1])
                    {
                        caracter = archivo.read();   
                        if(caracter==gif[2])
                        {
                            caracter = archivo.read();
                            if(caracter==gif[3])
                            {
                                caracter = archivo.read();   
                                if(caracter==gif[4])
                                {
                                    caracter = archivo.read();   
                                     if(caracter==gif[5])
                                     {
                                        return 3;  
                     
                                     }
                                }
                            }
                     
                        }
                     
                    }
                }
                    if(x==0&&caracter==exe[0])
                    {
                       caracter = archivo.read();
                      if(caracter==exe[1])
                      {
                      return 2;
                      }
                    }
                    if(x==1&&caracter==png[0])
                    {
                      caracter = archivo.read();
                      if(caracter==png[1])
                      {
                          caracter = archivo.read();
                          if(caracter==png[2])
                          {
                              return 0;
                          }
                      }
                      
                    }
                     if(x==6&&caracter==jpg[0])
                    {
                      caracter = archivo.read();
                      if(caracter==jpg[1])
                      {
                          caracter = archivo.read();
                          if(caracter==jpg[2])
                          {
                              caracter = archivo.read();
                              if(caracter==jpg[3])
                              {
                                  return 1;
                              }
                              
                          }
                      }
                    }
                if(x==7)
                {
                    return -1;
                }
                caracter = archivo.read();    
            }
            archivo.close();
           
            }
            catch (FileNotFoundException ex)
            {
            Logger.getLogger(detector.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (IOException ex)
            {
            Logger.getLogger(detector.class.getName()).log(Level.SEVERE, null, ex);
            }
                       
        return -2;
        
    }
}
