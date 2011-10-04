package com.github.grailsbaseballscoreboard

class Team {

    String teamName
    String city
    String homeStadium

    static constraints = {
        teamName(blank:false)
        city(maxSize:40)
    }

    @Override
    public String toString() {
        return teamName
    }
}
