package com.bridgelabz.demo.entity;

import jakarta.persistence.*;

@Entity // helps in table creation
@Table(name = "User_Data") // used for giving the table name
    public class User {
        @Id // for creating the primary key
        @GeneratedValue //used to automatically generate values for primary key fields
        private int user_id;
        @Column(name = "First_Name")
        private String fName;
        private String lName;
        private double salary;
        private String mail;

        @Override
        public String toString() {
            return "User{" +
                    "fName='" + fName + '\'' +
                    ", lName='" + lName + '\'' +
                    ", salary=" + salary +
                    ", mail='" + mail + '\'' +
                    '}';
        }

        public int getUser_id(){
            return user_id;
        }

        public void setUser_id(int user_id){
            this.user_id = user_id;
        }

        public String getfName() {
            return fName;
        }

        public void setfName(String fName) {
            this.fName = fName;
        }

        public String getlName() {
            return lName;
        }

        public void setlName(String lName) {
            this.lName = lName;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }
    }