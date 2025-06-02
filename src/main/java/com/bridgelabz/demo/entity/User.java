package com.bridgelabz.demo.entity;

    public class User {
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