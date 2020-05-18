/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;
import java.awt.AWTException;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author Dell-user
 */

class TETRIS 
{
    
public static double getRandomDoubleBetweenRange(double min, double max){
    double x = (Math.random()*((max-min)+1))+min;
    return x;
}
    public static void setstructure(int arr[][])
    {
        arr[0][1]=arr[0][1]+10;
        arr[1][1]=arr[1][1]+10;
        arr[2][1]=arr[2][1]+10;
        arr[3][1]=arr[3][1]+10;
    }
    public static int validmovea(char a[][],int arr[][],char move)
    {
        if((arr[0][1]-1)==-1 || a[arr[0][0]][arr[0][1]-1]=='#')
            return 0;
        if((arr[1][1]-1)==-1 || a[arr[1][0]][arr[1][1]-1]=='#')
            return 0;
        if((arr[2][1]-1)==-1 || a[arr[2][0]][arr[2][1]-1]=='#')
            return 0;
        if((arr[3][1]-1)==-1 || a[arr[3][0]][arr[3][1]-1]=='#')
            return 0;
        return 1;
    }
    public static int validmoved(char a[][],int arr[][],char move)
    {
        if((arr[0][1]+1)==20 || a[arr[0][0]][arr[0][1]+1]=='#')
            return 0;
        if((arr[1][1]+1)==20 || a[arr[1][0]][arr[1][1]+1]=='#')
            return 0;
        if((arr[2][1]+1)==20 || a[arr[2][0]][arr[2][1]+1]=='#')
            return 0;
        if((arr[3][1]+1)==20 || a[arr[3][0]][arr[3][1]+1]=='#')
            return 0;
        return 1;
    }
    public static int validmoves(char a[][],int arr[][],char move)
    {
        if((arr[0][0]+1)==20)
        {
            System.out.println("Invalid Move");
            return 0;
        }
        if(a[arr[0][0]+1][arr[0][1]]=='#')
        {
            System.out.println("GAME OVER");
            return 0;
        }
        if((arr[1][0]+1)==20)
        {
            System.out.println("Invalid Move");
            return 0;
        }
        if(a[arr[1][0]+1][arr[1][1]]=='#')
        {
            System.out.println("GAME OVER");
            return 0;
        }
        if((arr[2][0]+1)==20)
        {
            System.out.println("Invalid Move");
            return 0;
        }
        if(a[arr[2][0]+1][arr[2][1]]=='#')
        {
            System.out.println("GAME OVER");
            return 0;
        }
        if((arr[3][0]+1)==20)
        {
            System.out.println("Invalid Move");
            return 0;
        }
        if(a[arr[3][0]+1][arr[3][1]]=='#')
        {
            System.out.println("GAME OVER");
            return 0;
        }
        return 1;
    }
    public static int movestructure(char a[][],int arr[][],char move,tetris1 t)
    {
        int f=0;
        if(move=='a')
        {
            f=validmovea(a,arr,move);
            if(f==1){
            arr[0][1]=arr[0][1]-1;
            arr[1][1]=arr[1][1]-1;
            arr[2][1]=arr[2][1]-1;
            arr[3][1]=arr[3][1]-1;
            }
            //else 
                //System.out.println("Invalid Move");
        }
        else if(move=='d')
        {
            f=validmoved(a,arr,move);
            if(f==1){
            arr[0][1]=arr[0][1]+1;
            arr[1][1]=arr[1][1]+1;
            arr[2][1]=arr[2][1]+1;
            arr[3][1]=arr[3][1]+1;
            }
            //else 
              //  System.out.println("Invalid Move");
        }
        else if(move=='s')
        {
             f=validmoves(a,arr,move);
             if(f==1){
            arr[0][0]=arr[0][0]+1;
            arr[1][0]=arr[1][0]+1;
            arr[2][0]=arr[2][0]+1;
            arr[3][0]=arr[3][0]+1;
             }
             else
             {
                //System.out.println("Invalid Move");
                return 1;
             }
        }
        return 0;
    }
    public static int validrotatex(char a[][],int arr[][],int i,int l)
    {
                if(i==0){/////////straight lint
                     if(l==0)
                     {
                         if(arr[0][0]+1==-1 ||arr[0][0]+1==20)
                             return 0;
                         if(arr[0][1]+2==-1 ||arr[0][1]+2==20)
                             return 0;
                         
                         if(arr[1][0]==-1 ||arr[1][0]==20)
                             return 0;
                         if(arr[1][1]+1==-1 ||arr[1][1]+1==20)
                             return 0;
                                 
                         if(arr[2][0]-1==-1 ||arr[2][0]-1==20)
                             return 0;
                         if(arr[2][1]==-1 ||arr[2][1]==20)
                             return 0;
                         
                         if(arr[3][0]-2==-1 ||arr[3][0]-2==20)
                             return 0;
                         if(arr[3][1]-1==-1 ||arr[3][1]-1==20)
                             return 0;
                     }
                     else if(l==1)
                     {
                         if(arr[0][0]+2==-1 ||arr[0][0]+2==20)
                             return 0;
                         if(arr[0][1]-2==-1 ||arr[0][1]-2==20)
                             return 0;
                         
                         if(arr[1][0]+1==-1 ||arr[1][0]+1==20)
                             return 0;
                         if(arr[1][1]-1==-1 ||arr[1][1]-1==20)
                             return 0;
                                 
                         if(arr[2][0]==-1 ||arr[2][0]==20)
                             return 0;
                         if(arr[2][1]==-1 ||arr[2][1]==20)
                             return 0;
                         
                         if(arr[3][0]-1==-1 ||arr[3][0]-1==20)
                             return 0;
                         if(arr[3][1]+1==-1 ||arr[3][1]+1==20)
                             return 0;
                     }
                     else if(l==2)
                     {
                         if(arr[0][0]-2==-1 ||arr[0][0]-2==20)
                             return 0;
                         if(arr[0][1]-1==-1 ||arr[0][1]-1==20)
                             return 0;
                         
                         if(arr[1][0]-1==-1 ||arr[1][0]-1==20)
                             return 0;
                         if(arr[1][1]==-1 ||arr[1][1]==20)
                             return 0;
                                 
                         if(arr[2][0]==-1 ||arr[2][0]==20)
                             return 0;
                         if(arr[2][1]+1==-1 ||arr[2][1]+1==20)
                             return 0;
                         
                         if(arr[3][0]+1==-1 ||arr[3][0]+1==20)
                             return 0;
                         if(arr[3][1]+2==-1 ||arr[3][1]+2==20)
                             return 0;
                     }
                     else if(l==3)
                     {
                         if(arr[0][0]-1==-1 ||arr[0][0]-1==20)
                             return 0;
                         if(arr[0][1]+1==-1 ||arr[0][1]+1==20)
                             return 0;
                         
                         if(arr[1][0]==-1 ||arr[1][0]==20)
                             return 0;
                         if(arr[1][1]==-1 ||arr[1][1]==20)
                             return 0;
                                 
                         if(arr[2][0]+1==-1 ||arr[2][0]+1==20)
                             return 0;
                         if(arr[2][1]-1==-1 ||arr[2][1]-1==20)
                             return 0;
                         
                         if(arr[3][0]+2==-1 ||arr[3][0]+2==20)
                             return 0;
                         if(arr[3][1]-2==-1 ||arr[3][1]-2==20)
                             return 0;
                     }
                    }
                else if(i==1){///////// L shaped
                    if(l==0)
                     {
                         if(arr[0][0]==-1 ||arr[0][0]==20)
                             return 0;
                         if(arr[0][1]+2==-1 ||arr[0][1]+2==20)
                             return 0;
                         
                         if(arr[1][0]-1==-1 ||arr[1][0]-1==20)
                             return 0;
                         if(arr[1][1]+1==-1 ||arr[1][1]+1==20)
                             return 0;
                                 
                         if(arr[2][0]-2==-1 ||arr[2][0]-2==20)
                             return 0;
                         if(arr[2][1]==-1 ||arr[2][1]==20)
                             return 0;
                         
                         if(arr[3][0]-1==-1 ||arr[3][0]-1==20)
                             return 0;
                         if(arr[3][1]-1==-1 ||arr[3][1]-1==20)
                             return 0;
                     }
                     else if(l==1)
                     {
                         if(arr[0][0]+2==-1 ||arr[0][0]+2==20)
                             return 0;
                         if(arr[0][1]-1==-1 ||arr[0][1]-1==20)
                             return 0;
                         
                         if(arr[1][0]+1==-1 ||arr[1][0]+1==20)
                             return 0;
                         if(arr[1][1]==-1 ||arr[1][1]==20)
                             return 0;
                                 
                         if(arr[2][0]==-1 ||arr[2][0]==20)
                             return 0;
                         if(arr[2][1]+1==-1 ||arr[2][1]+1==20)
                             return 0;
                         
                         if(arr[3][0]-1==-1 ||arr[3][0]-1==20)
                             return 0;
                         if(arr[3][1]==-1 ||arr[3][1]==20)
                             return 0;
                     }
                     else if(l==2)
                     {
                         if(arr[0][0]-1==-1 ||arr[0][0]-1==20)
                             return 0;
                         if(arr[0][1]-1==-1 ||arr[0][1]-1==20)
                             return 0;
                         
                         if(arr[1][0]==-1 ||arr[1][0]==20)
                             return 0;
                         if(arr[1][1]==-1 ||arr[1][1]==20)
                             return 0;
                                 
                         if(arr[2][0]+1==-1 ||arr[2][0]+1==20)
                             return 0;
                         if(arr[2][1]+1==-1 ||arr[2][1]+1==20)
                             return 0;
                         
                         if(arr[3][0]==-1 ||arr[3][0]==20)
                             return 0;
                         if(arr[3][1]+2==-1 ||arr[3][1]+2==20)
                             return 0;
                     }
                     else if(l==3)
                     {
                         if(arr[0][0]-1==-1 ||arr[0][0]-1==20)
                             return 0;
                         if(arr[0][1]==-1 ||arr[0][1]==20)
                             return 0;
                         
                         if(arr[1][0]==-1 ||arr[1][0]==20)
                             return 0;
                         if(arr[1][1]-1==-1 ||arr[1][1]-1==20)
                             return 0;
                                 
                         if(arr[2][0]+1==-1 ||arr[2][0]+1==20)
                             return 0;
                         if(arr[2][1]-2==-1 ||arr[2][1]-2==20)
                             return 0;
                         
                         if(arr[3][0]+2==-1 ||arr[3][0]+2==20)
                             return 0;
                         if(arr[3][1]-1==-1 ||arr[3][1]-1==20)
                             return 0;
                     }
                }
                else if(i==2){///////////reversed L shaped
                    if(l==0)
                     {
                         if(arr[0][0]+1==-1 ||arr[0][0]+1==20)
                             return 0;
                         if(arr[0][1]+1==-1 ||arr[0][1]+1==20)
                             return 0;
                         
                         if(arr[1][0]==-1 ||arr[1][0]==20)
                             return 0;
                         if(arr[1][1]==-1 ||arr[1][1]==20)
                             return 0;
                                 
                         if(arr[2][0]-1==-1 ||arr[2][0]-1==20)
                             return 0;
                         if(arr[2][1]-1==-1 ||arr[2][1]-1==20)
                             return 0;
                         
                         if(arr[3][0]-2==-1 ||arr[3][0]-2==20)
                             return 0;
                         if(arr[3][1]==-1 ||arr[3][1]==20)
                             return 0;
                     }
                     else if(l==1)
                     {
                         if(arr[0][0]+1==-1 ||arr[0][0]+1==20)
                             return 0;
                         if(arr[0][1]-2==-1 ||arr[0][1]-2==20)
                             return 0;
                         
                         if(arr[1][0]==-1 ||arr[1][0]==20)
                             return 0;
                         if(arr[1][1]-1==-1 ||arr[1][1]-1==20)
                             return 0;
                                 
                         if(arr[2][0]-1==-1 ||arr[2][0]-1==20)
                             return 0;
                         if(arr[2][1]==-1 ||arr[2][1]==20)
                             return 0;
                         
                         if(arr[3][0]==-1 ||arr[3][0]==20)
                             return 0;
                         if(arr[3][1]+1==-1 ||arr[3][1]+1==20)
                             return 0;
                     }
                     else if(l==2)
                     {
                         if(arr[0][0]-2==-1 ||arr[0][0]-2==20)
                             return 0;
                         if(arr[0][1]==-1 ||arr[0][1]==20)
                             return 0;
                         
                         if(arr[1][0]-1==-1 ||arr[1][0]-1==20)
                             return 0;
                         if(arr[1][1]+1==-1 ||arr[1][1]+1==20)
                             return 0;
                                 
                         if(arr[2][0]==-1 ||arr[2][0]==20)
                             return 0;
                         if(arr[2][1]+2==-1 ||arr[2][1]+2==20)
                             return 0;
                         
                         if(arr[3][0]+1==-1 ||arr[3][0]+1==20)
                             return 0;
                         if(arr[3][1]+1==-1 ||arr[3][1]+1==20)
                             return 0;
                     }
                     else if(l==3)
                     {
                         if(arr[0][0]==-1 ||arr[0][0]==20)
                             return 0;
                         if(arr[0][1]+1==-1 ||arr[0][1]+1==20)
                             return 0;
                         
                         if(arr[1][0]+1==-1 ||arr[1][0]+1==20)
                             return 0;
                         if(arr[1][1]==-1 ||arr[1][1]==20)
                             return 0;
                                 
                         if(arr[2][0]+2==-1 ||arr[2][0]+2==20)
                             return 0;
                         if(arr[2][1]-1==-1 ||arr[2][1]-1==20)
                             return 0;
                         
                         if(arr[3][0]+1==-1 ||arr[3][0]+1==20)
                             return 0;
                         if(arr[3][1]-2==-1 ||arr[3][1]-2==20)
                             return 0;
                     }
                    }
                if(i==3){//////////square
                    
                }
                if(i==5){//////////Z shape
                    if(l==0)
                     {
                         if(arr[0][0]==-1 ||arr[0][0]==20)
                             return 0;
                         if(arr[0][1]+1==-1 ||arr[0][1]+1==20)
                             return 0;
                         
                         if(arr[1][0]+1==-1 ||arr[1][0]+1==20)
                             return 0;
                         if(arr[1][1]==-1 ||arr[1][1]==20)
                             return 0;
                                 
                         if(arr[2][0]==-1 ||arr[2][0]==20)
                             return 0;
                         if(arr[2][1]-1==-1 ||arr[2][1]-1==20)
                             return 0;
                         
                         if(arr[3][0]+1==-1 ||arr[3][0]+1==20)
                             return 0;
                         if(arr[3][1]-2==-1 ||arr[3][1]-2==20)
                             return 0;
                     }
                     else if(l==1)
                     {
                         if(arr[0][0]+1==-1 ||arr[0][0]+1==20)
                             return 0;
                         if(arr[0][1]+1==-1 ||arr[0][1]+1==20)
                             return 0;
                         
                         if(arr[1][0]==-1 ||arr[1][0]==20)
                             return 0;
                         if(arr[1][1]==-1 ||arr[1][1]==20)
                             return 0;
                                 
                         if(arr[2][0]-1==-1 ||arr[2][0]-1==20)
                             return 0;
                         if(arr[2][1]+1==-1 ||arr[2][1]+1==20)
                             return 0;
                         
                         if(arr[3][0]-2==-1 ||arr[3][0]-2==20)
                             return 0;
                         if(arr[3][1]==-1 ||arr[3][1]==20)
                             return 0;
                     }
                     else if(l==2)
                     {
                         if(arr[0][0]+1==-1 ||arr[0][0]+1==20)
                             return 0;
                         if(arr[0][1]-2==-1 ||arr[0][1]-2==20)
                             return 0;
                         
                         if(arr[1][0]==-1 ||arr[1][0]==20)
                             return 0;
                         if(arr[1][1]-1==-1 ||arr[1][1]-1==20)
                             return 0;
                                 
                         if(arr[2][0]+1==-1 ||arr[2][0]+1==20)
                             return 0;
                         if(arr[2][1]==-1 ||arr[2][1]==20)
                             return 0;
                         
                         if(arr[3][0]==-1 ||arr[3][0]==20)
                             return 0;
                         if(arr[3][1]+1==-1 ||arr[3][1]+1==20)
                             return 0;
                     }
                     else if(l==3)
                     {
                         if(arr[0][0]-2==-1 ||arr[0][0]-2==20)
                             return 0;
                         if(arr[0][1]==-1 ||arr[0][1]==20)
                             return 0;
                         
                         if(arr[1][0]-1==-1 ||arr[1][0]-1==20)
                             return 0;
                         if(arr[1][1]+1==-1 ||arr[1][1]+1==20)
                             return 0;
                                 
                         if(arr[2][0]==-1 ||arr[2][0]==20)
                             return 0;
                         if(arr[2][1]==-1 ||arr[2][1]==20)
                             return 0;
                         
                         if(arr[3][0]+1==-1 ||arr[3][0]+1==20)
                             return 0;
                         if(arr[3][1]+1==-1 ||arr[3][1]+1==20)
                             return 0;
                     }
                }
                if(i==6){///////////////T shape
                    if(l==0)
                     {
                         if(arr[0][0]==-1 ||arr[0][0]==20)
                             return 0;
                         if(arr[0][1]+1==-1 ||arr[0][1]+1==20)
                             return 0;
                         
                         if(arr[1][0]+1==-1 ||arr[1][0]+1==20)
                             return 0;
                         if(arr[1][1]==-1 ||arr[1][1]==20)
                             return 0;
                                 
                         if(arr[2][0]+2==-1 ||arr[2][0]+2==20)
                             return 0;
                         if(arr[2][1]-1==-1 ||arr[2][1]-1==20)
                             return 0;
                         
                         if(arr[3][0]==-1 ||arr[3][0]==20)
                             return 0;
                         if(arr[3][1]-1==-1 ||arr[3][1]-1==20)
                             return 0;
                     }
                     else if(l==1)
                     {
                         if(arr[0][0]+1==-1 ||arr[0][0]+1==20)
                             return 0;
                         if(arr[0][1]+1==-1 ||arr[0][1]+1==20)
                             return 0;
                         
                         if(arr[1][0]==-1 ||arr[1][0]==20)
                             return 0;
                         if(arr[1][1]==-1 ||arr[1][1]==20)
                             return 0;
                                 
                         if(arr[2][0]-1==-1 ||arr[2][0]-1==20)
                             return 0;
                         if(arr[2][1]-1==-1 ||arr[2][1]-1==20)
                             return 0;
                         
                         if(arr[3][0]-1==-1 ||arr[3][0]-1==20)
                             return 0;
                         if(arr[3][1]+1==-1 ||arr[3][1]+1==20)
                             return 0;
                     }
                     else if(l==2)
                     {
                         if(arr[0][0]+1==-1 ||arr[0][0]+1==20)
                             return 0;
                         if(arr[0][1]-2==-1 ||arr[0][1]-2==20)
                             return 0;
                         
                         if(arr[1][0]==-1 ||arr[1][0]==20)
                             return 0;
                         if(arr[1][1]-1==-1 ||arr[1][1]-1==20)
                             return 0;
                                 
                         if(arr[2][0]-1==-1 ||arr[2][0]-1==20)
                             return 0;
                         if(arr[2][1]==-1 ||arr[2][1]==20)
                             return 0;
                         
                         if(arr[3][0]+1==-1 ||arr[3][0]+1==20)
                             return 0;
                         if(arr[3][1]==-1 ||arr[3][1]==20)
                             return 0;
                     }
                     else if(l==3)
                     {
                         if(arr[0][0]-2==-1 ||arr[0][0]-2==20)
                             return 0;
                         if(arr[0][1]==-1 ||arr[0][1]==20)
                             return 0;
                         
                         if(arr[1][0]-1==-1 ||arr[1][0]-1==20)
                             return 0;
                         if(arr[1][1]+1==-1 ||arr[1][1]+1==20)
                             return 0;
                                 
                         if(arr[2][0]==-1 ||arr[2][0]==20)
                             return 0;
                         if(arr[2][1]+2==-1 ||arr[2][1]+2==20)
                             return 0;
                         
                         if(arr[3][0]==-1 ||arr[3][0]==20)
                             return 0;
                         if(arr[3][1]==-1 ||arr[3][1]==20)
                             return 0;
                     }
                }
        return 1;
    }
    public static int rotatestructure(char a[][],int arr[][],char move,int i,int l)
    {
        int f=0;
        if(move=='x')////////////CLOCKWISE DIRECTION
        {
            f=validrotatex(a,arr,i,l);
            //System.out.println("YES");
            if(f==1){
            switch (i) {
                case 0://///////straight lint
                     if(l==0)
                     {
                         arr[0][0]+=1;
                         arr[0][1]+=2;
                         
                         arr[1][0]+=0;
                         arr[1][1]+=1;
                                 
                         arr[2][0]+=-1;
                         arr[2][1]+=0;
                                 
                         arr[3][0]+=-2;
                         arr[3][1]+=-1;        
                         l++;
                     }
                     else if(l==1)
                     {
                         arr[0][0]+=2;
                         arr[0][1]+=-2;
                         
                         arr[1][0]+=1;
                         arr[1][1]+=-1;
                                 
                         arr[2][0]+=0;
                         arr[2][1]+=0;
                                 
                         arr[3][0]+=-1;
                         arr[3][1]+=1;  
                         l++;
                     }
                     else if(l==2)
                     {
                         arr[0][0]+=-2;
                         arr[0][1]+=-1;
                         
                         arr[1][0]+=-1;
                         arr[1][1]+=0;
                                 
                         arr[2][0]+=0;
                         arr[2][1]+=1;
                                 
                         arr[3][0]+=1;
                         arr[3][1]+=2;  
                         l++;
                     }
                     else if(l==3)
                     {
                         arr[0][0]+=-1;
                         arr[0][1]+=1;
                         
                         arr[1][0]+=0;
                         arr[1][1]+=0;
                                 
                         arr[2][0]+=1;
                         arr[2][1]+=-1;
                                 
                         arr[3][0]+=2;
                         arr[3][1]+=-2;  
                         l=0;
                     }
                    break;
                case 1:///////// L shaped
                    if(l==0)
                     {
                         arr[0][0]+=0;
                         arr[0][1]+=2;
                         
                         arr[1][0]+=-1;
                         arr[1][1]+=1;
                                 
                         arr[2][0]+=-2;
                         arr[2][1]+=0;
                                 
                         arr[3][0]+=-1;
                         arr[3][1]+=-1;        
                         l++;
                     }
                     else if(l==1)
                     {
                         arr[0][0]+=2;
                         arr[0][1]+=-1;
                         
                         arr[1][0]+=1;
                         arr[1][1]+=0;
                                 
                         arr[2][0]+=0;
                         arr[2][1]+=1;
                                 
                         arr[3][0]+=-1;
                         arr[3][1]+=0;  
                         l++;
                     }
                     else if(l==2)
                     {
                         arr[0][0]+=-1;
                         arr[0][1]+=-1;
                         
                         arr[1][0]+=0;
                         arr[1][1]+=0;
                                 
                         arr[2][0]+=1;
                         arr[2][1]+=1;
                                 
                         arr[3][0]+=0;
                         arr[3][1]+=2;  
                         l++;
                     }
                     else if(l==3)
                     {
                         arr[0][0]+=-1;
                         arr[0][1]+=0;
                         
                         arr[1][0]+=0;
                         arr[1][1]+=-1;
                                 
                         arr[2][0]+=1;
                         arr[2][1]+=-2;
                                 
                         arr[3][0]+=2;
                         arr[3][1]+=-1;  
                         l=0;
                     }
                    break;
                case 2:///////////reversed L shaped
                    if(l==0)
                     {
                         arr[0][0]+=1;
                         arr[0][1]+=1;
                         
                         arr[1][0]+=0;
                         arr[1][1]+=0;
                                 
                         arr[2][0]+=-1;
                         arr[2][1]+=-1;
                                 
                         arr[3][0]+=-2;
                         arr[3][1]+=0;        
                         l++;
                     }
                     else if(l==1)
                     {
                         arr[0][0]+=1;
                         arr[0][1]+=-2;
                         
                         arr[1][0]+=0;
                         arr[1][1]+=-1;
                                 
                         arr[2][0]+=-1;
                         arr[2][1]+=0;
                                 
                         arr[3][0]+=0;
                         arr[3][1]+=1;  
                         l++;
                     }
                     else if(l==2)
                     {
                         arr[0][0]+=-2;
                         arr[0][1]+=0;
                         
                         arr[1][0]+=-1;
                         arr[1][1]+=1;
                                 
                         arr[2][0]+=0;
                         arr[2][1]+=2;
                                 
                         arr[3][0]+=1;
                         arr[3][1]+=1;  
                         l++;
                     }
                     else if(l==3)
                     {
                         arr[0][0]+=0;
                         arr[0][1]+=1;
                         
                         arr[1][0]+=1;
                         arr[1][1]+=0;
                                 
                         arr[2][0]+=2;
                         arr[2][1]+=-1;
                                 
                         arr[3][0]+=1;
                         arr[3][1]+=-2;  
                         l=0;
                     }
                    break;
                case 3://////////square
                    if(l==0)
                     {
                         arr[0][0]+=0;
                         arr[0][1]+=0;
                         
                         arr[1][0]+=0;
                         arr[1][1]+=0;
                                 
                         arr[2][0]+=0;
                         arr[2][1]+=0;
                                 
                         arr[3][0]+=0;
                         arr[3][1]+=0;        
                         l++;
                     }
                     else if(l==1)
                     {
                         arr[0][0]+=0;
                         arr[0][1]+=0;
                         
                         arr[1][0]+=0;
                         arr[1][1]+=0;
                                 
                         arr[2][0]+=0;
                         arr[2][1]+=0;
                                 
                         arr[3][0]+=0;
                         arr[3][1]+=0;   
                         l++;
                     }
                     else if(l==2)
                     {
                         arr[0][0]+=0;
                         arr[0][1]+=0;
                         
                         arr[1][0]+=0;
                         arr[1][1]+=0;
                                 
                         arr[2][0]+=0;
                         arr[2][1]+=0;
                                 
                         arr[3][0]+=0;
                         arr[3][1]+=0;  
                         l++;
                     }
                     else if(l==3)
                     {
                         arr[0][0]+=0;
                         arr[0][1]+=0;
                         
                         arr[1][0]+=0;
                         arr[1][1]+=0;
                                 
                         arr[2][0]+=0;
                         arr[2][1]+=0;
                                 
                         arr[3][0]+=0;
                         arr[3][1]+=0; 
                         l=0;
                     }
                    break;
                case 4:////////////reverse Z shape
                    if(l==0)
                     {
                         arr[0][0]+=-1;
                         arr[0][1]+=0;
                         
                         arr[1][0]+=0;
                         arr[1][1]+=-1;
                                 
                         arr[2][0]+=1;
                         arr[2][1]+=0;
                                 
                         arr[3][0]+=2;
                         arr[3][1]+=-1;        
                         l++;
                     }
                     else if(l==1)
                     {
                         arr[0][0]+=0;
                         arr[0][1]+=2;
                         
                         arr[1][0]+=-1;
                         arr[1][1]+=1;
                                 
                         arr[2][0]+=0;
                         arr[2][1]+=0;
                                 
                         arr[3][0]+=-1;
                         arr[3][1]+=-1;  
                         l++;
                     }
                     else if(l==2)
                     {
                         arr[0][0]+=2;
                         arr[0][1]+=-1;
                         
                         arr[1][0]+=1;
                         arr[1][1]+=0;
                                 
                         arr[2][0]+=0;
                         arr[2][1]+=-1;
                                 
                         arr[3][0]+=-1;
                         arr[3][1]+=0;  
                         l++;
                     }
                     else if(l==3)
                     {
                         arr[0][0]+=-1;
                         arr[0][1]+=-1;
                         
                         arr[1][0]+=0;
                         arr[1][1]+=0;
                                 
                         arr[2][0]+=-1;
                         arr[2][1]+=1;
                                 
                         arr[3][0]+=0;
                         arr[3][1]+=2;  
                         l=0;
                     }
                    break;
                case 5://////////Z shape
                    if(l==0)
                     {
                         arr[0][0]+=0;
                         arr[0][1]+=1;
                         
                         arr[1][0]+=1;
                         arr[1][1]+=0;
                                 
                         arr[2][0]+=0;
                         arr[2][1]+=-1;
                                 
                         arr[3][0]+=1;
                         arr[3][1]+=-2;        
                         l++;
                     }
                     else if(l==1)
                     {
                         arr[0][0]+=1;
                         arr[0][1]+=1;
                         
                         arr[1][0]+=0;
                         arr[1][1]+=0;
                                 
                         arr[2][0]+=-1;
                         arr[2][1]+=1;
                                 
                         arr[3][0]+=-2;
                         arr[3][1]+=0;  
                         l++;
                     }
                     else if(l==2)
                     {
                         arr[0][0]+=1;
                         arr[0][1]+=-2;
                         
                         arr[1][0]+=0;
                         arr[1][1]+=-1;
                                 
                         arr[2][0]+=1;
                         arr[2][1]+=0;
                                 
                         arr[3][0]+=0;
                         arr[3][1]+=1;  
                         l++;
                     }
                     else if(l==3)
                     {
                         arr[0][0]+=-2;
                         arr[0][1]+=0;
                         
                         arr[1][0]+=-1;
                         arr[1][1]+=1;
                                 
                         arr[2][0]+=0;
                         arr[2][1]+=0;
                                 
                         arr[3][0]+=1;
                         arr[3][1]+=1;  
                         l=0;
                     }
                    break;
                case 6:///////////////T shape
                    if(l==0)
                     {
                         arr[0][0]+=0;
                         arr[0][1]+=1;
                         
                         arr[1][0]+=1;
                         arr[1][1]+=0;
                                 
                         arr[2][0]+=2;
                         arr[2][1]+=-1;
                                 
                         arr[3][0]+=0;
                         arr[3][1]+=-1;        
                         l++;
                     }
                     else if(l==1)
                     {
                         arr[0][0]+=1;
                         arr[0][1]+=1;
                         
                         arr[1][0]+=0;
                         arr[1][1]+=0;
                                 
                         arr[2][0]+=-1;
                         arr[2][1]+=-1;
                                 
                         arr[3][0]+=-1;
                         arr[3][1]+=1;  
                         l++;
                     }
                     else if(l==2)
                     {
                         arr[0][0]+=1;
                         arr[0][1]+=-2;
                         
                         arr[1][0]+=0;
                         arr[1][1]+=-1;
                                 
                         arr[2][0]+=-1;
                         arr[2][1]+=0;
                                 
                         arr[3][0]+=1;
                         arr[3][1]+=0;  
                         l++;
                     }
                     else if(l==3)
                     {
                         arr[0][0]+=-2;
                         arr[0][1]+=0;
                         
                         arr[1][0]+=-1;
                         arr[1][1]+=1;
                                 
                         arr[2][0]+=0;
                         arr[2][1]+=2;
                                 
                         arr[3][0]+=0;
                         arr[3][1]+=0;  
                         l=0;
                     }
                    break;
                default:
                    break;
            }
            }
        }
        else if(move=='z')///////////////ANTI-CLOCKWISE DIRECTION
        {
            
        }
        return l;
    }
    public static void setboard(int arr[][],char a[][])
    {
        a[arr[0][0]][arr[0][1]]='#';
        a[arr[1][0]][arr[1][1]]='#';
        a[arr[2][0]][arr[2][1]]='#';
        a[arr[3][0]][arr[3][1]]='#';
    }
    public static void print(char a[][])
    {
        int M=20;
        int N=20;
        int i=0;int j=0;
        System.out.print("!");
        for(i=0;i<N;i++)
        {
            System.out.print("!");
        }
        System.out.print("!");
        System.out.print("\n");
        for(i=0;i<M;i++)
        {
            System.out.print("*");
            for(j=0;j<N;j++)
            {
                System.out.print(a[i][j]);
            }
            System.out.print("*\n");
        }
        System.out.print("*");
        for(i=0;i<N;i++)
        {
            System.out.print("*");        }
        System.out.print("*\n");
        
    }
    ////////////////////////////////////SAVE GAME//////////////////////////
    public static void savegame(char a[][],int arr[][],int fre[][],Stack undo,Stack redo,int location,int shape) throws IOException
    {
        FileWriter fw=new FileWriter("save.txt");
        PrintWriter pw=new PrintWriter(fw);
        for(int i=0;i<20;i++)
        {
            for(int j=0;j<20;j++)
            {
                pw.printf("%c",a[i][j]);
                pw.printf("@");
            }
        }
        pw.printf("*");
        for(int i=0;i<20;i++)
        {
            for(int j=0;j<20;j++)
            {
                pw.printf("%d",fre[i][j]);
                pw.printf("*");
            }
        }
        pw.printf("&");
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<2;j++)
            {
                pw.printf("%d",arr[i][j]);
                pw.printf("&");
            }
        }
        pw.printf("^");
        pw.printf("%d",location);
        pw.printf("^");
        pw.printf("$");
        pw.printf("%d",shape);
        pw.printf("+");
        System.out.println("File Saved");
        pw.close();
        fw.close();
        System.exit(0);
    }
    public static void main(String[] args) throws FileNotFoundException, AWTException, IOException 
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Do you want to start a new game or load game?");
        System.out.println("1.New Game\n2.Load Game\n");
        int q=0;
        q=s.nextInt();
        int M=20;
        int N=20;
        tetris1 t = new tetris1('#');
        t.location = 0;
        char a[][];
        a=new char[M][N];
        int fre[][];
        fre=new int[M][N];
        int arr[][]=new int[4][2];
        for(int i=0;i<M;i++)
        {
            for(int j=0;j<N;j++)
            {
                a[i][j]=' ';
                fre[i][j]=0;
            }
        }
        double i=0;
        int x=0;
        int validflag=0;
        Stack undo=new Stack();
        Stack redo=new Stack();
        while(x==0)
        {   
            if(q==2)
            {
                Scanner fr=new Scanner(new File("save.txt"));
                String word = null;
                while(fr.hasNextLine()){
                    word=fr.nextLine();
                }
                char c[]=word.toCharArray();
                System.out.println("LOADING....");
                int fileflag=0;
                for(int m=0;c[m]!='+';m++)
                {
                    
                    if(fileflag==0)
                    {
                        //System.out.println("0");
                        for(int g=0;g<20;g++)
                        {
                            for(int h=0;h<20;h++)
                            {
                                a[g][h]=c[m];
                                m=m+2;
                            }
                        }
                        fileflag++;
                    }
                    else if(fileflag==1)
                    {
                        for(int g=0;g<20;g++)
                        {
                            for(int h=0;h<20;h++)
                            {
                                fre[g][h]=c[m]-'0';
                                m=m+2;
                            }
                        }
                        fileflag++;
                    }
                    else if(fileflag==2)
                    {
                        for(int g=0;g<4;g++)
                        {
                            for(int h=0;h<2;h++)
                            {
                                int temp=0;
                                temp=c[m]-'0';
                                if(c[m+1]=='&'){
                                arr[g][h]=temp;
                                m=m+2;}
                                else
                                {
                                    m++;
                                    temp=temp*10+c[m]-'0';
                                    arr[g][h]=temp;
                                   if(c[m+1]=='&')
                                        m=m+2;
                                }
                            }
                        }
                        fileflag++;
                    }
                    else if(fileflag==3)
                    {
                        t.location=c[m]-'0';
                        m++;
                        fileflag++;
                    }
                    else if(fileflag==4)
                    {
                        m++;
                        i=c[m]-'0';
                        break;
                    }
                }
                q=0;
                print(a);
                System.out.println("LOADED..");
            }
            else
            {
                i=0;
                i= getRandomDoubleBetweenRange(0,7);///////////GENERATES A RANDOM VALUE FOR i
                t.structure(arr, (int)i);
                setstructure(arr);
                if(fre[arr[0][0]][arr[0][0]]==1)
                break;
                else if(fre[arr[0][0]][arr[0][1]]==1)
                break;
                else if(fre[arr[1][0]][arr[1][0]]==1)
                break;
                else if(fre[arr[1][0]][arr[1][1]]==1)
                break;
                else if(fre[arr[2][0]][arr[2][0]]==1)
                break;
                else if(fre[arr[2][0]][arr[2][1]]==1)
                break;
                else if(fre[arr[3][0]][arr[3][0]]==1)
                break;
                else if(fre[arr[3][0]][arr[3][1]]==1)
                break;
                setboard(arr,a);
                print(a);
                t.location = 0;
            }
            char move;
            do
            {
                if(validflag==0)
                undo.push(a,fre,arr,t.location);
                validflag=0;
                int f=0;
                System.out.print("Press Key:");
                move=s.next().charAt(0);
                if(move!='q'){
                a[arr[0][0]][arr[0][1]]=' ';
                a[arr[1][0]][arr[1][1]]=' ';
                a[arr[2][0]][arr[2][1]]=' ';
                a[arr[3][0]][arr[3][1]]=' ';}
                if(move=='s')
                {
                    f=validmoves(a,arr,move);
                    //System.out.println("f=="+f);
                    if(f==0)
                    {
                    setboard(arr,a);
                    //System.exit(0);
                    }
                }
                if(move=='a' || move=='s' || move=='d')
                {
                    
                    if(redo.head!=null)
                        redo.head=null;
                    x=movestructure(a,arr,move,t);
                }
                else if(move=='x')
                {
                    if(redo.head!=null)
                        redo.head=null;
                    //System.out.println("I="+i);
                    t.location=rotatestructure(a,arr,move,(int)i,t.location);
                    //System.out.println("Location="+t.location);
                }
                else if(move=='u')
                {
                    //System.out.println("UNDO");
                    if(undo.head!=null)
                    {
                        redo.push(a,fre,arr,t.location);
                        undo.pop(); 
                    if(undo.head!=null)
                    {for(int g=0;g<M;g++)
                    {
                        for(int h=0;h<N;h++)
                        {
                            a[g][h]=undo.head.data.arr[g][h];
                            fre[g][h]=undo.head.data.frequency[g][h];
                        }
                    }
                    for(int g=0;g<4;g++)
                    {
                        for(int h=0;h<2;h++)
                        {
                            arr[g][h]=undo.head.data.shape[g][h];
                        }
                    }
                    t.location=undo.head.data.loc;
                    undo.pop();
                    
                    }
                    else
                    {
                        System.out.println("Stack Empty");
                        validflag=1;
                    }
                    }
                    else
                    {
                        System.out.println("Stack Empty");
                        validflag=1;
                    }
                }
                else if(move=='r')
                {
                    if(redo.head!=null)
                    {for(int g=0;g<M;g++)
                    {
                        for(int h=0;h<N;h++)
                        {
                            a[g][h]=redo.head.data.arr[g][h];
                            fre[g][h]=redo.head.data.frequency[g][h];
                        }
                    }
                    for(int g=0;g<4;g++)
                    {
                        for(int h=0;h<2;h++)
                        {
                            arr[g][h]=redo.head.data.shape[g][h];
                        }
                    }
                    t.location=redo.head.data.loc;
                    redo.pop();
                    }
                    else
                    {
                        System.out.println("Stack Empty");
                        validflag=1;
                    }
                }
                if(move!='q'){
                setboard(arr,a);
                print(a);}
                if(x==1)
                    break;
            }while(move!='q');
            x=0;
            if(move=='q')
            {
                System.out.print("Do you want to save:?");
                move=s.next().charAt(0);
                if(move=='y')
                {
                    savegame(a,arr,fre,undo,redo,t.location,(int)i);
                }
                else
                {
                  System.out.println("Game Over");
                }
                break;
            }
                fre[arr[0][0]][arr[0][1]]++;
                fre[arr[1][0]][arr[1][1]]++;
                fre[arr[2][0]][arr[2][1]]++;
                fre[arr[3][0]][arr[3][1]]++;
                int signal=0;
                for(int g=M-1;g>=0;g--)
                {
                    signal=0;
                    for(int h=0;h<N;h++)
                    {
                        if(fre[g][h]==0)
                        {
                            signal=1;
                            break;
                        }
                    }
                    if(signal==0)
                    {
                        for(int g1=M-1;g1>0;g1--){
                        for(int h=0;h<N;h++)
                        {
                            a[g1][h]=' ';
                            a[g1][h]=a[g1-1][h];
                            fre[g1][h]=fre[g1-1][h];
                        }
                        }
                    }
                    else
                        break;
                }
            

        }
        
    }
}
    

