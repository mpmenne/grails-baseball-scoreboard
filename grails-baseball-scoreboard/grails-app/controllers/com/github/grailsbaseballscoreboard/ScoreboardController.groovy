package com.github.grailsbaseballscoreboard

class ScoreboardController {

    def index = {
        redirect(action: "show", params: params)

    }

    def show = {
        println("Games" + Game.list())
        def homeTeam = params.homeTeamName
        def awayTeam = params.awayTeamName
        println("home team " + homeTeam + " away team " + awayTeam)
        if (!homeTeam || !awayTeam) {
//            flash.message = message(code: 'default.not.found.message', args: [message(code: 'team.label', default: 'Team'), params.id])
            redirect(action: "list")
        }
        else {
            [homeTeam: homeTeam, awayTeam: awayTeam]
        }
    }
}
