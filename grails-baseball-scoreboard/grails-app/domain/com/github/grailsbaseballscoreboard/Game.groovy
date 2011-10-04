package com.github.grailsbaseballscoreboard

class Game {

    Team homeTeam
    Team awayTeam

    static belongsTo = {homeTeam : Team; awayTeam : Team}

    static hasMany = [innings : Inning]

    static constraints = {
        homeTeam(nullable:false)
        awayTeam(nullable:false)
    }

    @Override
    public String toString() {
        return "$homeTeam  vs $awayTeam"
    }
}
