package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private int id;
    private String firstname;
    private String surname;
    private String lastname;
    private String birthday;
    private List<Message> messages = new ArrayList<>();

    public int getId() {
        return id;
        }
   public void setId(int id) {
        this.id = id; 
       }
  

   public String getFirstname() {
       return firstname;
   }

   public void setFirstname(String firstname) {
       this.firstname = firstname;
   }

   public String getSurname() {
       return surname;
   }

   public void setSurname(String surname) {
       this.surname = surname;
   }

   public String getLastname() {
       return lastname;
   }

   public void setLastname(String lastname) {
       this.lastname = lastname;
   }

   public String getBirthday() {
       return birthday;
   }

   public void setBirthday(String birthday) {
       this.birthday = birthday;
   }

   public List<Message> getMessages() {
    return messages;
}

public void setMessages(List<Message> messages) {
    this.messages = messages;
}
}
