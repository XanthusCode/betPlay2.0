/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.breaklinestudio.intro.main;
import java.text.ParseException;


/**
 *
 * @author camper
 */
public class Main {

    public static void main(String[] args)  {
        menu m = new menu();
        try {
            m.menu();
        } catch (ParseException ex) {
            System.out.println("Upssss Hubo un error el sistema!!");
        }
    }
}
