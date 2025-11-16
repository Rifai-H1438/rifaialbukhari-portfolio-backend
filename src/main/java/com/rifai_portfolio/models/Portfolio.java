package com.rifai_portfolio.models;

import jakarta.persistence.*;

    @Entity
    @Table(name = "portfolio")
    public class Portfolio {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(columnDefinition = "JSON")
        private String data;

        public Portfolio() {}

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getData() { return data; }
        public void setData(String data) { this.data = data; }
    }
