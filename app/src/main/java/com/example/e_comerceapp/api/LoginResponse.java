package com.example.e_comerceapp.api;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("data")
    private Data data;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    // Getters and setters for data, message, and status

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static class Data {

        @SerializedName("refresh")
        private String refresh;

        @SerializedName("access")
        private String access;

        @SerializedName("user")
        private User user;

        // Getters and setters for refresh, access, and user

        public String getRefresh() {
            return refresh;
        }

        public void setRefresh(String refresh) {
            this.refresh = refresh;
        }

        public String getAccess() {
            return access;
        }

        public void setAccess(String access) {
            this.access = access;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public static class User {

            @SerializedName("id")
            private int id;

            @SerializedName("last_login")
            private String lastLogin;

            @SerializedName("username")
            private String username;

            @SerializedName("first_name")
            private String firstName;

            @SerializedName("last_name")
            private String lastName;

            @SerializedName("email")
            private String email;

            // Getters and setters for id, lastLogin, username, firstName, lastName, email...

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLastLogin() {
                return lastLogin;
            }

            public void setLastLogin(String lastLogin) {
                this.lastLogin = lastLogin;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }
        }
    }
}
