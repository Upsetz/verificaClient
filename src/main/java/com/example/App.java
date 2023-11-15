package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        try 
        { 
            System.out.println( "Il client è partito" );
            Socket socket = new Socket("localhost", 3000); //creo il socket e lo connetto al server
            
            Scanner input = new Scanner(System.in); //creo scanner
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //creo bufferedreader che riceve dal server
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());//creo bufferedreader che riceve dal server
            
            System.out.println( "Connessione effettuata" );
            System.out.println("CIAO, digita esci per terminare la partita");

            int risposta = 0;
            do 
            {

                System.out.println("inserisci la parola o lettera");
                String s = input.nextLine();
                
                out.writeBytes(s);
                    
                String st = in.readLine();

                if(s == "2"){

                    System.out.println("questa lettera non è nella parola");
                }
                else{

                    System.out.println("questa lettera è nella parola");
                    System.out.println(s);
                }
/* 
                }
                if(risposta == 2)
                {
                    System.out.println( "Numero troppo grande" );
                }
                if(risposta == 3)
                {
                    System.out.println( "Numero indovinato" );
                }*/
            } while (risposta != 3);
            input.close(); //chiudo scanner
            socket.close(); //termino soket
        } 
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("errore durante l'istanza del server");
            System.exit(1);
        }
    }
}