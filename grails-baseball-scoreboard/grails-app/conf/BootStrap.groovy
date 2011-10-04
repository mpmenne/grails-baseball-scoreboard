import grails.util.Environment
import com.github.grailsbaseballscoreboard.Team
import com.github.grailsbaseballscoreboard.Game
import com.github.grailsbaseballscoreboard.Inning

class BootStrap {

    def init = { servletContext ->
        switch(Environment.current) {
            case Environment.DEVELOPMENT:
                println "bootstrapping some data baby!"
                Team cardinals = new Team(teamName:"Cardinals", city:"St. Louis", homeStadium: "Busch Stadium").save()
                Team cubs = new Team(teamName:"Cubs", city:"Chicago", homeStadium: "Wrigley Field").save()
                Team phillies = new Team(teamName:"Phillies", city:"Phileadelphia", homeStadium: "Citizens Bank Park").save()
                Team astros = new Team(teamName:"Astros", city:"Houston", homeStadium: "Minute Maid Park").save()
                Game game1 = new Game(homeTeam: cardinals, awayTeam: cubs).save()
//                game1.addToInnings(scorelessInning(1))
//                game1.addToInnings(scorelessInning(2))
//                game1.addToInnings(scorelessInning(3))
//                game1.addToInnings(scorelessInning(4))
//                game1.addToInnings(scorelessInning(5))
//                game1.addToInnings(scorelessInning(6))
//                game1.addToInnings(scorelessInning(7))
//                game1.addToInnings(scorelessInning(8))
//                game1.addToInnings(scorelessInning(9))
//                game1.save()
                Game game2 = new Game(homeTeam: phillies, awayTeam: astros).save()
        }
    }

    static Inning scorelessInning(int inningNumber) {
        Inning inning = new Inning()
        inning.setInningNumber(inningNumber)
        inning.setRunsByAwayTeam(0)
        inning.setRunsByHomeTeam(0)
        return inning
    }

    def destroy = {
    }
}
