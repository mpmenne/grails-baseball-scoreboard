package com.github.grailsbaseballscoreboard

class Inning {

    Integer inningNumber
    Integer runsByHomeTeam
    Integer hitsByHomeTeam
    Integer runsByAwayTeam
    Integer hitsByAwayTeam

    static constraints = {
    }

    static belongsTo = [game : Game]

    @Override
    public String toString() {
        return inningNumber
    }

    @Override
    public boolean equals(Inning inning) { inning.inningNumber == inningNumber }

    @Override
    public int hashcode() { inningNumber.hashCode() }
}
