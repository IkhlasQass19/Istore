/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

/**
 *
 * @author WINDOWS 10
 * SUBSCRIBE OUR YOUTUBE CHANNEL -> https://www.youtube.com/channel/UCPgcmw0LXToDn49akUEJBkQ
 * THANKS FOR YOUR SUPPORT : ) 
 */
public class courseData {
    
    private int id;
    private String email;

    public courseData(int id, String email){
        this.id = id;
        this.email = email;
    }
    public int getId(){
        return id;
    }
    public String getEmail(){
        return email;
    }
    
}
