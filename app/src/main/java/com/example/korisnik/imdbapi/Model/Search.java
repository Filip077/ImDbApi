package com.example.korisnik.imdbapi.Model;

/**
 * Created by Korisnik on 17.03.2018.
 */

public class Search {
        private String Title;
        private String Year;
        private String imdbID;
        private String Type;
        private String Poster;

        public Search(String title, String year, String imdbID, String type, String poster) {
            Title = title;
            Year = year;
            this.imdbID = imdbID;
            Type = type;
            Poster = poster;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public void setYear(String year) {
            Year = year;
        }

        public void setImdbID(String imdbID) {
            this.imdbID = imdbID;
        }

        public void setType(String type) {
            Type = type;
        }

        public void setPoster(String poster) {
            Poster = poster;
        }

        public String getTitle() {
            return Title;
        }

        public String getYear() {
            return Year;
        }

        public String getImdbID() {
            return imdbID;
        }

        public String getType() {
            return Type;
        }

        public String getPoster() {
            return Poster;
        }
    }

